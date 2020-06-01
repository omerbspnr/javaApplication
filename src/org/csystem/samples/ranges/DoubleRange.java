package org.csystem.samples.ranges;

import java.util.function.DoubleUnaryOperator;

public final class DoubleRange {
    private final double m_min, m_max;
    private final DoubleUnaryOperator m_doubleUnaryOperator;

    public DoubleRange(double min, double max)
    {
        this(min,max, s -> s + 0.001);
    }

    public DoubleRange(double min, double max, double step)
    {
        this(min,max, s -> s + step);
    }

    public DoubleRange(double min, double max, DoubleUnaryOperator doubleUnaryOperator)
    {
        if (min > max || doubleUnaryOperator == null)
            throw new IllegalArgumentException();
        m_min = min;
        m_max = max;
        m_doubleUnaryOperator = doubleUnaryOperator;
    }
}
