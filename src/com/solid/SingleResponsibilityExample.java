package com.solid;

import java.util.Date;

// cohesion (sometimes also known as coupling)
// is a way to measure how much the code segments within one module belong together
// the higher the cohesion the better, since high cohesion implies easier
// maintenance and dubugging, reusability and functionality

// the module / class should only have one reason to change
// which means that responsibility = reason to change


/* bad example */
class Employee {
    private String employeeId;
    private String name;
    private String address;
    private Date dateOfJoining;

    Employee() { }

    public boolean isPromotionDueThisYear() {
        // logic goes here
        return true;
    }

    public Double calculateIncomeTaxForCurrentYear() {
        // calculations ...
        return 0.0;
    }

    /* getters / setters if needed */
}
/*  now everything is good at first sight
    but it breaks the SRP:
        1. it is not employees decision to decide the promotion, it should HR departments decision.
        2. tax calculation is not employees decision. do you make your tax calculations?
        3. Employee should have the single responsibility of maintaining core attributes
        (most probably should be parent class since HR people are employees, accountants are employees etc)
 */

// after refactoring things could and should be something like this:
class HumanResources {

    public boolean isPromotionDueThisYear(Employee employee) {
        // promotion logic goes here
        return true;
    }
}

class TaxCalculations {

    public Double calculateIncomeTaxForCurrentYear(Employee employee) {
        // calc logic here
        return 0.0;
    }
}

class NewEmployee {
    private String employeeId;
    private String name;
    private String address;
    private Date dateOfJoining;
    //Getters & Setters for all the private attributes
}







// bad example
class Text {
    String text;
    String author;
    int length;

    /* methods that change the text obj */
    void allLettersToUpperCase() { }

    /* method that finds subpart of String s and deletes it */
    void findSubtextAndDelete(String s) { }

    /* print text */
    void printText() { }

    /* getters / setters */
}

// to fix things
class NewText {
    private String text;
    private String author;

    NewText() { }

    /*methods to change the text */
    void allLettersToUpperCase() { }
    void findSubtextAndDelete(String s) { }

}

class Printer {
    Text text;

    Printer(Text text) {
        this.text = text;
    }

    void printText() { }
}

