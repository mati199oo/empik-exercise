package component.view.controller;

import component.exception.EmpikExerciseException;
import component.exception.GithubException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(GithubException.class)
    public ResponseEntity<String> handleGithubException(GithubException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmpikExerciseException.class)
    public ResponseEntity<String> handleEmpikExerciseException(EmpikExerciseException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
