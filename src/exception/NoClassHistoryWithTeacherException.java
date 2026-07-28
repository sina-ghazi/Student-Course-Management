package exception;

import model.Student;
import model.Teacher;

public class NoClassHistoryWithTeacherException extends Exception {
    public NoClassHistoryWithTeacherException(Student student, Teacher teacher) {
        super("Student " + student.getName() + " hasn't taken class with teacher " + teacher.getName());
    }
}
