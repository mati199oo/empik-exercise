package component.github.client;

import component.github.model.User;
import component.http.HttpTransport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GithubClientShould {

    @Mock
    private HttpResponse<String> httpResponse;
    @Mock
    private User user;

    @Mock
    private HttpTransport httpTransport;
    @Mock
    private UserConverter userConverter;
    @InjectMocks
    private GithubClient githubClient;

    @Test
    public void findUser() {
        // given
        String login = "testLogin";
        String body = "responseBody";
        when(httpTransport.get("https://api.github.com/users/" + login)).thenReturn(httpResponse);
        when(httpResponse.body()).thenReturn(body);
        when(userConverter.fromJson(body)).thenReturn(user);

        // when
        User githubUser = githubClient.findUser(login);

        // then
        assertThat(githubUser).isEqualTo(user);
    }
}
