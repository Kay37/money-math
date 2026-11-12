package com.pluralsight;

import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;

public class BigDecimalMoneyMath {

    public static void main(String[] args) {

        float floatForMath = 0;
        double doubleForMath = 0.0;
        BigDecimal bigDecimalForMath = BigDecimal.ZERO;

        BigDecimal tenCents = new BigDecimal("0.10");
        System.out.println("Adding by 0.10, ten times: ");
        for (int i = 0; i < 10; i++) {
            floatForMath += .10f;
            doubleForMath += .10;
            bigDecimalForMath = bigDecimalForMath.add(tenCents);
            System.out.println(
                    "Float: " + floatForMath + " | " + "Double: " + doubleForMath +
                            " | " + "Big Decimal: " + bigDecimalForMath);
        }

        floatForMath = 0;
        doubleForMath = 0.0;
        bigDecimalForMath = BigDecimal.ZERO;

        BigDecimal nineteenNinetyNine = new BigDecimal("19.99");
        System.out.println("\nAdding by 19.99, one thousand times: ");
        for (int i = 0; i < 1000; i++) {
            floatForMath += 19.99f;
            doubleForMath += 19.99;
            bigDecimalForMath = bigDecimalForMath.add(nineteenNinetyNine);
        }
        System.out.println(
                "Float: " + floatForMath + " | " + "Double: " + doubleForMath +
                        " | " + "Big Decimal: " + bigDecimalForMath);

        BigDecimal doubleAsBigDecimal = BigDecimal.valueOf(doubleForMath);

        System.out.println("\nIs the float amount equal to the double amount?: " +
                (floatForMath == doubleForMath));
        System.out.println("\nIs the double amount equal to the Big Decimal amount?: "
                + (doubleAsBigDecimal.compareTo(bigDecimalForMath) == 0));
    }
}
