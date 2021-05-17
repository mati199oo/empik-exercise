package component.domain.mapper;

import component.domain.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserMapperShould {

    private static final Integer ID = 1;
    private static final String LOGIN = "testLogin";
    private static final String NAME = "testName";
    private static final String TYPE = "testType";
    private static final String AVATAR_URL = "https://testAvatarUrl.com/u/5832";
    private static final String CREATED_AT = "2011-01-25T18:44:36Z";
    private static final Integer NUMBER_OF_FOLLOWERS = 1;
    private static final Integer NUMBER_OF_REPOS = 1;
    private static final Double CALCULATIONS = 1.0;

    private final UserMapper userMapper = new UserMapperImpl();

    @Test
    public void mapDomainToView() {
        // given
        User domainUser = createDomainUser(CALCULATIONS);

        // when
        var viewUser = userMapper.domainToView(domainUser);

        // then
        var expectedViewUser = createViewUser();
        assertThat(viewUser).isEqualToComparingFieldByField(expectedViewUser);
    }

    @Test
    public void mapGithubToDomain() {
        // given
        var githubUser = createGithubUser();

        // when
        User domainUser = userMapper.githubToDomain(githubUser);

        // then
        var expectedDomainUser = createDomainUser(null);
        assertThat(domainUser).isEqualToComparingFieldByField(expectedDomainUser);
    }

    private User createDomainUser(Double calculations) {
        User user = new User();
        user.setId(ID);
        user.setLogin(LOGIN);
        user.setName(NAME);
        user.setType(TYPE);
        user.setAvatarUrl(AVATAR_URL);
        user.setCreatedAt(CREATED_AT);
        user.setNumberOfFollowers(NUMBER_OF_FOLLOWERS);
        user.setNumberOfRepos(NUMBER_OF_REPOS);
        user.setCalculations(calculations);
        return user;
    }

    private component.github.model.User createGithubUser() {
        return new component.github.model.User(ID,
                LOGIN,
                NAME,
                TYPE,
                AVATAR_URL,
                CREATED_AT,
                NUMBER_OF_FOLLOWERS,
                NUMBER_OF_REPOS);
    }

    private component.view.model.User createViewUser() {
        var user = new component.view.model.User();
        user.setId(ID);
        user.setLogin(LOGIN);
        user.setName(NAME);
        user.setType(TYPE);
        user.setAvatarUrl(AVATAR_URL);
        user.setCreatedAt(CREATED_AT);
        user.setCalculations(CALCULATIONS);
        return user;
    }
}
