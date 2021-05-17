package component.service;

import component.database.RequestCounter;
import component.domain.mapper.UserMapper;
import component.domain.model.User;
import component.github.client.GithubClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static component.service.CustomCalculations.calculateResultFromGithubUserStatistics;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final RequestCounter requestCounter;
    private final GithubClient githubClient;

    @Autowired
    public UserService(UserMapper userMapper, RequestCounter requestCounter, GithubClient githubClient) {
        this.userMapper = userMapper;
        this.requestCounter = requestCounter;
        this.githubClient = githubClient;
    }

    public component.view.model.User getUser(String login) {
        requestCounter.incrementLoginCount(login);
        var githubUser = githubClient.findUser(login);
        User user = userMapper.githubToDomain(githubUser);
        user.setCalculations(calculateResultFromGithubUserStatistics(user.getNumberOfFollowers(), user.getNumberOfRepos()));
        return userMapper.domainToView(user);
    }
}