package org.csystem.app;


import java.util.*;

class App {
    public static void main(String [] args)
    {
        Stack<Integer> integers = new Stack<>();

        for (int i= 0; i < 10; ++i)
            integers.push(i);
        for (int i= 0; i < 10; ++i)
            integers.push(i);

        System.out.println(integers.search(8));
        System.out.println(integers.indexOf(8));
    }

}
class ListStack<T> extends ArrayList<T> {


    public boolean push(T t)
    {
        super.add(t);
        return true;
    }
    public T pop()
    {
        if(empty())
            throw new EmptyStackException();

        return super.remove(size() -1);
    }
    public boolean empty()
    {
        return isEmpty();
    }
    public int search(Object obj)
    {
        int index = this.lastIndexOf(obj);
        System.out.println(this.size());
        return index == -1 ? index : this.size() - index;
    }

}