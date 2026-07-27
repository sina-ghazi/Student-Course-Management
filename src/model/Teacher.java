package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher extends Person {
    private static int idCounter;
    private int id;
    private Department department;
    private List<Integer> ratings = new ArrayList<>();
   
    public Teacher(String firstName, String lastName, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.id = idCounter++;
    }
    public void rate(int score) {}
   // public void gradeStudent(Enrollment enrollment, int score) {}
    private int calculateAverageRating() {return 0;}

    // getters 
    public String getName() {
        return(firstName + " " + lastName);
    }
    public int getId() {
        return id;
    }
    public String getFormattedId() {
        return idFmt.format(id);
    }
    public Department getDepartment() {
        return department;
    }
    public List<Integer> getRatings() {
        return ratings;
    }
    public int getAverageRating() {
        return calculateAverageRating();
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(!(object instanceof Teacher)) return false;
        return (this.id == ((Teacher)object).id);
    }
    @Override
    public String toString() {
        return(this.getName() + "#" + this.getFormattedId());
    }

}