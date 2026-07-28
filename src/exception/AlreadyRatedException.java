package exception;
import model.Student;
import model.Teacher;
public class AlreadyRatedException extends Exception{
    public AlreadyRatedException(Teacher teacher, Student student) {
        super("Student " + student.getName() + " has already rated teacher " + teacher.getName());
    }
}
