package com.solid;

public class LiskovSubstitutionExample {
    /* Objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program
       Broadly put, a class can be replaced by its subclass in all practical usage scenarios. */

    public static void main(String[] args) {
        // this is it: vehicle is a bus and/or car. We do not need to create new object
        Vehicle vehicle = new Bus();
        System.out.println(vehicle.getSpeed());

        vehicle = new Car();
        System.out.println(vehicle.getCubicCapacity());
    }
}

/* for the sake of example, we return 0 */
class Vehicle {

    Vehicle() { }

    /* speed of vehicle */
    public int getSpeed() {
        return 0;
    }

    /* vechicle capacity in cubes */
    public int getCubicCapacity() {
        return 0;
    }
}

class Car extends Vehicle {

    Car() { }

    @Override
    public int getSpeed() {
        return 220;
    }

    @Override
    public int getCubicCapacity() {
        return 110;
    }

    public boolean isHatchBack() {
        return true;
    }
}

class Bus extends Vehicle {

    Bus() { }

    @Override
    public int getSpeed() {
        return 180;
    }

    public String getEmergencyExitLocation() {
        return "At back";
    }
}

/* bad case */
class Transportation {
    String name;
    double speed;
    String engine;

    // getters / setters if needed
    public void startEngine() {
        System.out.println("Starting transportation engine");
    }
}

class NewCar extends Transportation {
    @Override
    public void startEngine() {
        System.out.println("Starting new cars engine");
    }
}

class Bicycle extends Transportation {
    @Override
    public void startEngine() {
        System.out.println("Oh wait... I dont have engine!");
    }
}

// Now we are in trouble and have gone too far.
// These are the problem we face when using LSP w/o focusing too much
// In this case you should make different classes for different engine systems and extend / implement that


