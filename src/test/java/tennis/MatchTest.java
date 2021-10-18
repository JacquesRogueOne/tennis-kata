package tennis;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
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

    @Test
    void in_a_new_game_when_the_player_one_score_a_point_then_the_game_current_score_has_to_be_15_0() {
        // Arrange

        // Act
        match.firstPlayerScore();
        String currentGameScore = match.currentGameScore();

        // Assert
        assertThat(currentGameScore).isEqualTo("15 - 0");
    }
}