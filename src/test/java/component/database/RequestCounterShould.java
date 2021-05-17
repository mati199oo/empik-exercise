package component.database;

import component.database.model.LoginCounter;
import component.database.repository.LoginCounterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RequestCounterShould {

    @Mock
    private LoginCounterRepository loginCounterRepository;
    @InjectMocks
    private RequestCounter requestCounter;

    @Test
    public void incrementLoginCountWhenLoginCounterExistsInDb() {
        // given
        String login = "testLogin";
        int requestCount = 2;

        LoginCounter loginCounter = createLoginCounter(login, requestCount);
        when(loginCounterRepository.findById(login)).thenReturn(Optional.of(loginCounter));

        // when
        requestCounter.incrementLoginCount(login);

        // then
        assertThat(loginCounter.getRequestCount()).isEqualTo(3);
    }

    @Test
    public void createNewLoginCountWhenLoginCounterDoesNotExistInDb() {
        // given
        String login = "testLogin";
        when(loginCounterRepository.findById(login)).thenReturn(Optional.empty());

        // when
        requestCounter.incrementLoginCount(login);

        // then
        LoginCounter loginCounter = new LoginCounter();
        loginCounter.setLogin(login);
        loginCounter.setRequestCount(1);
        verify(loginCounterRepository).save(eq(loginCounter));
    }

    private LoginCounter createLoginCounter(String login, int requestCount) {
        LoginCounter loginCounter = new LoginCounter();
        loginCounter.setLogin(login);
        loginCounter.setRequestCount(requestCount);
        return loginCounter;
    }
}
