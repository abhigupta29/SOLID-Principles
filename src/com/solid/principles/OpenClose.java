package com.solid.principles;

/*
Open for Extension, Close for Modification
 */
public class OpenClose {

    public static void main(String[] args) {
        Operation_2 add = new Addition();
        System.out.println(add.calculate(2,3));

        Operation_2 sub = new Subtraction();
        System.out.println(sub.calculate(5,1));
    }

}

class Operation {
    public double calculate(int a, int b, String operation) {
        switch(operation) {
            case "+" :
                return a+b;
            case "-" :
                return a-b;
            default :
                return 0;
        }
    }
    // Here if we want to add new operation lets say "/" then we have to modify this function
    // which violates the principle
}

/* Solution to problem */
interface Operation_2 {
    public double calculate(int a,int b);
}

class Addition implements Operation_2 {
    @Override
    public double calculate(int a, int b) {
        return a+b;
    }
}

class Subtraction implements Operation_2 {
    @Override
    public double calculate(int a, int b) {
        return a-b;
    }
}
