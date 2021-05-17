package component.database;

import component.database.model.LoginCounter;
import component.database.repository.LoginCounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;

@Component
public class RequestCounter {

    private final LoginCounterRepository loginCounterRepository;

    @Autowired
    public RequestCounter(LoginCounterRepository loginCounterRepository) {
        this.loginCounterRepository = loginCounterRepository;
    }

    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public void incrementLoginCount(String login) {
        loginCounterRepository.findById(login)
                .ifPresentOrElse(this::updateLoginCounter, () -> createNewCounter(login));
    }

    private void updateLoginCounter(LoginCounter loginCounter) {
        loginCounter.setRequestCount(loginCounter.getRequestCount() + 1);
    }

    private void createNewCounter(String login) {
       LoginCounter loginCounter = new LoginCounter();
       loginCounter.setLogin(login);
       loginCounter.setRequestCount(1);

       loginCounterRepository.save(loginCounter);
    }
}
