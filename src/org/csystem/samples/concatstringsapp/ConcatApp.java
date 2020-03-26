package org.csystem.samples.concatstringsapp;


import org.csystem.util.Console;

public class ConcatApp {
    public static void run()
    {
        int n = Console.readInt("Bir sayı giriniz:");
        ConcatStrings app = new ConcatStrings(n, "--");

        app.run();

        Console.writeLine(app.getResult());
    }
}
