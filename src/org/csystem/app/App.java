package org.csystem.app;


import java.util.*;
import java.util.function.*;

class App {
    public static void main(String[] args)
    {
        Object[] names = new String[3];
        names[0] = String.valueOf(0);
        System.out.println(names[0]);

        System.out.println(names.getClass().getName());
    }

}

interface IX {
    void foo();
}
interface IY {
    void foo();
}


class Util {
    public static OptionalLong findFirst(long [] a, LongPredicate pred)
    {
        for (long l : a)
            if(pred.test(l))
                return OptionalLong.of(l);

        return OptionalLong.empty();
    }
    public static OptionalInt findFirst(int [] a, IntPredicate pred) {
        for (int val : a)
            if(pred.test(val))
                return OptionalInt.of(val);

            return OptionalInt.empty();
    }

    public static <T> Optional<T>  findFirst(ArrayList<T> arrayList, Predicate<T> pred)
    {
        for (T elem : arrayList)
            if (pred.test(elem))
                return Optional.of(elem);

        return Optional.empty();
    }
}