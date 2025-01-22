import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum ExceptionTypes{
    NULL_MESSAGE,
    EMPTY_MESSAGE,
    INVALID_MESSAGE
}

public class MoodAnalyzer {
    String message;

    MoodAnalyzer(String message){
        this.message = message;
    }

    public String analyzeMood() throws InvalidMoodException{
        String reg = "happy|sad";
        String mood = "";
        Pattern p = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        try{
            if(message.isEmpty()){
                throw  new InvalidMoodException(ExceptionTypes.EMPTY_MESSAGE);
            }
            Matcher m = p.matcher(message);
            if(m.find()){
                if((m.group()).equals("happy")){
                    mood = "Happy";
                }else{
                    mood = "Sad";
                }
            }
            else{
                throw new InvalidMoodException(ExceptionTypes.INVALID_MESSAGE);
            }
        }
        catch (NullPointerException npe) {
            throw new InvalidMoodException(ExceptionTypes.NULL_MESSAGE);
        }
        return mood;
    }

    public static void main(String[] args) {
        String currentMood = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("How are you feeling today express via a message");
        String message = sc.nextLine();
        MoodAnalyzer obj = new MoodAnalyzer(message);
        try{
            currentMood = obj.analyzeMood();
        }catch (InvalidMoodException ime){
            ExceptionTypes et = ime.getExceptionType();
            switch (et){
                case NULL_MESSAGE -> System.out.println("Exception : Message cannot be NULL");
                case EMPTY_MESSAGE -> System.out.println("Exception : Message cannot be Empty");
                case INVALID_MESSAGE -> System.out.println("Exception : Can't Understand your Mood");
            }
        }
        if(currentMood.length()>1){
            System.out.println("User is currently feeling : "+currentMood);
        }
    }
}


