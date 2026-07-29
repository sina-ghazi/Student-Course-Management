package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Course {
    private String name;
    private Teacher teacher;
    private String courseCode;
    private int credit;
    private int capacity;
    private int enrolledCount;
    private List<Major> allowedMajors;
    private Department offeredBy;

   
    public Course(String name, int credit, int capacity, List<Major> allowedMajors, 
                    Department offeredBy, Teacher teacher, String courseCode) {
        this.name = name;
        this.credit = credit;
        this.capacity = capacity;
        this.allowedMajors = new ArrayList<>(allowedMajors);
        this.offeredBy = offeredBy;
        this.teacher = teacher;
        this.courseCode = courseCode;
    }

    

    // getters
    
    public Teacher getTeacher() {
        return teacher;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public int getCredit() {
        return credit;
    }
    public String getName() {
        return name;
    }
    public int getEnrolledCount() {
        return enrolledCount;
    }
    public boolean isFull() {
        return !(enrolledCount < capacity);
    }
    public boolean isMajorAllowed(Major major) {
        for (Major m : allowedMajors) {
            if (m == major)
                return true;
        }
        return false;
    } 
    public List<Major> getAllowedMajors() {
        return new ArrayList<>(allowedMajors);
    }
    public Department getDepartment() {
        return offeredBy;
    }

    // setters
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void increaseEnrolledCount() {
        enrolledCount++;
    }
    


    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if(!(object instanceof Course otherCourse)) return false;
        return (this.courseCode.equals(otherCourse.courseCode));
    }
    @Override 
    public String toString() {
        return (this.getName() + "#" + this.getCourseCode());
    }

}
