package org.csystem.samples.ranges;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;

public class BigDecimalRange implements Iterable<BigDecimal>
{
    private final BigDecimal m_min, m_max;
    private final UnaryOperator<BigDecimal> m_unary;
    public BigDecimalRange(BigDecimal min, BigDecimal max)
    {
        this(min,max,BigDecimal.valueOf(0.001));
    }
    public BigDecimalRange(BigDecimal min, BigDecimal max, BigDecimal range)
    {
        this(min,max, (val) -> val.add(range.compareTo(BigDecimal.ZERO) <= 0 ? BigDecimal.valueOf(0.001) : range));
    }
    public BigDecimalRange(BigDecimal min, BigDecimal max, UnaryOperator<BigDecimal> unary)
    {
        if (min.compareTo(max) > 0 || unary == null)
            throw new IllegalArgumentException();
        m_min = min;
        m_max = max;
        m_unary = unary;
    }
    @Override
    public Iterator<BigDecimal> iterator()
    {
        return new Iterator<>()
        {
            private BigDecimal m_curElem = m_min;
            @Override
            public boolean hasNext()
            {
                return m_curElem.compareTo(m_max) <= 0;
            }
            @Override
            public BigDecimal next()
            {
                if(!hasNext())
                    throw new NoSuchElementException();
                BigDecimal temp = m_curElem;

                m_curElem = m_unary.apply(m_curElem);

                return temp;
            }
        };
    }
}
