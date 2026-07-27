package model;

public class Enrollment {
    private Student student;
    private Course course;
    private double grade;
    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        
    }

    // getters
    public Student getStudent() {
        return student;
    }
    public Course getCourse() {
        return course;
    }
    public double getGrade() {
        return grade;
    }

    // setters

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
