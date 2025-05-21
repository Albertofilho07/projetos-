import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OmdbMovieFetcher {
    public static void main(String[] args) throws Exception {
        // Coloque aqui sua API Key válida da OMDb
        String apiKey = "8711d62f";
        String movieTitle = "Inception";

        // Monta a URL corretamente, com ?t=titulo e &apikey=chave
        String url = "http://www.omdbapi.com/?t=" + movieTitle + "&apikey=" + apiKey;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))  // Cria URI corretamente
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body:\n" + response.body());
    }
}


