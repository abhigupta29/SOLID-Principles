package com.solid.principles;

/*
* dependency inversion refers to the decoupling of software modules.
*  This way, instead of high-level modules depending on low-level modules,
*  both will depend on abstractions.
* */
public class DependencyInversion {
    public static void main(String[] args) {
        Computer computer = new Computer(new WiredKeyboard(), new LEDMonitor());
        computer.getKeyboard().type();
        computer.getMontior().display();
    }
}

class Computer {

    private Keyboard keyboard;
    private Monitor montior;

    public Computer(Keyboard keyboard, Monitor montior) {
        this.keyboard = keyboard;
        this.montior = montior;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Monitor getMontior() {
        return montior;
    }
}

interface Keyboard {
    void type();
}
interface Monitor {
    void display();
}

class WiredKeyboard implements Keyboard {
    @Override
    public void type() {
        System.out.println("typing");
    }
}

class WirelessKeyboard implements Keyboard {
    @Override
    public void type() {
        System.out.println("typing");
    }
}

class LEDMonitor implements Monitor {
    @Override
    public void display() {
        System.out.println("Display Content");
    }
}
