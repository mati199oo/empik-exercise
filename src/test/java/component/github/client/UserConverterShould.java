package component.github.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import component.exception.EmpikExerciseException;
import component.github.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserConverterShould {

    private final UserConverter userConverter = new UserConverter();

    @Test
    public void convertFromJson() {
        // given
        String correctJson = "{\"login\":\"octocat\"," +
                "\"id\":583231," +
                "\"avatar_url\":\"https://avatars.githubusercontent.com/u/583231?v=4\"," +
                "\"type\":\"User\"," +
                "\"name\":\"The Octocat\"," +
                "\"public_repos\":8," +
                "\"followers\":3738," +
                "\"created_at\":\"2011-01-25T18:44:36Z\"}";

        // when
        User githubUser = userConverter.fromJson(correctJson);

        // then
        User expectedGithubUser = createGithubUser();
        assertThat(githubUser).isEqualToComparingFieldByField(expectedGithubUser);
    }

    @Test
    public void throwEmpikExerciseExceptionWhenIncorrectJson() {
        // given
        String incorrectJson = "{\"loganoctocat\"}";

        // when
        assertThatThrownBy(() -> userConverter.fromJson(incorrectJson))
                // then
                .isInstanceOf(EmpikExerciseException.class)
                .hasMessage("Could not map json response to User object")
                .hasRootCauseInstanceOf(JsonProcessingException.class);
    }

    private User createGithubUser() {
        return new User(583231,
                "octocat",
                "The Octocat",
                "User",
                "https://avatars.githubusercontent.com/u/583231?v=4",
                "2011-01-25T18:44:36Z",
                3738,
                8);
    }
}
