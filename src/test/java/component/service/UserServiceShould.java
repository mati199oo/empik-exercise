package component.service;

import component.database.RequestCounter;
import component.domain.mapper.UserMapper;
import component.github.client.GithubClient;
import component.view.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceShould {

    @Mock
    private component.github.model.User githubUser;
    @Mock
    private component.domain.model.User domainUser;
    @Mock
    private User user;

    @Mock
    private UserMapper userMapper;
    @Mock
    private RequestCounter requestCounter;
    @Mock
    private GithubClient githubClient;
    @InjectMocks
    private UserService userService;

    @Test
    public void getUserAndIncrementLoginCount() {
        // given
        String login = "testLogin";
        when(githubClient.findUser(login)).thenReturn(githubUser);
        when(userMapper.githubToDomain(githubUser)).thenReturn(domainUser);
        when(domainUser.getNumberOfFollowers()).thenReturn(1);
        when(domainUser.getNumberOfRepos()).thenReturn(1);
        when(userMapper.domainToView(domainUser)).thenReturn(user);

        // when
        User viewUser = userService.getUser(login);

        // then
        verify(requestCounter).incrementLoginCount(login);
        assertThat(viewUser).isEqualTo(user);
    }
}
