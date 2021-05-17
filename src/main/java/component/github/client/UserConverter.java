package component.github.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import component.exception.EmpikExerciseException;
import component.github.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    private final ObjectReader reader;

    public UserConverter() {
        final ObjectMapper mapper = new ObjectMapper();
        this.reader = mapper.readerFor(User.class);
    }

    public User fromJson(String json) {
        try {
            return reader.readValue(json);
        } catch (JsonProcessingException e) {
            throw new EmpikExerciseException("Could not map json response to User object", e);
        }
    }
}
