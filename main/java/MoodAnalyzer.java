import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoodAnalyzer {
    String message;
    MoodAnalyzer(String message){
        this.message = message;
    }

    String analyzeMood(){
        String reg = "happy|sad";
        Pattern p = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(message);
        String mood = "";
        try{
            if(m.find()){
                if((m.group()).equals("happy")){
                    mood = "Happy";
                }else{
                    mood = "Sad";
                }
            }else{
                throw new InvalidMoodException("User doesn't know his current mood or is not sure about it");
            }

        } catch (InvalidMoodException ime) {
            System.out.println("Caught Exception : "+ime.getMessage());
        }
        return mood;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How are you feeling today express via a message");
        String message = sc.nextLine();
        MoodAnalyzer obj = new MoodAnalyzer(message);
        String currentMood = obj.analyzeMood();
        if(currentMood.length()>1){
            System.out.println("User is currently feeling : "+currentMood);
        }
    }
}


