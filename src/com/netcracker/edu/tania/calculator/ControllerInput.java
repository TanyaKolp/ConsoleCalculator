package com.netcracker.edu.tania.calculator;

import java.util.Scanner;

/**
 * Created by tania on 7/19/16.
 */

/**
 * The class {@code ControllerInput} tells user, what input
 * is expected from him, then read entry and checks its correctness.
 */
public class ControllerInput {
    double[] operands = new double[2];
    Scanner sc = new Scanner(System.in);
    Operations operation = Operations.getInstance();

    public void init() {
        getHelp();
        printAvailableOperations();
        setN1();
        while (true) {
            System.out.println("Enter the sign of operation:");
            String input = sc.next();
            if (input.equalsIgnoreCase("clear")) {
                setN1();
            } else if (input.equalsIgnoreCase("off")) {
                break;
            } else {
                CalculationOp op = setOperation(input);
                if (op.isFunction()) {
                    operands[0] = op.calculate(operands);
                    System.out.println("Result:" + operands[0]);
                } else {
                    setN2();
                    operands[0] = op.calculate(operands);
                    System.out.println("Result:" + operands[0]);
                }
            }
        }
    }

    public void getHelp() {
        System.out.println("\n------Instruction.------" +
                "\nConsole Calculator has 4 standard operations: " +
                "\naddition, subtraction, multiplication and division." +
                "\nTo add a new operations (including functions) " +
                "\nyou must write the full names of classes, that implement" +
                "\nthe interface <CalculationOp> to a text file: NewOperations." +
                "\n" +
                "\nAfter words 'Enter the sign of operation:' enter:" +
                "\n  clear - to remove from memory the result and enter a new number as operand 1" +
                "\n  off - to finish work\n");
    }

    public void printAvailableOperations() {
        System.out.printf("Available operations: ");
        for (String key : operation.operations.keySet()) {
            System.out.printf(" " + key + ",");
        }
    }

    private void setN1() {
        System.out.println("\nEnter the first number:");
        operands[0] = checkN(sc.next());
    }

    private void setN2() {
        System.out.println("\nEnter the second number:");
        operands[1] = checkN(sc.next());
    }

    private double checkN(String input) {
        double n;
        while (true) {
            if (isNumber(input)) {
                n = new Double(input);
                break;
            } else {
                System.out.println("Incorrect imput!");
                System.out.println("Please, enter the number again: ");
                input = sc.next();
            }
        }
        return n;
    }

    private boolean isNumber(String numb) {
        try {
            new Double(numb);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private CalculationOp setOperation(String input) {
        String opStr = input;
        boolean flag = true;
        while (flag) {
            for (String key : operation.operations.keySet()) {
                if (opStr.equals(key)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Incorrect imput!");
                printAvailableOperations();
                System.out.println("\nPlease, enter the sign of operation again:");
                opStr = sc.next();
            } else {
                break;
            }
        }
        return operation.operations.get(opStr);
    }


}
