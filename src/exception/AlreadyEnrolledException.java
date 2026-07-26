package exception;

import model.Student;
import model.Course;
public class AlreadyEnrolledException extends Exception{
    public AlreadyEnrolledException(Course course, Student student) {
        super("Student: " + student.getName() + " is already enrolled in " + course.getName() + "#" + course.getCourseCode());
    }
}
