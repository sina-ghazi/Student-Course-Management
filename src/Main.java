import model.*;

import java.util.ArrayList;
import java.util.List;

import exception.*;
public class Main {
    public static void main(String[] args) {
        Student firstS = new Student("Ali", "Alipour", 1, Major.MEDICINE);
        Student secondS = new Student("Ahmad", "Nik", 2, Major.LAW);
        Student thirdS = new Student("Sara", "Zal", 2, Major.DISCIPLINE);
        Student fourthS = new Student("Sina", "Ghazi", 2, Major.COMPUTER_ENGINEERING);
        Teacher firstT = new Teacher("Morteza", "Jani", Department.MATHEMATICS);
        Teacher secondT = new Teacher("Ahmad", "Rezayi", Department.ELECTRICAL_AND_COMPUTER_ENGINEERING);
        Teacher thirdT = new Teacher("Rashid", "Rashidi", Department.PHYSICS);
        List<Major> allowedMajors = new ArrayList<>();
        for (Major m : Major.values()) {
            allowedMajors.add(m);
        }
        Course math1 = new Course("Math_1", 3, 3, allowedMajors,
                                Department.ELECTRICAL_AND_COMPUTER_ENGINEERING, firstT, "M101");
        Course math2 = new Course("Math_2", 3, 3, allowedMajors,
                                Department.ELECTRICAL_AND_COMPUTER_ENGINEERING, firstT, "M201");
        allowedMajors.clear();
        allowedMajors.add(Major.COMPUTER_ENGINEERING);
        // allowedMajors = new ArrayList<>();
        // allowedMajors.add(Major.COMPUTER_ENGINEERING);
        Course advancedProgramming1 = new Course("Advanced_Programming_2", 3, 3, allowedMajors,
                                 Department.ELECTRICAL_AND_COMPUTER_ENGINEERING, secondT, "CS201");
        Registrar springTerm = new Registrar();
        try {
        springTerm.enrollInCourse(math1, firstS);
        System.out.println("Student: " + firstS.getName() + " successfully enrolled in " + math1.getName());
        springTerm.enrollInCourse(math2, secondS);
        System.out.println("Student: " + secondS.getName() + " successfully enrolled in " + math2.getName());
        springTerm.enrollInCourse(math2, thirdS);
        System.out.println("Student: " + thirdS.getName() + " successfully enrolled in " + math2.getName());
        springTerm.enrollInCourse(math2, fourthS);
        System.out.println("Student: " + fourthS.getName() + " successfully enrolled in " + math2.getName());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            springTerm.enrollInCourse(advancedProgramming1, fourthS);
            System.out.println("Student: " + fourthS.getName() + " successfully enrolled in " + advancedProgramming1.getName());
            springTerm.enrollInCourse(advancedProgramming1, firstS);
            System.out.println("Student: " + firstS.getName() + " successfully enrolled in " + advancedProgramming1.getName());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            springTerm.enrollInCourse(math2, fourthS);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            springTerm.gradeStudent(firstT, firstS, math1, 16);
            System.out.println("Student " + firstS.getName() + " got grade");
            springTerm.gradeStudent(firstT, secondS, math2, 11);
            System.out.println("Student " + secondS.getName() + " got grade");
            springTerm.gradeStudent(firstT, thirdS, math2, 19.5);
            System.out.println("Student " + thirdS.getName() + " got grade");
            springTerm.gradeStudent(firstT, fourthS, math2, 19);
            System.out.println("Student " + fourthS.getName() + " got grade");
            springTerm.gradeStudent(secondT, fourthS, advancedProgramming1, 19);
            System.out.println("Student " + fourthS.getName() + " got grade");
            springTerm.gradeStudent(firstT, firstS, math2, 13);
            System.out.println("Student " + firstS.getName() + " got grade");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            springTerm.gradeStudent(secondT, fourthS, math2, 10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(springTerm.getCourseStudentsSortedByGrade(math2));

        //springTerm.passStudents();

        // second registrar
        Registrar fallTerm = new Registrar();
        allowedMajors.clear();
        for (Major m : Major.values()) {
            allowedMajors.add(m);
        }
        Course physics2 = new Course("Physics_2", 3, 3, allowedMajors,
                            Department.PHYSICS, thirdT, "PHY201");
        allowedMajors.clear();
        allowedMajors.add(Major.COMPUTER_ENGINEERING);
        Course dataStructure1 = new Course("Data_Structure", 3, 3, allowedMajors, 
                            Department.ELECTRICAL_AND_COMPUTER_ENGINEERING, secondT, "DS301");
        try{
            fallTerm.enrollInCourse(physics2, secondS);
            System.out.println("Student: " + secondS.getName() + " successfully enrolled in " + physics2.getName());
            fallTerm.enrollInCourse(physics2, thirdS);
            System.out.println("Student: " + thirdS.getName() + " successfully enrolled in " + physics2.getName());
            fallTerm.enrollInCourse(physics2, fourthS);
            System.out.println("Student: " + fourthS.getName() + " successfully enrolled in " + physics2.getName());
            fallTerm.enrollInCourse(dataStructure1, fourthS);
            System.out.println("Student: " + fourthS.getName() + " successfully enrolled in " + dataStructure1.getName());
            fallTerm.enrollInCourse(dataStructure1, thirdS);
            System.out.println("Student: " + thirdS.getName() + " successfully enrolled in " + dataStructure1.getName());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            fallTerm.gradeStudent(thirdT, secondS, physics2, 0);
            System.out.println("Student " + secondS.getName() + " got grade");
            fallTerm.gradeStudent(thirdT, thirdS, physics2, 12);
            System.out.println("Student " + thirdS.getName() + " got grade");
            fallTerm.gradeStudent(thirdT, fourthS, physics2, 17);
            System.out.println("Student " + fourthS.getName() + " got grade");
            fallTerm.gradeStudent(secondT, fourthS, dataStructure1, 16);
            System.out.println("Student " + fourthS.getName() + " got grade");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Student " + fourthS + " GPA on " + "Spring" + " term: " + springTerm.calculateGPA(fourthS)); 
        System.out.println("Student " + fourthS + " GPA on " + "Fall" + " term: " + fallTerm.calculateGPA(fourthS));

        System.out.println("Student " + fourthS + " Overall GPA :" + Registrar.calculateAverageOverallGPA(fourthS));
        
    }
}
