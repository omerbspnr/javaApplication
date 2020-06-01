package org.csystem.samples.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomDoubleRange implements Iterable<Double> {
    private double m_min, m_max;
    private int m_cnt;

    public RandomDoubleRange(double min, double max)
    {
        this(min, max, 10);
    }

    public RandomDoubleRange(double min, double max, int cnt)
    {
        if (max < min)
            throw new IllegalArgumentException("max has to be greater than min");

        m_min = min;
        m_max = max;
        m_cnt = cnt;
    }

    private static final Random RANDOM = new Random();

    @Override
    public Iterator<Double> iterator()
    {
        return new Iterator<>()
        {
            private int count;

            @Override
            public boolean hasNext()
            {
                return count < m_cnt;
            }

            @Override
            public Double next()
            {
                if (!hasNext())
                    throw new NoSuchElementException();

                ++count;

                return RANDOM.nextDouble() * (m_max - m_min) + m_min;

            }


        };
    }
}
