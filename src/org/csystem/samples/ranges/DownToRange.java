package org.csystem.samples.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.IntUnaryOperator;

public class DownToRange implements Iterable<Integer> {
    private final int m_max, m_min;
    private final IntUnaryOperator m_stepFunc;

    public DownToRange(int max, int min)
    {
        this(max, min, 1);
    }
    public DownToRange(int max, int min, int step)
    {
        this(max,min,val -> val - (step <= 0 ? 1 : step));
    }
    public DownToRange(int max, int min, IntUnaryOperator intUnaryOperator)
    {
        if (max < min || intUnaryOperator == null)
            throw new IllegalArgumentException("max must be greater than min");
        m_max = max;
        m_min = min;
        m_stepFunc = intUnaryOperator;
    }
    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>()
        {
            private int m_curElem = m_max;
            @Override
            public boolean hasNext()
            {
                return m_curElem >= m_min;
            }
            public Integer next()
            {
                if(!hasNext())
                    throw new NoSuchElementException();

                int val = m_curElem;

                m_curElem = m_stepFunc.applyAsInt(m_curElem);

                return val;
            }
        };
    }
}

