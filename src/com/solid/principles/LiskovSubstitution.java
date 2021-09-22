package com.solid.principles;

/*
* if class A is a subtype of class B, we should be able to replace B
*  with A without disrupting the behavior of our program
* */
public class LiskovSubstitution {

    public static void main(String[] args) {
        VehicleWithEngine swift = new MotorCar1();
        VehicleWithoutEngine tesla = new ElectricCar1();

        swift.startEngine();
        swift.accelerate();
        tesla.accelerate();
    }
}

interface Vehicle {
    public void startEngine();
    public void accelerate();
}

class MotorCar implements Vehicle {

    @Override
    public void startEngine() {
        System.out.println("engine started");
    }

    @Override
    public void accelerate() {
        System.out.println("accelerated");
    }
}

class ElectricCar implements Vehicle {

    @Override
    public void startEngine() {
        throw new IllegalStateException("no engine to start");
    }

    /*
    *  Now this violates principle because it changes behaviour of program
    * */

    @Override
    public void accelerate() {
        System.out.println("accelerated");
    }
}

/*
*  Solution
* */

interface Vehicle1 {
    public void accelerate();
}

interface VehicleWithEngine extends Vehicle1 {
    public void startEngine();
}

interface VehicleWithoutEngine extends Vehicle1 {
}

class MotorCar1 implements VehicleWithEngine {

    @Override
    public void startEngine() {
        System.out.println("engine started");
    }

    @Override
    public void accelerate() {
        System.out.println("accelerated");
    }
}

class ElectricCar1 implements VehicleWithoutEngine {

    @Override
    public void accelerate() {
        System.out.println("accelerated");
    }
}



