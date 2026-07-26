package exception;

public class CourseFullException  extends Exception{
    public CourseFullException() {
        super("This course capacity is already full");
    }
}
