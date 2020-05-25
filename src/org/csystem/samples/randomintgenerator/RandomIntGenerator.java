package org.csystem.samples.randomintgenerator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomIntGenerator implements Iterable<Integer> {
    private int m_min, m_max;
    private final Random rand;
    private int m_count;

    private static void controlForCount(int count)
    {
        if (count < 0)
            throw new IllegalArgumentException("count must be greater than zero");
    }
    private static void controlForRange(int min, int max)
    {
        if (min >= max)
            throw new IllegalArgumentException("max must be greater than min");
    }
    public RandomIntGenerator(int min, int max)
    {
        this(new Random(), min, max);
    }
    public RandomIntGenerator(Random r,int min, int max)
    {
        this(r, min, max, 10);
    }
    public RandomIntGenerator(int min, int max, int count)
    {
        this(new Random(), min, max, count);
    }
    public RandomIntGenerator(Random r, int min, int max, int n)
    {
        controlForRange(min, max);
        controlForCount(n);
        rand = r;
        m_min = min;
        m_max = max;
        m_count = n;
    }

    public void setMin(int min)
    {
        if (min == m_min)
            return;
        controlForRange(min, m_max);
        m_min = min;
    }

    public void setMax(int max)
    {
        if (max == m_max)
            return;
        controlForRange(m_min, max);
        m_max = max;
    }
    public void setBound(int min, int max)
    {
        if(m_min == min && m_max == max)
            return;

        controlForRange(min,max);
        m_min = min;
        m_max = max;
    }
    public void setCount(int count)
    {
        controlForCount(count);
        m_count = count;
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<Integer>() {
            private int count;
            @Override
            public boolean hasNext()
            {
                return count < m_count;

            }

            @Override
            public Integer next()
            {
                if(!hasNext())
                    throw new NoSuchElementException();

                ++count;
                return  rand.nextInt(m_max - m_min) + m_min;
            }
        };
    }
}
