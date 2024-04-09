package utcluj.isp.curs3.liste.demoLab6;

import java.util.ArrayList;

public class ExempluEx {
}

class A{ }

class D{ }

class B{ }

class C{
    private ArrayList<A> list = new ArrayList<>();
    private ArrayList<B> list2 = new ArrayList<>();
    void doSomehting(D obj){
        list2.add(new B());
        list2.add(new B());
    }

    void addA(A obj){
        list.add(obj);
    }
}