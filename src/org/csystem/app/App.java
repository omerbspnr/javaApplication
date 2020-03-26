/*----------------------------------------------------------------------------------------------------------------------
    Sınıf Çalışması: Komut satırı argümanları ile veya klavyeden 
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

import org.csystem.util.ArrayUtil;
import org.csystem.util.Console;
import org.csystem.util.StringUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import static org.csystem.util.ArrayUtil.*;
public class App {
    public static void main(String[] args)
    {
        int [] a = new int[]{Integer.MIN_VALUE};
        int [] a1 = new int [] {Integer.MAX_VALUE};

        System.out.println(Arrays.compareUnsigned(a, a1) );

    }
}

class Person {
    private int m_age;
    public Person(int age)
    {
        m_age = age;
    }

    public int compare(Person other)
    {
        return m_age - other.m_age;
    }



    public int getAge()
    {
        return m_age;
    }

}
