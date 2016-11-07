package com.netcracker.edu.tania.calculator;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by tania on 9/1/16.
 */
public class Test {
    public static void main(String[] args) {
        Calendar instance2 = Calendar.getInstance(Locale.ITALY);
        Calendar in3 = instance2;
        instance2.add(Calendar.DATE, -120);
        boolean f;
        if (in3.after(instance2)) {
             f = true;
        } else {
            f = false;
        }
        System.out.println(f);
    }
}
