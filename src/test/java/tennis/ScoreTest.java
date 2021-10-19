package tennis;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ScoreTest {

    @Nested
    class incrementLeftPoint {
        @Test
        void should_increment_left_player_point() {
            // Arrange
            var score = new Score();

            // Act
            score.incrementLeftPoint();

            // Assert
            var expectedPoint = new Point();
            expectedPoint.goToTheNextValue();
            assertThat(score.getLeftPoint()).isEqualTo(expectedPoint);
        }

        @Test
        void should_update_if_left_player_win_the_game() {
            // Arrange
            var score = new Score(new Point(Point.FORTY), new Point());

            // Act
            score.incrementLeftPoint();
            var hasLeftPlayerWin = score.hasLeftPlayerWin();

            // Assert
            assertThat(hasLeftPlayerWin).isTrue();
        }
    }

    @Nested
    class incrementRightPoint {
        @Test
        void should_increment_right_player_point() {
            // Arrange
            var score = new Score();

            // Act
            score.incrementRightPoint();

            // Assert
            var expectedPoint = new Point();
            expectedPoint.goToTheNextValue();
            assertThat(score.getRightPoint()).isEqualTo(expectedPoint);
        }

        @Test
        void should_update_if_right_player_win_the_game() {
            // Arrange
            var score = new Score(new Point(), new Point(Point.FORTY));

            // Act
            score.incrementRightPoint();
            var hasRightPlayerWin = score.hasRightPlayerWin();

            // Assert
            assertThat(hasRightPlayerWin).isTrue();
        }
    }

    @Test
    void isDeuce_should_be_true_when_both_players_are_closed_to_goal() {
        // Arrange
        var score = new Score(new Point(Point.FORTY), new Point(Point.FORTY));

        // Act
        var deuce = score.isDeuce();

        // Assert
        assertThat(deuce).isTrue();
    }
}
