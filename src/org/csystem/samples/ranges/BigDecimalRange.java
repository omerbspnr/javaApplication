package org.csystem.samples.ranges;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;

public final class BigDecimalRange implements Iterable<BigDecimal> {
    private final BigDecimal m_min, m_max;
    private final UnaryOperator<BigDecimal> m_operator;
    private static final BigDecimal INITIAL_STEP = BigDecimal.valueOf(0.01);
    public BigDecimalRange(BigDecimal min, BigDecimal max)
    {
        this(min,max, INITIAL_STEP);
    }
    public BigDecimalRange(BigDecimal min, BigDecimal max, BigDecimal step)
    {
        this(min,max, (val) -> val.add(step));
    }
    public BigDecimalRange(BigDecimal min, BigDecimal max, UnaryOperator<BigDecimal> operator)
    {
        if (min.compareTo(max) > 0 || operator == null )
            throw new IllegalArgumentException();
        m_min = min;
        m_max = max;
        m_operator = operator;
    }
    @Override
    public Iterator<BigDecimal> iterator()
    {
        return new Iterator<BigDecimal>() {

            private BigDecimal m_curr = m_min;

            @Override
            public boolean hasNext()
            {
                return m_curr.compareTo(m_max) <= 0;
            }

            @Override
            public BigDecimal next()
            {
                if (!hasNext())
                    throw new NoSuchElementException();

                BigDecimal temp = m_curr;
                m_curr = m_operator.apply(temp);
                return temp;
            }
        };
    }
}
