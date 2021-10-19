package tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

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

    @Test
    void leftPlayerScore_should_call_score_to_change_left_point_to_upper() {
        // Arrange & Act
        game.leftPlayerScore();

        // Assert
        verify(score).incrementLeftPoint();
    }

    @Test
    void rightPlayerScore_should_call_score_to_change_right_point_to_upper() {
        // Arrange & Act
        game.rightPlayerScore();

        // Assert
        verify(score).incrementRightPoint();
    }
}
