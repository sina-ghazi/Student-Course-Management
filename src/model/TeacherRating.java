package model;

public class TeacherRating {
    private Teacher teacher;
    private Student student;
    private int rate;
   
    public TeacherRating(Teacher teacher, Student student, int rate) {
        this.teacher = teacher;
        this.student = student;
        this.rate = rate;
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public Student getStudent() {
        return student;
    }
    public int getRate() {
        return rate;
    }

}
