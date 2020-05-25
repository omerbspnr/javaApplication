package org.csystem.app;

import org.csystem.collection.CSDArrayList;
import org.csystem.samples.randomintgenerator.RandomIntGenerator;

import java.awt.List;
import java.util.*;

class App {
    public static void main(String [] args)
    {
        Class<A> cls = A.class;
        for (var a : cls.getInterfaces())
            System.out.println(a.getName());
    }
}

interface IX {
     void foo();
}
interface IY extends IX {
}

class  A implements IY
{
    public void foo(){}
}