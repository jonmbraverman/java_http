import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpPractice {

    public static void main(String[] args)
    {
        String http =  "https://webhook.site/2817d0a4-d418-45d1-8bcd-64890a4fdbf0"; //"https://httpbin.org/headers";
        //String http = "https://www.google.com";
        System.out.printf("Test url: %s\n\nresponse:\n", http);
        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest request = HttpRequest.newBuilder()
         .uri(URI.create(http))
         .build();
        
         client.sendAsync(request, BodyHandlers.ofString())
         .thenApply(HttpResponse::body)
         .thenAccept(System.out::println)
         .join(); 

        
    }
}
