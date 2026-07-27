package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import exception.*;
public class Registrar {
    
    private List<Enrollment> enrollments = new ArrayList<>();
    private static List<Registrar> registrars = new ArrayList<>();
    public Registrar() {
        registrars.add(this);
    }
    
    public void enrollInCourse(Course course, Student student) throws AlreadyEnrolledException,
                                                         CourseFullException, MajorNotAllowedException{
        if(isStudentAlreadyExistsInCourse(student, course)) throw new AlreadyEnrolledException(course, student);
        if(course.isFull()) throw new CourseFullException();
        if(!course.isMajorAllowed(student.getMajor())) throw new MajorNotAllowedException(course.getAllowedMajors());
        enrollments.add(new Enrollment(student, course));
        course.increaseEnrolledCount();
    }
    private boolean isStudentAlreadyExistsInCourse(Student student, Course course) {
        for (Enrollment e : enrollments) {
            if (e.getCourse().equals(course) && e.getStudent().equals(student)) {
                return true;
            }
        }
        return false;
    }
    
    
    // private List<Student> return
    // getters
    public List<Student> getCourseStudentsSortedByGrade(Course course) {
        List<Enrollment> sortedEnrollments = getEnrollmentsByCourse(course);
        Collections.sort(sortedEnrollments, (e1, e2) -> Double.compare(e2.getGrade(), e1.getGrade()));
        List<Student> topStudents = new ArrayList<>();
        for(Enrollment e : sortedEnrollments) {
            topStudents.add(e.getStudent());
        }
        return topStudents;
    }
    public Set<Student> getStudentsByRegistrar() {
        Set<Student> students = new HashSet<>(); 
        for(Enrollment e : enrollments) {
            students.add(e.getStudent());
        }
        return students;
    }
    public Set<Student> getStudentsByCourse(Course course) {
        Set<Student> students = new HashSet<>();
        for(Enrollment e : enrollments) {
            if(e.getCourse().equals(course)) {
                students.add(e.getStudent());
            }
        }
        return students;
    }
    public Set<Student> getStudentsByTeacher(Teacher teacher) {
        Set<Student> students = new HashSet<>();
        for(Enrollment e : enrollments) {
            if (e.getCourse().getTeacher().equals(teacher)) {
                students.add(e.getStudent());
            }
        }
        return students;
    }
    
    public List<Enrollment> getEnrollmentsByCourse(Course course) {
        List<Enrollment> enrollmentsByCourse = new ArrayList<>();
        for(Enrollment e : enrollments) {
            if (e.getCourse().equals(course)) {
                enrollmentsByCourse.add(e);
            }
        }
        return enrollmentsByCourse;
    }
    public List<Enrollment> getEnrollmentsByRegistrar() {
        return new ArrayList<>(enrollments);
    }
    public void gradeStudent(Teacher teacher, Student student, Course course, double grade)
                             throws UnauthorizedTeacherException, EnrollmentNotFoundException {
        if(!teacher.equals(course.getTeacher())) throw new UnauthorizedTeacherException();
        for(Enrollment e : enrollments) {
            if (e.getCourse().equals(course) && e.getStudent().equals(student)) {
                e.setGrade(grade);
                return;
            }
        }
        throw new EnrollmentNotFoundException();
         
    }
    public int getCreditsCount(Student student) {
        int creditCount = 0;
        for(Enrollment e : enrollments) {
            if(e.getStudent().equals(student)) {
                creditCount += e.getCourse().getCredit();
            }
        }
        return creditCount;
    }
    public double calculateGPA(Student student) {
        double score = 0;
        int creditCount = getCreditsCount(student);
        for(Enrollment e : enrollments) {
            if(e.getStudent().equals(student)) {
                //System.out.println(e.getCourse());
                score += (e.getGrade() * e.getCourse().getCredit());
                //System.out.println("score += (" + e.getGrade() + " * " + e.getCourse().getCredit() + ")");
            }
        }
        
        if(creditCount == 0) return 0;
        //System.out.println("Count: " + creditCount + " score: " + score);
        return score/creditCount;
    }
    
    public static double calculateAverageOverallGPA(Student student) {
        double GPA = 0;
        int count = 0;
        int registrarCredits;
        for(Registrar registrar : registrars) {
            registrarCredits = registrar.getCreditsCount(student);
            GPA += registrar.calculateGPA(student) * registrarCredits;
            count += registrarCredits;
        }
        if(count == 0) return 0;
        //System.out.println("Count: " + count + " score: " + GPA);
        return GPA/count;
    }
    public boolean isPassed(Student student) {
        return this.calculateGPA(student) >= 12;
    }
    public void passStudents() {
        Set<Student> students = getStudentsByRegistrar();
        for(Student student : students) {
            if(isPassed(student))
                student.setTerm(student.getTerm() + 1);
        }
    }


   
}
