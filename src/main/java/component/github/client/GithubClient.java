package component.github.client;

import component.github.model.User;
import component.http.HttpTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GithubClient {

    private final HttpTransport httpTransport;
    private final UserConverter userConverter;

    @Autowired
    public GithubClient(HttpTransport httpTransport, UserConverter userConverter) {
        this.httpTransport = httpTransport;
        this.userConverter = userConverter;
    }

    public User findUser(String login) {
        String path = "https://api.github.com/users/" + login;
        String responseBody = httpTransport.get(path).body();
        return userConverter.fromJson(responseBody);
    }
}
