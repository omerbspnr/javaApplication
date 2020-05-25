package org.csystem.samples.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.IntUnaryOperator;

public class IntRange implements Iterable<Integer> {
    private final int m_min, m_max;
    private final IntUnaryOperator m_intUnaryOperator;
    public IntRange(int min, int max)
    {
        this(min, max,1);
    }
    public IntRange(int min, int max, int step)
    {
        this(min, max, (val) -> val <= 1 ? val + 1 : val + step);
    }
    public IntRange(int min, int max, IntUnaryOperator intUnaryOperator) {

        if (min > max || intUnaryOperator == null)
            throw new IllegalArgumentException();

        m_min = min;
        m_max = max;
        m_intUnaryOperator = intUnaryOperator;
    }
    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<>() {
            private int m_curElem = m_min;
            @Override
            public boolean hasNext()
            {
                return m_curElem <= m_max;
            }

            @Override
            public Integer next()
            {
                if(!hasNext())
                    throw  new NoSuchElementException();

                int val = m_curElem;

                m_curElem = m_intUnaryOperator.applyAsInt(m_curElem);

                return val;
            }
        };
    }
}
