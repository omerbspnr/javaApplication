package org.csystem.util;

import java.io.PrintStream;

public final class RecursionUtil {
    private static final PrintStream ms_out = System.out;

    private static void getReverse(char[] c, int left, int right)
    {
        if (left >= right)
            return;

        char temp;

        temp= c[left];
        c[left] = c[right];
        c[right] = temp;

        getReverse(c, left + 1, right - 1);
    }

    private static void writeReverse(String str, int i)
    {
        if (i == str.length())
            return;

        writeReverse(str, i + 1);
        ms_out.print(str.charAt(i));
    }

    private RecursionUtil()
    {}

    public static long factorial(int n)
    {
        if (n <= 0)
            return 1;

        return n * factorial(n - 1);
    }

    public static String getReverse(String str)
    {
        char [] c = str.toCharArray();

        getReverse(c, 0, c.length - 1);

        return new String(c);
    }

    public static int getFibonacci(int n)
    {
        if (n <= 2)
            return n - 1;

        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }



    public static void writeNumber(int val)
    {
        if (val < 0) {
            ms_out.write('-');
            val = -val;
        }

        if (val / 10 != 0)
            writeNumber(val / 10);

        ms_out.write((char)(val % 10 + '0'));
    }

    public static void writeNumber(int val, int radix)
    {
        if (val < 0) {
            ms_out.write('-');
            val = -val;
        }

        if (val / radix != 0)
            writeNumber(val / radix, radix);

        ms_out.write((char)(val % radix >= 10 ? val % radix - 10 + 'A' : '0' + val % radix));
    }

    public static void writeReverse(String s)
    {
        writeReverse(s, 0);
    }
}
