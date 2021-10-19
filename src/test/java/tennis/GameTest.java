package tennis;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tennis.Game.ScoreAPoint.LEFT_PLAYER;
import static tennis.Game.ScoreAPoint.RIGHT_PLAYER;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GameTest {

    private final Game game = new Game();

    @Test
    void when_begin_a_game_the_state_has_to_be_0_to_0() {
        // Arrange & Act
        var state = game.getState();

        // Assert
        assertThat(state).isEqualTo("0 - 0");
    }

    @Nested
    class operateTransition {

        @Test
        void should_return_15_0_when_left_player_score_first() {
            // Arrange & Act
            var state = game.operateTransition(LEFT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("15 - 0");
        }

        @Test
        void should_return_30_0_when_left_player_score_twice_at_first() {
            // Arrange & Act
            var state = game.operateTransition("15 - 0", LEFT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("30 - 0");
        }

        @Test
        void should_return_40_0_when_left_player_score_three_times_at_first() {
            // Arrange & Act
            var state = game.operateTransition("30 - 0", LEFT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("40 - 0");
        }

        @Test
        void should_return_0_15_when_right_player_score_first() {
            // Arrange & Act
            var state = game.operateTransition(RIGHT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("0 - 15");
        }

        @Test
        void should_return_30_0_when_right_player_score_twice_at_first() {
            // Arrange & Act
            var state = game.operateTransition("0 - 15", RIGHT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("0 - 30");
        }

        @Test
        void should_return_40_0_when_right_player_score_twice_at_first() {
            // Arrange & Act
            var state = game.operateTransition("0 - 30", RIGHT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("0 - 40");
        }

        @Test
        void should_return_15_15_when_right_player_score_after_left() {
            // Arrange & Act
            var state = game.operateTransition("15 - 0", RIGHT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("15 - 15");
        }

        @Test
        void should_return_15_30_when_right_player_score_after_15_15() {
            // Arrange & Act
            var state = game.operateTransition("15 - 15", RIGHT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("15 - 30");
        }

        @Test
        void should_return_15_40_when_right_player_score_after_15_30() {
            // Arrange & Act
            var state = game.operateTransition("15 - 30", RIGHT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("15 - 40");
        }

        @Test
        void should_return_30_30_when_right_player_score_after_30_15() {
            // Arrange & Act
            var state = game.operateTransition("30 - 15", RIGHT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("30 - 30");
        }

        @Test
        void should_return_30_40_when_right_player_score_after_30_30() {
            // Arrange & Act
            var state = game.operateTransition("30 - 30", RIGHT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("30 - 40");
        }

        @Test
        void should_return_40_40_when_left_player_score_after_30_40() {
            // Arrange & Act
            var state = game.operateTransition("30 - 40", LEFT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("40 - 40");
        }

        @Test
        void should_return_40_15_when_left_player_score_after_30_15() {
            // Arrange & Act
            var state = game.operateTransition("30 - 15", LEFT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("40 - 15");
        }

        @Test
        void should_return_40_30_when_left_player_score_after_30_30() {
            // Arrange & Act
            var state = game.operateTransition("30 - 30", LEFT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("40 - 30");
        }

        @Test
        void should_return_15_15_when_left_player_score_after_0_15() {
            // Arrange & Act
            var state = game.operateTransition("0 - 15", LEFT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("15 - 15");
        }

        @Test
        void should_return_30_15_when_left_player_score_after_15_15() {
            // Arrange & Act
            var state = game.operateTransition("15 - 15", LEFT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("30 - 15");
        }

        @Test
        void should_return_30_30_when_left_player_score_after_15_30() {
            // Arrange & Act
            var state = game.operateTransition("15 - 30", LEFT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("30 - 30");
        }

        @Test
        void should_return_15_30_when_left_player_score_after_0_30() {
            // Arrange & Act
            var state = game.operateTransition("0 - 30", LEFT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("15 - 30");
        }

        @Test
        void should_return_30_0_when_righ_player_score_after_30_15() {
            // Arrange & Act
            var state = game.operateTransition("30 - 0", RIGHT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("30 - 15");
        }

        @Test
        void should_return_right_win_when_righ_player_score_after_0_40() {
            // Arrange & Act
            var state = game.operateTransition("0 - 40", RIGHT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("RIGHT WIN");
        }

        @Test
        void should_return_right_win_when_righ_player_score_after_15_40() {
            // Arrange & Act
            var state = game.operateTransition("15 - 40", RIGHT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("RIGHT WIN");
        }

        @Test
        void should_return_right_win_when_righ_player_score_after_30_40() {
            // Arrange & Act
            var state = game.operateTransition("30 - 40", RIGHT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("RIGHT WIN");
        }

        @Test
        void should_return_left_win_when_left_player_score_after_40_0() {
            // Arrange & Act
            var state = game.operateTransition("40 - 0", LEFT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("LEFT WIN");
        }

        @Test
        void should_return_left_win_when_left_player_score_after_40_15() {
            // Arrange & Act
            var state = game.operateTransition("40 - 15", LEFT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("LEFT WIN");
        }

        @Test
        void should_return_left_win_when_left_player_score_after_40_30() {
            // Arrange & Act
            var state = game.operateTransition("40 - 30", LEFT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("LEFT WIN");
        }

        @Test
        void should_return_15_40_when_left_player_score_after_0_40() {
            // Arrange & Act
            var state = game.operateTransition("0 - 40", LEFT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("15 - 40");
        }

        @Test
        void should_return_30_40_when_left_player_score_after_15_40() {
            // Arrange & Act
            var state = game.operateTransition("15 - 40", LEFT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("30 - 40");
        }

        @Test
        void should_return_40_15_when_right_player_score_after_40_0() {
            // Arrange & Act
            var state = game.operateTransition("40 - 0", RIGHT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("40 - 15");
        }

        @Test
        void should_return_40_30_when_left_player_score_after_40_15() {
            // Arrange & Act
            var state = game.operateTransition("40 - 15", RIGHT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("40 - 30");
        }

        @Test
        void should_return_40_40_when_right_player_score_after_40_30() {
            // Arrange & Act
            var state = game.operateTransition("40 - 30", RIGHT_PLAYER);

            // Assert
            assertThat(state).isEqualTo("40 - 40");
        }
    }

}