/*----------------------------------------------------------------------------------------------------------------------
    CSDArrayList sınıfı
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CSDArrayList<T> implements Iterable<T>, Cloneable{
    private static final int DEFAULT_CAPACITY = 10;
    private T[] m_elems;
    private int m_index;
    private static <T> void copy(T [] source, T [] dest)
    {

    }
    private static void controlForCapacity(int capacity, String msg)
    {
        if (capacity < 0)
            throw new IllegalArgumentException(msg);
    }
    @SuppressWarnings("unchecked")
    private void allocateCapacity(int capacity)
    {
        m_elems = Arrays.copyOf(m_elems,capacity);
    }

    private void controlForIndex(int index, String msg)
    {

        if (index < 0 || index >= m_index)
            throw new IndexOutOfBoundsException(msg);
    }


    public CSDArrayList()
    {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public CSDArrayList(int initialCapacity)
    {
        controlForCapacity(initialCapacity, "illegal argument");

        m_elems = (T [])new Object[initialCapacity];
    }
    public boolean add(T elem)
    {
        if (m_index == m_elems.length)
            this.allocateCapacity(m_elems.length != 0 ? m_elems.length * 2 : 1);

        m_elems[m_index++] = elem;

        return true;
    }

    public void add(int index, T elem)
    {
        //TODO:
    }

    public int capacity() {return m_elems.length;}

    public void clear()
    {
        for (int i = 0; i < m_index; ++i)
            m_elems[i] = null;

        m_index = 0;
    }

    public void ensureCapacity(int capacity)
    {

    }

    public T get(int index)
    {
        this.controlForIndex(index, "Index out of bounds");

        return m_elems[index];
    }

    public T remove(int index)
    {
        //TODO:

        return null;
    }

    public T set(int index, T elem)
    {
        this.controlForIndex(index, "Index out of bounds");
        T oldElem = m_elems[index];

        m_elems[index] = elem;

        return oldElem;
    }
    public boolean contains(Object o)
    {
        return this.indexOf(o) >= 0;
    }
    public int indexOf(Object elem)
    {
        int index = -1;
        if (elem == null)
        {
            for (int i = 0; i < m_index;++i)
                if (m_elems[i] == null) {

                    index = i;
                    break;
                }
        } else {
            for (int i = 0; i < m_index; ++i) {
                if(elem.equals(m_elems[i])) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
    @Override
    public Iterator<T> iterator ()
    {
        return new Iterator<T>(){
            private int idx = 0;

            public boolean hasNext()
            {
                return idx < m_index;
            }
            public T next()
            {
                if (!hasNext())
                    throw new NoSuchElementException();
                return CSDArrayList.this.get(idx++);
            }
        };
    }
    public int size() {return m_index;}

    public void trimToSize()
    {
        this.allocateCapacity(m_index);
    }

    public Object clone()
    {
        CSDArrayList<T> clone = new CSDArrayList<T>(m_elems.length);
        clone.m_elems = Arrays.copyOf(m_elems,m_index);
        clone.m_index = m_index;
        return clone;
    }
}
