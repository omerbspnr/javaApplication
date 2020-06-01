package org.csystem.samples.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.IntUnaryOperator;

public final class DownToRange implements Iterable<Integer> {

    private final int m_max, m_min;
    private final IntUnaryOperator m_intUnaryOperator;
    public DownToRange(int max, int min)
    {
        this(max, min, 1);
    }
    public DownToRange(int max, int min, int step)
    {
        this(max, min, val -> val - step);
    }
    public DownToRange(int max, int min, IntUnaryOperator intUnaryOperator)
    {
        if (max < min || intUnaryOperator == null)
            throw new IllegalArgumentException();

        m_max = max;
        m_min = min;
        m_intUnaryOperator = intUnaryOperator;
    }

    public Iterator<Integer> iterator()
    {
        return new Iterator<Integer>() {
            private int m_curr = m_max;
            public boolean hasNext()
            {
                return m_curr >= m_min;
            }

            @Override
            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException();

                int val = m_curr;

                m_curr = m_intUnaryOperator.applyAsInt(m_curr);
                return val;
            }
        };
    }

}
