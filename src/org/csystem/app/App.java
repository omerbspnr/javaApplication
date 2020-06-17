package org.csystem.app;

import org.csystem.util.ArrayUtil;
import org.csystem.util.Console;
import org.csystem.util.NumberUtil;
import org.csystem.util.StringUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class App {
    public static void main(String[] args)
    {
        Random r = new Random();
        int [] a = IntStream
                .generate(() -> r.nextInt(1000))
                .limit(5).toArray();

        System.out.println(Arrays.toString(a));
        System.out.println(IntStream.of(a).noneMatch(NumberUtil::isPrime));
        IntStream.of(a).filter(NumberUtil::isPrime).forEach(System.out::println);

    }
}

class Util {
    public static boolean isPangram(String str, String alphabet) {
        return str.toLowerCase().chars().distinct().count() == alphabet.toLowerCase().length();
    }
}