package com.solid;


// shows us how dependencies should be designed

// Abstractions should not depend upon details. Details should depend upon abstractions.
// High-level modules should not depend on low-level modules. Both should depend on abstractions.
// combination of liskov substitution and open-closed principles (LSP + OCP)


/* b.a.d example */
class LightBulb {

    public void turnOn() {
        System.out.println("light bulb is turned on");
    }

    public void turnOff() {
        System.out.println("light bulb is turned off");
    }
}

class PowerSwitch {

    public LightBulb lightBulb;
    public boolean on;

    PowerSwitch(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
        this.on = false;
    }

    public boolean isOn() {
        return this.on;
    }

    public void press() {
        boolean checkOn = isOn();
        if (checkOn) {
            lightBulb.turnOff();
            this.on = false;
        } else {
            lightBulb.turnOn();
            this.on = true;
        }
    }
}

/* so what is wrong with this example?
   the case it that PowerSwitch is now directly connected to LightBulb
   we can't switch on/off any other devices.
   for other devices we need to construct different approaches.
 */


/* G.o.o.d example */
interface Switch {
    boolean isOn();  // check if switch is on
    void press();    // press switch
}

// any device that is now switchable can use this interface and create own functionality for that
interface Switchable {
    void turnOn();
    void turnOff();
}

class NewPowerSwitch implements Switch {
    public Switchable client;
    public boolean on;

    NewPowerSwitch(Switchable client) {
        this.client = client;
        this.on = false;
    }

    @Override
    public boolean isOn() {
        return this.on;
    }

    @Override
    public void press() {
        boolean checkOn = isOn();
        if (checkOn) {
            client.turnOff();
            this.on = false;
        } else {
            client.turnOn();
            this.on = true;
        }
    }
}

class NewLightBulb implements Switchable {

    @Override
    public void turnOn() {
        System.out.println("light bulb is on ");
    }

    @Override
    public void turnOff() {
        System.out.println("light bulb is off ");
    }
}

class Fan implements Switchable {

    @Override
    public void turnOn() {
        System.out.println("fan is on ");
    }

    @Override
    public void turnOff() {
        System.out.println("fan is off ");
    }
}


