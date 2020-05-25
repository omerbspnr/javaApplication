package org.csystem.samples.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.DoubleUnaryOperator;

public class DoubleRange implements Iterable<Double>
{
    private final double m_min, m_max;
    private final DoubleUnaryOperator m_doubleUnaryOperator;

    public DoubleRange(double min, double max)
    {
        this(min, max, 0.01);
    }
    public DoubleRange(double min, double max, double step)
    {
        this(min, max, (val) -> val + (step <= 0 ? 0.001 : step));
    }
    public DoubleRange(double min, double max, DoubleUnaryOperator doubleUnaryOperator)
    {
        if (min > max || doubleUnaryOperator == null )
            throw  new IllegalArgumentException("max must be smaller than min");
        m_min = min;
        m_max = max;
        m_doubleUnaryOperator = doubleUnaryOperator;
    }
    @Override
    public Iterator<Double> iterator()
    {
        return new Iterator<Double>()
        {
            private double m_curElem = m_min;
            @Override

            public boolean hasNext()
            {
                return m_curElem <= m_max;
            }
            @Override
            public Double next()
            {
                if (!hasNext())
                    throw  new NoSuchElementException();

                double val =  m_curElem;

                m_curElem = m_doubleUnaryOperator.applyAsDouble(m_curElem);

                return val;
            }

        };

    }
}

