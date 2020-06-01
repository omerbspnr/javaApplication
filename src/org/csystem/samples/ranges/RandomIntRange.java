package org.csystem.samples.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomIntRange implements Iterable<Integer> {
    private int m_min, m_max;
    private int m_cnt;
    private static final Random RANDOM = new Random();
    public RandomIntRange(int min, int max)
    {
        this(min, max, 10);
    }

    public RandomIntRange(int min, int max, int cnt)
    {
        if (min > max  || cnt <= 0)
            throw new IllegalArgumentException("error");

        m_min = min;
        m_max = max;
        m_cnt = cnt;
    }
    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<Integer>()
        {
            private int cnt;
            @Override
            public boolean hasNext()
            {
                return cnt < m_cnt;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw  new NoSuchElementException();

                ++cnt;

                return RANDOM.nextInt(m_max - m_min) + m_min;
            }


        };
    }
}
