package pl.orzechsoft.paluch.tasks.Task13;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Scanner;

public class Task13 {

    public static void main(String[] args) throws IOException {
        System.out.println("Enter currency symbol from: ");
        Scanner scanner = new Scanner(System.in);
        String from = scanner.nextLine().toUpperCase();
        System.out.println("Enter currency symbol to: ");
        String to = scanner.nextLine().toUpperCase();

        HttpGet request = new HttpGet("https://api.ratesapi.io/api/latest?base=" + from);
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            Rates rates = new ObjectMapper().readValue(entity.getContent(), Rates.class);
            System.out.println(rates.getBase() + "=>" + to + ": " + rates.getRates().get(to));
        }
    }
}