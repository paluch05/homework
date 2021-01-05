package pl.orzechsoft.paluch.tasks.Task28;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.json.JSONObject;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Task28 {

    private static final String CONTEXT = "/phones";

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
        server.createContext(CONTEXT, new MyHttpHandler());
        Executor threadPoolExecutor = Executors.newFixedThreadPool(10);
        server.setExecutor(threadPoolExecutor);
        server.start();
    }

    private static class MyHttpHandler implements HttpHandler {

        Database<Phone> database = new MyDatabase();
        ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {

            String requestMethod = httpExchange.getRequestMethod();
            switch(requestMethod){

                case "GET":
                    try {
                        handleGet(httpExchange);
                    } catch (SQLException | MyDatabaseException e) {
                        e.printStackTrace();
                    }
                    break;

                case "POST":
                    handlePost(httpExchange);
                    break;

                case "DELETE":
                    try {
                        handleDelete(httpExchange);
                    } catch (MyDatabaseException e) {
                        e.printStackTrace();
                    }
                    break;

                case "PUT":
                    handlePut(httpExchange);
                    break;

                default:
                    throw new IOException("Method unsupported");
            }
        }

        private void handleResponse(HttpExchange httpExchange, String content, int code) throws IOException {
            try (OutputStream outputStream = httpExchange.getResponseBody()) {
                if (content != null) {
                    httpExchange.getResponseHeaders().add("Content-Type", "application/json");
                }
                httpExchange.sendResponseHeaders(code, content == null ? 0 : content.length());
                if (content != null) {
                    outputStream.write(content.getBytes());
                }
                outputStream.flush();
            }
        }

        private void handleGet(HttpExchange httpExchange) throws IOException, SQLException, MyDatabaseException {
            String uri = httpExchange.getRequestURI().toString();
            String id = uri.length() > CONTEXT.length() ? uri.substring((CONTEXT + "/").length()) : null;
            String json;
            if (id == null) {
                json = objectMapper.writeValueAsString(database.getAll());
            } else {
                Phone phone = database.get(id);
                if (phone == null) {
                    handleResponse(httpExchange, null, 404);
                    return;
                }
                json = objectMapper.writeValueAsString(database.get(id));
            }
            handleResponse(httpExchange, json, 200);
        }

        private void handlePost(HttpExchange httpExchange) throws IOException {
            if (!CONTEXT.equals(httpExchange.getRequestURI().toString())) {
                handleResponse(httpExchange, null, 400);
                return;
            }
            Phone phone;
            try {
                phone = objectMapper.readValue(httpExchange.getRequestBody(), Phone.class);
            } catch (IOException e) {
                handleResponse(httpExchange, getJsonForException(e.getMessage()), 500);
                return;
            }
            try {
                database.add(phone);
            } catch (Exception e) {
                handleResponse(httpExchange, getJsonForException(e.getMessage()), 500);
                return;
            }
            handleResponse(httpExchange, null, 201);
        }
        private void handlePut (HttpExchange httpExchange) throws IOException {

            Phone phone;
            try {
                phone = objectMapper.readValue(httpExchange.getRequestBody(), Phone.class);
            } catch (IOException e) {
                handleResponse(httpExchange, getJsonForException(e.getMessage()), 500);
                return;
            }

            if(!database.contains(phone.getId())){
                handleResponse(httpExchange, getJsonForException("Phone with id " + phone.getId() + " doesn't exist!"), 404);
            }

            try {
                database.update(phone);
            } catch (Exception e) {
                handleResponse(httpExchange, getJsonForException(e.getMessage()), 500);
                return;
            }
            handleResponse(httpExchange, null, 200);
        }

        private void handleDelete (HttpExchange httpExchange) throws IOException, MyDatabaseException {

            String query = httpExchange.getRequestURI().getQuery();
            String[] splittedQuery = query.split("&");

            if(splittedQuery.length > 1) {
                handleResponse(httpExchange, getJsonForException("Expected one query, but got: " + splittedQuery.length), 500);
            }

            String phoneId = splittedQuery[0].split("=")[1];

            boolean phoneExists = database.contains(phoneId);
            if(!phoneExists){
                handleResponse(httpExchange, getJsonForException("Phone with id " + phoneId + " doesn't exist!"), 404);
            } else {
                database.deleteById(phoneId);
                handleResponse(httpExchange, null, 200);
            }
        }
    }

    private static String getJsonForException(String message) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", message);
        return jsonObject.toString();
    }
}

