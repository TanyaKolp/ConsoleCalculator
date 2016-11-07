package com.netcracker.edu.tania.calculator;

/**
 * Created by tania on 7/19/16.
 */
public class Mult implements CalculationOp {
    private String signOfOperation = "*";
    @Override
    public String getSignOfOperation() {
        return signOfOperation;
    }

    @Override
    public double calculate(double[] args) {
        double result;
        result = args[0] * args[1];
        return result;
    }

    @Override
    public boolean isFunction() {
        return false;
    }
}
