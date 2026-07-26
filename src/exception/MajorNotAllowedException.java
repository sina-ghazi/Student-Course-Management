package exception;
import model.Major;
import java.util.List;
public class MajorNotAllowedException extends Exception {
    public MajorNotAllowedException(List<Major> allowedMajors) {
        super("Only students with this majors can enroll: \n" + allowedMajors);
    }
}
