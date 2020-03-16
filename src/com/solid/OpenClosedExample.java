package com.solid;


public class OpenClosedExample {
    // Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.

    public static void main(String[] args) {
        NewCircle circle = new NewCircle(5.0);
        NewAreaCalculator calculator = new NewAreaCalculator();

        // circle is shape and we can pass that as parameter to area calculator
        System.out.println(calculator.calculateShapeArea(circle));
    }
}

/* bad example */
class Rectangle {
    public double length;
    public double width;
}

// adding new shape
class Circle {
    public double radius;
}

class AreaCalculator {
    public double calculateRectangleArea(Rectangle rectangle) {
        return rectangle.length * rectangle.width;
    }

    public double calculateCircleArea(Circle circle) {
        return Math.PI * circle.radius * circle.radius;
    }
}

/*
whenever new shape is coming into play, we need to modify AreaCalculator class
this design is not closed for modifications, and thus, breaks OCP
 */


/* correct way */
interface Shape {
    double calculateArea();
}

class NewRectangle implements Shape {
    public double length;
    public double width;

    @Override
    public double calculateArea() {
        return length * width;
    }
}

class NewCircle implements Shape {
    public double radius;

    NewCircle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class NewAreaCalculator {

    NewAreaCalculator() { };

    public double calculateShapeArea(Shape shape) {
        return shape.calculateArea();
    }
}

// now design is open for extension as more shapes can be added w/o modifying the existing code
// and closed for modifications. AreaCalculator is complete.