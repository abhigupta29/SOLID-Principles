package com.solid.principles;

/*
* larger interfaces should be split into smaller ones.
*  By doing so, we can ensure that implementing classes
*  only need to be concerned about the methods that are of interest to them.
* */
public class InterfaceSegregation {

    public static void main(String[] args) {
        Zookeeper zookeeper = new Zookeeper();
        zookeeper.washTheBeer();
        zookeeper.feedTheBear();
    }
}

interface BearKeeper {
    void washTheBear();
    void feedTheBear();
    void petTheBear();
    /*
    * let's say zookeeper is happy to wash and feed the bear
    * but afraid to pet the bear because of danger.
    * Choice should be with zookeeper what he wants to implement
    * */
}

// Solution

interface BearWasher {
    void washTheBeer();
}

interface BearFeeder {
    void feedTheBear();
}

interface BearPetter {
    void petTheBear();
}

class Zookeeper implements BearWasher, BearFeeder {
    @Override
    public void washTheBeer() {
        System.out.println("washing the bear");
    }

    @Override
    public void feedTheBear() {
        System.out.println("feeding the bear");
    }
}

