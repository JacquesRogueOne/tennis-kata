package tennis;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MatchTest {

    private final Match match = new Match();

    @Test
    void getStatus_should_return_in_progress_when_the_match_just_start() {
        // Arrange & Act
        String status = match.getStatus();

        // Assert
        assertThat(status).isEqualTo("In Progress");
    }

    @Nested
    class currentGameScore {
        @Test
        void has_to_be_15_0_when_the_player_one_score_the_first_point() {
            // Arrange & Act
            match.firstPlayerScore();
            String currentGameScore = match.currentGameScore();

            // Assert
            assertThat(currentGameScore).isEqualTo("15 - 0");
        }

        @Test
        void has_to_be_0_15_when_the_player_two_score_the_first_point() {
            // Arrange & Act
            match.secondPlayerScore();
            String currentGameScore = match.currentGameScore();

            // Assert
            assertThat(currentGameScore).isEqualTo("0 - 15");
        }

        @Test
        void has_to_be_30_0_when_the_player_one_score_the_two_first_points() {
            // Arrange & Act
            match.firstPlayerScore();
            match.firstPlayerScore();
            String currentGameScore = match.currentGameScore();

            // Assert
            assertThat(currentGameScore).isEqualTo("30 - 0");
        }

    }
}