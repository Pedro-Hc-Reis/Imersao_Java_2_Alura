package Aula_01;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.net.URI;

public class App {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[45m";
    public static void main(String[] args) throws Exception {
        // Creating the connection
        String url = "https://gist.githubusercontent.com/lucasfugisawa/cbb0d10ee3901bd0541468e431c629b3/raw/1fe1f3340dfe5b5876a209c0e8226d090f6aef10/Top250Movies.json";
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create(url)).GET().build();
        HttpResponse<String> response = client.send(request,BodyHandlers.ofString()); // this line could be turned into "var" as wells as the lines above, but it would make the code less understandable
        String body = response.body();

        // Extracting the movies
        var parser = new JsonParser();
        List<Map<String,String>> listaDeFilmes = parser.parse(body);

        // Printing the movies
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\nTitle: " + filme.get("title"));
            System.out.println("Image: " + filme.get("image"));

            var movieRate = Float.parseFloat(filme.get("imDbRating"));
            String stars = " ";


            switch ((int) movieRate) {
                case 10 -> stars += "⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐";
                case 9 -> stars += "⭐⭐⭐⭐⭐⭐⭐⭐⭐";
                case 8 -> stars += "⭐⭐⭐⭐⭐⭐⭐⭐";
                case 7 -> stars += "⭐⭐⭐⭐⭐⭐⭐";
                case 6 -> stars += "⭐⭐⭐⭐⭐⭐";
                case 5 -> stars += "⭐⭐⭐⭐⭐";
                case 4 -> stars += "⭐⭐⭐⭐";
                case 3 -> stars += "⭐⭐⭐";
                case 2 -> stars += "⭐⭐";
                case 1 -> stars += "⭐";
            }
            System.out.println(ANSI_PURPLE+"Rating: " + (int)movieRate + stars +" " + ANSI_RESET);
        }

    }
}