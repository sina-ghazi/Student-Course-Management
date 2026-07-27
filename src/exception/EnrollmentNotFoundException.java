package exception;


public class EnrollmentNotFoundException extends Exception {
    public EnrollmentNotFoundException() {
        super("This student hasn't enrolled in this course");
    }
}