package tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GameTest {

    @Spy
    private Score score = new Score();

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(score);
    }

    @Nested
    class leftPlayerScore {
        @Test
        void should_call_score_to_change_left_point_to_upper() {
            // Arrange & Act
            game.leftPlayerScore();

            // Assert
            verify(score).incrementLeftPoint();
        }

        @Test
        void should_check_in_score_if_left_player_win_the_game() {
            // Arrange & Act
            game.leftPlayerScore();

            // Assert
            verify(score).hasLeftPlayerWin();
        }

        @Test
        void should_change_left_player_winner_value_when_left_player_win_the_game() {
            // Arrange
            var score = mock(Score.class);
            var game = new Game(score);
            when(score.hasLeftPlayerWin()).thenReturn(true);

            // Act
            game.leftPlayerScore();
            var leftPlayerWinTheGame = game.isLeftPlayerWinTheGame();

            // Assert
            assertThat(leftPlayerWinTheGame).isTrue();
        }
    }

    @Nested
    class rightPlayerScore {
        @Test
        void rightPlayerScore_should_call_score_to_change_right_point_to_upper() {
            // Arrange & Act
            game.rightPlayerScore();

            // Assert
            verify(score).incrementRightPoint();
        }

        @Test
        void should_check_in_score_if_right_player_win_the_game() {
            // Arrange & Act
            game.rightPlayerScore();

            // Assert
            verify(score).hasRightPlayerWin();
        }

        @Test
        void should_change_right_player_winner_value_when_right_player_win_the_game() {
            // Arrange
            var score = mock(Score.class);
            var game = new Game(score);
            when(score.hasRightPlayerWin()).thenReturn(true);

            // Act
            game.rightPlayerScore();
            var rightPlayerWinTheGame = game.isRightPlayerWinTheGame();

            // Assert
            assertThat(rightPlayerWinTheGame).isTrue();
        }

        @Test
        void representation_should_return_standard_score_when_beginning_of_a_game() {
            // Arrange & Act
            var representation = game.representation();

            // Assert
            assertThat(representation).isEqualTo("0 - 0");
        }

        @Test
        void representation_should_return_deuce_when_score_is_deuce() {
            // Arrange
            var score = mock(Score.class);
            var game = new Game(score);
            when(score.isDeuce()).thenReturn(true);

            // Act
            var representation = game.representation();

            // Assert
            assertThat(representation).isEqualTo("deuce");
        }

        @Test
        void representation_should_return_advantage_when_score_is_advantage_left() {
            // Arrange
            var score = mock(Score.class);
            var game = new Game(score);
            when(score.isAdvantageLeft()).thenReturn(true);

            // Act
            var representation = game.representation();

            // Assert
            assertThat(representation).isEqualTo("advantage $leftPlayer");
        }
        @Test
        void representation_should_return_advantage_when_score_is_advantage_right() {
            // Arrange
            var score = mock(Score.class);
            var game = new Game(score);
            when(score.isAdvantageRight()).thenReturn(true);

            // Act
            var representation = game.representation();

            // Assert
            assertThat(representation).isEqualTo("advantage $rightPlayer");
        }

    }
}
