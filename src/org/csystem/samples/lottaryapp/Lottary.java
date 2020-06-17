package org.csystem.samples.lottaryapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Lottary {
    private Random m_rand;


    private int[] getNumbers()
    {
        int i = 0;
        int [] res = new int [6];

        TreeSet<Integer> numbers = new TreeSet<>();

        while (numbers.size() != res.length)
            numbers.add(m_rand.nextInt(49) + 1);


        while(!numbers.isEmpty()) {
            res[i++] = numbers.pollFirst();
        }


        return res;



    }

    public Lottary()
    {
        m_rand = new Random();
    }

    public int [][] getNumbers(int n)
    {
        int [][] numbers = new int[n][];

        for (int i = 0; i < n; ++i)
            numbers[i] = getNumbers();

        return numbers;
    }
}
