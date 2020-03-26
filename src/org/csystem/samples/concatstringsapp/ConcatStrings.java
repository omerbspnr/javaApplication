package org.csystem.samples.concatstringsapp;

import org.csystem.util.ArrayUtil;
import org.csystem.util.Console;

public class ConcatStrings {
    private String [] m_str;
    private String m_delim;
    private String m_result;

    private void fillStr()
    {
        for (int i = 0; i < m_str.length; ++i)
            m_str[i] = Console.read("Yazı?");
    }
    public ConcatStrings(int n, char delim)
    {
        this(n, delim + "");
    }

    public ConcatStrings(int n, String delim)
    {
        m_str = new String[n];
        m_delim = delim;
        m_result = "";
    }

    public String[] getStr()
    {
        return m_str;
    }

    public String getResult()
    {
        return m_result;
    }

    public void run()
    {
        fillStr();
        m_result = ArrayUtil.join(m_str, m_delim);
    }
}
