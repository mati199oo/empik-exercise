package component.view.controller;

import component.exception.EmpikExerciseException;
import component.exception.GithubException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class RestExceptionHandlerShould {

    private static final String MESSAGE = "testMessage";

    private final RestExceptionHandler restExceptionHandler = new RestExceptionHandler();

    @Test
    public void handleGithubException() {
        // given
        GithubException e = new GithubException(MESSAGE);

        // when
        ResponseEntity<String> responseEntity = restExceptionHandler.handleGithubException(e);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(responseEntity.getBody()).isEqualTo(MESSAGE);
    }

    @Test
    public void handleEmpikExerciseException() {
        // given
        EmpikExerciseException e = new EmpikExerciseException(MESSAGE, new IOException());

        // when
        ResponseEntity<String> responseEntity = restExceptionHandler.handleEmpikExerciseException(e);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(responseEntity.getBody()).isEqualTo(MESSAGE);
    }
}
