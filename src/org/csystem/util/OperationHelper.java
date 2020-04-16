package org.csystem.util;

public class OperationHelper {
    private Operation m_unaryOperation;

    public OperationHelper(Operation unaryOperation)
    {
        m_unaryOperation = unaryOperation;
    }

    public int doBinaryOperation(int a, int b)
    {
        return m_unaryOperation.apply(a, b);
    }

    public int doUnaryOperation(int val)
    {
        return m_unaryOperation.apply(val);
    }
}
