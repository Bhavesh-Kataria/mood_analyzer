import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoodAnalyzerTest {
    @Test
    @DisplayName("Testing Sad Mood Message returns Sad")
    void testAnalyzeMood_GivenSadMoodMessage_ShouldReturnSAD(){
        //arrange
        MoodAnalyzer m = new MoodAnalyzer();
        String expectedMood = "Sad";

        //act
        String actualMood = m.analyzeMood("I am currently feeling very sad too much");

        //assert
        assertEquals(expectedMood,actualMood,"provided message did not produce SAD mood as expected");
    }
}
