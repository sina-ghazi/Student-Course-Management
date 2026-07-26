package model;

import java.util.Objects;
public class Student extends Person {
    
   
    private static int idCounter;
    private int id;
    private int term;
    
    private Major major;
    
    
    public Student (String firstName, String lastName, int term, Major major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.term = term;
        this.major = major;
        this.id = idCounter++;
    }
    
    // public boolean isTopStudent() {
    //     return (calculateAverage() >= 17);
    // }
    // public boolean isPassed() {
    //     return(calculateAverage() >= 12);
    // }
    

    // getters 

    public String getName() {
        return (firstName + " " + lastName);
    }
    public int getId() {
        return id;
    }
    public String getFormattedId() {
        return idFmt.format(id);
    }
    public int getTerm() {
        return term;
    }
    public Major getMajor() {
        return major;
    }
    
    

    // setters



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if(!(object instanceof Student)) return false;
        return (this.id == ((Student)object).id);

    }
}
 