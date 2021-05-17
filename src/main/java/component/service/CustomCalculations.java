package component.service;

public class CustomCalculations {

    public static Double calculateResultFromGithubUserStatistics(Integer numberOfFollowers, Integer numberOfRepos) {
        if (numberOfFollowers == 0) {
            return 0.0;
        }
        return 6.0 / numberOfFollowers * (2.0 + numberOfRepos);
    }
}
