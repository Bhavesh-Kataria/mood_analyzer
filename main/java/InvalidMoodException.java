public class InvalidMoodException extends Exception{
    ExceptionTypes et;
    InvalidMoodException(ExceptionTypes et){
        this.et = et;
    }
    public ExceptionTypes getExceptionType(){
        return et;
    }
}
