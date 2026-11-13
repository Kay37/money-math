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


        //? Loop 1: are they the same? do they differ?
        //! The BigDecimal was always even (rounded). The float and double were mostly right, but on some rows
        //! (like Double: 0.30000000000000004 or Float: 0.70000005) they're a bit off because
        //! some numbers can't be written exactly. like writing 1/3 as a decimal.
        //? Loop 2: are they the same? do they differ?
        //! The right answer is Big Decimal's output. The float was off by more than the double because a float
        //! keeps about 7 digits - it has a larger rounding error.
        //! a double keeps about 16 digits - the rounding error is present, but much smaller.

        //? Does the float compare with the double?
        //! No - float amount == double amount = false
        //? How does the double compare with the BigDecimal?
        //! double amount == BigDecimal amount = false
        //? Why not?
        //! Float and double use binary fractions. Big Decimal remembers your number as *whole digits* plus where the
        //! decimal point belongs.
        //? How many cents is the float off after 1000 iterations?
        //! 0.184 cents.
        //? Why does the BigDecimal print 1.00 and not 1?
        //! Because I made it with 0.10. 0.10 has two digits after the decimal point, so when we get to 1.00 it will
        //! remember that.
        //? What happens if you call .add(); without assigning the result back to your variable?
        //! The new value just gets thrown away. Not stored anywhere. .add() works out the answer & hands back a
        //! brand new BigDecimal holding that answer. Have to store that BigDecimal somewhere.
    }
}
