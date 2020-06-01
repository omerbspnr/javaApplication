package org.csystem.samples.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.IntUnaryOperator;

public final class IntRange implements Iterable<Integer> {
    private final int m_min;
    private final int m_max;
    private final IntUnaryOperator m_intUnaryOperator;

    public IntRange(int min, int max)
    {
        this(min, max, 1);
    }

    public IntRange(int min, int max, int step)
    {
        this(min, max, (val) -> val + step);
    }

    public IntRange(int min, int max, IntUnaryOperator intUnaryOperator)
    {
        if (min > max || intUnaryOperator == null)
            throw new IllegalArgumentException("Illegal argument");

        m_min = min;
        m_max = max;
        m_intUnaryOperator = intUnaryOperator;

    }

    public Iterator<Integer> iterator()
    {
        return new Iterator<Integer>() {
            private int m_currElem = m_min;

            @Override
            public boolean hasNext()
            {
                return m_currElem <= m_max;
            }

            public Integer next()
            {
                if (!hasNext())
                    throw new NoSuchElementException();

                int temp = m_currElem;
                m_currElem = m_intUnaryOperator.applyAsInt(m_currElem);
                return temp;
            }
        };
    }
}
