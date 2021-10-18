package tennis;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MatchTest {
    @Test
    void getStatus_should_return_in_progress_when_the_match_just_start() {
        // Arrange
        Match match = new Match();

        // Act
        String status = match.getStatus();

        // Assert
        assertThat(status).isEqualTo("In Progress");
    }
}