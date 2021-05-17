package component.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomCalculationsShould {

    @Test
    public void calculateResultFromGithubUserStatisticsWithNonZeroFollowers() {
        // given
        Integer numberOfFollowers = 1;
        Integer numberOfRepos = 1;

        // when
        Double result = CustomCalculations.calculateResultFromGithubUserStatistics(numberOfFollowers, numberOfRepos);

        // then
        assertThat(result).isEqualTo(18.0);
    }

    @Test
    public void calculateResultFromGithubUserStatisticsWithZeroFollowers() {
        // given
        Integer numberOfFollowers = 0;
        Integer numberOfRepos = 1;

        // when
        Double result = CustomCalculations.calculateResultFromGithubUserStatistics(numberOfFollowers, numberOfRepos);

        // then
        assertThat(result).isEqualTo(0.0);
    }
}
