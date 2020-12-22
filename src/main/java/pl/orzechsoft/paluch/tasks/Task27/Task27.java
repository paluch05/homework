package pl.orzechsoft.paluch.tasks.Task27;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Task27 {

    private static final String CONTEXT = "/motorcycles";

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
        server.createContext(CONTEXT, new MyHttpHandler());
        Executor threadPoolExecutor = Executors.newFixedThreadPool(10);
        server.setExecutor(threadPoolExecutor);
        server.start();
    }

    private static class MyHttpHandler implements HttpHandler {

        Database<Motorcycle> database = new HashMapDatabase();
        ObjectMapper objectMapper = new ObjectMapper();

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {

            String requestMethod = httpExchange.getRequestMethod();
            switch(requestMethod){

                case "GET":
                    handleGet(httpExchange);
                    break;

                case "POST":
                    handlePost(httpExchange);
                    break;

                case "DELETE":
                    handleDelete(httpExchange);
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

        private void handleGet(HttpExchange httpExchange) throws IOException {
            String uri = httpExchange.getRequestURI().toString();
            String id = uri.length() > CONTEXT.length() ? uri.substring((CONTEXT + "/").length()) : null;
            String json;
            if (id == null) {
                json = objectMapper.writeValueAsString(database.getAll());
            } else {
                Motorcycle motorcycle = database.get(id);
                if (motorcycle == null) {
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
            Motorcycle motorcycle;
            try {
                motorcycle = objectMapper.readValue(httpExchange.getRequestBody(), Motorcycle.class);
            } catch (IOException e) {
                handleResponse(httpExchange, getJsonForException(e.getMessage()), 500);
                return;
            }
            try {
                database.add(motorcycle);
            } catch (Exception e) {
                handleResponse(httpExchange, getJsonForException(e.getMessage()), 500);
                return;
            }
            handleResponse(httpExchange, null, 201);
        }
        private void handlePut (HttpExchange httpExchange) throws IOException {

            Motorcycle motorcycle;
            try {
                motorcycle = objectMapper.readValue(httpExchange.getRequestBody(), Motorcycle.class);
            } catch (IOException e) {
                handleResponse(httpExchange, getJsonForException(e.getMessage()), 500);
                return;
            }

            if(!database.contains(motorcycle.getId())){
                handleResponse(httpExchange, getJsonForException("Motorcycle with id " + motorcycle.getId() + " doesn't exist!"), 404);
            }

            try {
                database.update(motorcycle);
            } catch (Exception e) {
                handleResponse(httpExchange, getJsonForException(e.getMessage()), 500);
                return;
            }
            handleResponse(httpExchange, null, 200);
        }

        private void handleDelete (HttpExchange httpExchange) throws IOException {

            String query = httpExchange.getRequestURI().getQuery();
            String[] splittedQuery = query.split("&");

            if(splittedQuery.length > 1) {
                handleResponse(httpExchange, getJsonForException("Expected one query, but got: " + splittedQuery.length), 500);
            }

            String motorId = splittedQuery[0].split("=")[1];

            boolean motorExists = database.contains(motorId);
            if(!motorExists){
                handleResponse(httpExchange, getJsonForException("Motorcycle with id " + motorId + " doesn't exist!"), 404);
            } else {
                database.deleteById(motorId);
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