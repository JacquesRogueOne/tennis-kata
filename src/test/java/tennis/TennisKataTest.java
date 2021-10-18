package tennis;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TennisKataTest {
    @Test
    void begin_should_start_a_new_match() {
        // Arrange
        TennisKata tennisKata = new TennisKata();

        // Act
        Match match = tennisKata.begin();

        // Assert
        assertThat(match).isEqualTo(new Match());
    }

}