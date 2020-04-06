package org.csystem.app;

import java.math.BigInteger;

class App {
    public static void main(String[] args)
    {
    }
}
class Singleton {
    private static Singleton ms_instance = null;
    private Singleton(){}

    public static Singleton getInstance()
    {
        if (ms_instance == null)
            ms_instance = new Singleton();

        return ms_instance;
    }
}
class A
{
    private   int x;
    public static class B {
        private int x;
        public A build()
        {
            A a = new A();

            System.out.println(a.x);
            return  a;
        }
    }
}