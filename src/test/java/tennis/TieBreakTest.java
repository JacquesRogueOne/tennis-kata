package tennis;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tennis.ScoreAPoint.LEFT_PLAYER;
import static tennis.ScoreAPoint.RIGHT_PLAYER;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TieBreakTest {

    private TieBreak tieBreak = new TieBreak();

    @Test
    void getInitialState_should_return_0_0_when_tie_break_start() {
        // Arrange & Act
        var initialState = tieBreak.getInitialState();

        // Assert
        assertThat(initialState).isEqualTo("0 - 0");
    }

    @Nested
    class operateTransition {

        @Test
        void should_return_0_1_when_right_player_score_first() {
            // Arrange & Act
            var initialState = tieBreak.operateTransition(RIGHT_PLAYER);

            // Assert
            assertThat(initialState).isEqualTo("0 - 1");
        }

        @Test
        void should_return_0_2_when_right_player_score_on_0_1() {
            // Arrange & Act
            var initialState = tieBreak.operateTransition("0 - 1", RIGHT_PLAYER);

            // Assert
            assertThat(initialState).isEqualTo("0 - 2");
        }

        @Test
        void should_return_1_0_when_left_player_score_first() {
            // Arrange & Act
            var initialState = tieBreak.operateTransition(LEFT_PLAYER);

            // Assert
            assertThat(initialState).isEqualTo("1 - 0");
        }

        @Test
        void should_return_left_win_when_left_player_a_seventh_point() {
            // Arrange & Act
            var initialState = tieBreak.operateTransition("6 - 0", LEFT_PLAYER);

            // Assert
            assertThat(initialState).isEqualTo("LEFT WIN");
        }

        @Test
        void should_return_7_6_when_left_player_a_seventh_point_on_6_6() {
            // Arrange
            tieBreak = new TieBreak();

            // Act
            var initialState = tieBreak.operateTransition("6 - 6", LEFT_PLAYER);

            // Assert
            assertThat(initialState).isEqualTo("7 - 6");
        }

        @Test
        void should_return_left_win_when_left_player_will_have_more_than_seven_points_and_to_points_difference() {
            // Arrange & Act
            var initialState = tieBreak.operateTransition("7 - 6", LEFT_PLAYER);

            // Assert
            assertThat(initialState).isEqualTo("LEFT WIN");
        }

        @Test
        void should_return_right_win_when_right_player_will_have_more_than_seven_points_and_to_points_difference() {
            // Arrange & Act
            var initialState = tieBreak.operateTransition("6 - 7", RIGHT_PLAYER);

            // Assert
            assertThat(initialState).isEqualTo("RIGHT WIN");
        }
    }
}