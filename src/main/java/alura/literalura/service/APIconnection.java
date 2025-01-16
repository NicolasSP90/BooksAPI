package alura.literalura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class APIconnection {
    private static String getDataFromAPI(String url) {
        String json;

        try (HttpClient client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            json = response.body();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return json;
    }

    public static String searchByKeyword() {
        String urlBase = "https://gutendex.com/books";
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o autor ou nome do livro:");
        var keyword = input.nextLine();
        var url = urlBase + "?search=" + keyword.replace(" ","+");
        return getDataFromAPI(url);
    }

}
