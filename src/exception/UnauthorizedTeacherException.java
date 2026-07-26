package exception;

public class UnauthorizedTeacherException extends Exception {
    public UnauthorizedTeacherException() {
        super("You are not allowed to do this action");
    }
}
