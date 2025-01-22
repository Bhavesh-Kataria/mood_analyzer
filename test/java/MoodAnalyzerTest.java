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
        String actualMood = null;
        MoodAnalyzer m = new MoodAnalyzer("I am currently feeling very sad too much");

        //act
        try{
            actualMood = m.analyzeMood();
        }catch (InvalidMoodException ime){
            System.out.println(ime.getExceptionType());
        }

        //assert
        assertEquals(expectedMood,actualMood,"provided message did not produce SAD mood as expected");
    }

    @Test
    @DisplayName("Testing Happy Mood Message returns Happy")
    void testAnalyzeMood_GivenHappyMoodMessage_ShouldReturnHAPPY() {
        //arrange
        String expectedMood = "Happy";
        String actualMood = null;
        MoodAnalyzer m = new MoodAnalyzer("Today is a happy day");

        //act
        try {
            actualMood = m.analyzeMood();
        } catch (InvalidMoodException ime) {
            System.out.println(ime.getExceptionType());
        }
        //assert
        assertEquals(expectedMood, actualMood, "provided message did not produce HAPPY mood as expected");
    }

//    @Test
//    @DisplayName("Testing null Mood returns Happy")
//    void testAnalyzeMood_GivenNull_ShouldReturnHAPPY(){
//        //arrange
//        String expectedMood = "Happy";
//        MoodAnalyzer m = new MoodAnalyzer(null);
//
//        //act
//        String actualMood = m.analyzeMood();
//
//        //assert
//        assertEquals(expectedMood,actualMood,"provided null message did not produce HAPPY mood as expected");
//    }

    @Test
    @DisplayName("Testing Null Mood Message Throws InvalidMoodException indicating NULL TYPE")
    void testAnalyzeMood_GivenNullMoodMessage_ShouldThrowInvalidMoodException(){
        //arrange
        MoodAnalyzer m = new MoodAnalyzer(null);
        ExceptionTypes et = ExceptionTypes.EMPTY_MESSAGE;
        //act
        try{
            m.analyzeMood();
        }catch (InvalidMoodException ime){
            et = ime.getExceptionType();
        }

        //assert
        assertEquals(ExceptionTypes.NULL_MESSAGE,et,"Should have caught Null message exception");
    }

    @Test
    @DisplayName("Testing Empty Mood Message Throws InvalidMoodException indicating Empty TYPE")
    void testAnalyzeMood_GivenEmptyMoodMessage_ShouldThrowInvalidMoodException(){
        //arrange
        MoodAnalyzer m = new MoodAnalyzer("");
        ExceptionTypes et = ExceptionTypes.NULL_MESSAGE;
        //act
        try{
            m.analyzeMood();
        }catch (InvalidMoodException ime){
            et = ime.getExceptionType();
        }

        //assert
        assertEquals(ExceptionTypes.EMPTY_MESSAGE,et,"Should have caught Empty message exception");
    }

}
