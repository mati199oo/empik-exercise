package component.http;

import component.exception.EmpikExerciseException;
import component.exception.GithubException;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HttpTransportShould {

    private final HttpTransport httpTransport = new HttpTransport();

    // Normally there should be mocked endpoint for unit tests, but I thought that it would be a little overkill for this kind of exercise

    @Test
    public void performGetRequest() {
        // given
        String correctPath = "https://api.github.com/users/octocat";

        // when
        HttpResponse<String> response = httpTransport.get(correctPath);

        // then
        assertThat(response.statusCode()).isEqualTo(200);
    }

    @Test
    public void throwEmpikExerciseExceptionWhenIncorrectURI() {
        // given
        String incorrectPath = "https://api.github.com/uq/h?s=^IXIC";

        // when
        assertThatThrownBy(() -> httpTransport.get(incorrectPath))
                // then
                .isInstanceOf(EmpikExerciseException.class)
                .hasMessage("Could not parse URI")
                .hasRootCauseInstanceOf(URISyntaxException.class);
    }

    @Test
    public void throwGithubExceptionWhenUserNotFound() {
        // given
        String incorrectUserPath = "https://api.github.com/users/osdgsdghsdhfjfgjfkr";

        // when
        assertThatThrownBy(() -> httpTransport.get(incorrectUserPath))
                // then
                .isInstanceOf(GithubException.class)
                .hasMessage("User not found in external system");
    }
}
