package tennis;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PointTest {

    @Test
    void hasNext_should_return_false_when_point_value_is_forty() {
        // Arrange
        var point = new Point(Point.FORTY);

        // Act
        boolean hasNext = point.hasNext();

        // Assert
        assertThat(hasNext).isFalse();
    }

    @Nested
    class next {
        @Test
        void should_return_fifteen_when_value_is_love() {
            // Arrange
            var point = new Point(Point.LOVE);

            // Act
            point.next();
            var pointValue = point.getValue();

            // Assert
            assertThat(pointValue).isEqualTo(Point.FIFTEEN);
        }

        @Test
        void should_return_thirty_when_value_is_fifteen() {
            // Arrange
            var point = new Point(Point.FIFTEEN);

            // Act
            point.next();
            var pointValue = point.getValue();

            // Assert
            assertThat(pointValue).isEqualTo(Point.THIRTY);
        }

        @Test
        void should_return_forty_when_value_is_thirty() {
            // Arrange
            var point = new Point(Point.THIRTY);

            // Act
            point.next();
            var pointValue = point.getValue();

            // Assert
            assertThat(pointValue).isEqualTo(Point.FORTY);
        }

    }
}
