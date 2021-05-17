package component.http;

import component.exception.EmpikExerciseException;
import component.exception.GithubException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class HttpTransport {

    private final HttpClient httpClient;

    public HttpTransport() {
        httpClient = HttpClient.newBuilder().build();
    }

    public HttpResponse<String> get(String path) {
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(path))
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            throw new EmpikExerciseException("Could not parse URI", e);
        }

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 404) {
                throw new GithubException("User not found in external system");
            }
            return response;
        } catch (IOException e) {
            throw new EmpikExerciseException("Could not send or receive data during HTTP call", e);
        } catch (InterruptedException e) {
            throw new EmpikExerciseException("Something interrupted sending HTTP request", e);
        }
    }
}
