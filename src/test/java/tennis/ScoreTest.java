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
        var score = new Score(new Point(Point.FORTY), new Point(Point.THIRTY));

        // Act
        score.incrementRightPoint();
        var deuce = score.isDeuce();

        // Assert
        assertThat(deuce).isTrue();
    }

    @Test
    void isAdvantageLeft_should_be_true_when_score_is_deuce_and_left_increment_point() {
        // Arrange
        var score = new Score(new Point(Point.FORTY), new Point(Point.THIRTY));
        score.incrementRightPoint();

        // Act
        score.incrementLeftPoint();
        var advantageLeft = score.isAdvantageLeft();

        // Assert
        assertThat(advantageLeft).isTrue();
    }

    @Test
    void isAdvantageRight_should_be_true_when_score_is_deuce_and_right_increment_point() {
        // Arrange
        var score = new Score(new Point(Point.THIRTY), new Point(Point.FORTY));
        score.incrementLeftPoint();

        // Act
        score.incrementRightPoint();
        var advantageRight = score.isAdvantageRight();

        // Assert
        assertThat(advantageRight).isTrue();
    }

    @Test
    void isDeuce_should_be_true_when_left_has_advantage_and_right_increment_point() {
        // Arrange
        var score = new Score(new Point(Point.THIRTY), new Point(Point.FORTY));
        score.incrementLeftPoint();
        score.incrementLeftPoint();

        // Act
        score.incrementRightPoint();
        var deuce = score.isDeuce();

        // Assert
        assertThat(deuce).isTrue();
    }

    @Test
    void hasRightPlayerWin_should_be_true_when_right_has_advantage_and_increment_point() {
        // Arrange
        var score = new Score(new Point(Point.THIRTY), new Point(Point.FORTY));
        score.incrementLeftPoint();
        score.incrementRightPoint();

        // Act
        score.incrementRightPoint();
        var rightPlayerWin = score.hasRightPlayerWin();

        // Assert
        assertThat(rightPlayerWin).isTrue();
    }

}
