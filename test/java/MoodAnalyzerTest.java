import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoodAnalyzerTest {
    MoodAnalyzer m;

    @BeforeEach
    void setup(){
        m = new MoodAnalyzer();
    }

    @Test
    @DisplayName("Testing Sad Mood Message returns Sad")
    void testAnalyzeMood_GivenSadMoodMessage_ShouldReturnSAD(){
        //arrange
        String expectedMood = "Sad";

        //act
        String actualMood = m.analyzeMood("I am currently feeling very sad too much");

        //assert
        assertEquals(expectedMood,actualMood,"provided message did not produce SAD mood as expected");
    }

    @Test
    @DisplayName("Testing Happy Mood Message returns Happy")
    void testAnalyzeMood_GivenHappyMoodMessage_ShouldReturnHAPPY(){
        //arrange
        String expectedMood = "Happy";

        //act
        String actualMood = m.analyzeMood("Today is a happy day");

        //assert
        assertEquals(expectedMood,actualMood,"provided message did not produce HAPPY mood as expected");
    }
}
