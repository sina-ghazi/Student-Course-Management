package model;

import java.text.DecimalFormat;

public abstract class Person {
    String firstName;
    String lastName;
    DecimalFormat idFmt = new DecimalFormat("0000");
}
