package tennis;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ScoreTest {

    @Test
    void incrementLeftPoint_should_increment_left_player_point() {
        // Arrange
        var score = new Score();

        // Act
        score.incrementLeftPoint();

        // Assert
        var expectedPoint = new Point();
        expectedPoint.next();
        assertThat(score.getLeftPoint()).isEqualTo(expectedPoint);
    }

    @Test
    void incrementRightPoint_should_increment_right_player_point() {
        // Arrange
        var score = new Score();

        // Act
        score.incrementRightPoint();

        // Assert
        var expectedPoint = new Point();
        expectedPoint.next();
        assertThat(score.getRightPoint()).isEqualTo(expectedPoint);
    }
}
