package component.service;

import component.database.repository.ExerciseRepository;
import component.domain.mapper.UserMapper;
import component.view.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final ExerciseRepository exerciseRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(ExerciseRepository exerciseRepository, UserMapper userMapper) {
        this.exerciseRepository = exerciseRepository;
        this.userMapper = userMapper;
    }

    public User getProduct(String login) {
        return null;
    }
}