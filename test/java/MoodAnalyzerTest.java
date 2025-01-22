import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoodAnalyzerTest {

    @Test
    @DisplayName("Testing Sad Mood Message returns Sad")
    void testAnalyzeMood_GivenSadMoodMessage_ShouldReturnSAD(){
        //arrange
        String expectedMood = "Sad";
        MoodAnalyzer m = new MoodAnalyzer("I am currently feeling very sad too much");

        //act
        String actualMood = m.analyzeMood();

        //assert
        assertEquals(expectedMood,actualMood,"provided message did not produce SAD mood as expected");
    }

    @Test
    @DisplayName("Testing Happy Mood Message returns Happy")
    void testAnalyzeMood_GivenHappyMoodMessage_ShouldReturnHAPPY(){
        //arrange
        String expectedMood = "Happy";
        MoodAnalyzer m = new MoodAnalyzer("Today is a happy day");

        //act
        String actualMood = m.analyzeMood();

        //assert
        assertEquals(expectedMood,actualMood,"provided message did not produce HAPPY mood as expected");
    }

    @Test
    @DisplayName("Testing null Mood returns Happy")
    void testAnalyzeMood_GivenNull_ShouldReturnHAPPY(){
        //arrange
        String expectedMood = "Happy";
        MoodAnalyzer m = new MoodAnalyzer(null);

        //act
        String actualMood = m.analyzeMood();

        //assert
        assertEquals(expectedMood,actualMood,"provided null message did not produce HAPPY mood as expected");
    }


}
