package component.view.controller;

import component.service.UserService;
import component.view.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerShould {

    @Mock
    private User user;

    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;

    @Test
    public void getUser() {
        // given
        String login = "testLogin";
        when(userService.getUser(login)).thenReturn(user);

        // when
        ResponseEntity<User> responseEntity = userController.getUser(login);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(user);
    }
}
