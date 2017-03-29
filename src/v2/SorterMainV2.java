package com.sd.sort.v2;
import java.util.Date;
import com.sd.turtle.Weightturtle;

public class SorterMainV2 {
    public static void main(String[] args) {
        String[] B={"John", "Adam", "Skrien", "Smith", "Jones"};
        Comparator stringComp=new StringComparator();
        Sorter.sort(B, stringComp);

        Integer[] C = {new Integer(3), new Integer(1), new Integer(4), new Integer(2)};
        Comparator integerComp=new IntegerComparator();
        Sorter.sort(C, integerComp);

        for(int i=0; i<B.length; i++)
            System.out.println("B["+i+"]="+B[i]);
        for(int i=0; i<C.length; i++)
            System.out.println("C["+i+"]="+C[i]);

        Weightturtle wt30 = new Weightturtle(30);
        Weightturtle wt10 = new Weightturtle(10);
        Weightturtle wt20 = new Weightturtle(20);
        Weightturtle[] wts={wt30, wt10, wt20};
        Comparator turtleComp=new TurtleComparator();
        Sorter.sort(wts, turtleComp);

        for(int i=0; i<wts.length; i++)
            System.out.println("WeightTurtleArray["+i+"]="+wts[i].getWeight());
    }
}

class Sorter {
  public Sorter() {}
    public static void sort(Object[] data, Comparator comp) {
        for(int i=data.length-1; i>=1; i--) {
            int indexOfMax=0;
            for(int j=1; j<=i; j++) {
                if(comp.compare(data[j], data[indexOfMax]) > 0)
                    indexOfMax=j;
                }
                Object temp=data[i];
                data[i]=data[indexOfMax];
                data[indexOfMax]=temp;
        }
    }
}

// declare my own, also possible to use java.util.Comparator
interface Comparator {
    public int compare(Object o1, Object o2);
    public boolean equals(Object o);
}

class IntegerComparator implements Comparator {
    public IntegerComparator() {}
    public int compare(Object o1, Object o2) {
        return (Integer)o1 - (Integer)o2;
    }
}

class StringComparator implements Comparator {
    public StringComparator() {}
    public int compare(Object o1, Object o2) {
        String s1=(String)o1;
        String s2=(String)o2;
        return s1.compareTo(s2);
        //return Integer.parseInt((String) o1) -
        //   Integer.parseInt((String) o2);
    }
}

class DateComparator implements Comparator {
    public DateComparator() {}
    public int compare(Object o1, Object o2) {
      return ((Date) o1).compareTo((Date) o2);
    }
}

class ReverseComparator implements Comparator {
    private final Comparator c;
    public ReverseComparator(Comparator c) {this.c = c; }
    public int compare(Object o1, Object o2) {
        return c.compare(o2, o1);
    }
}

// outside TurtleComparator -> implemented java.util.Comparator
class TurtleComparator implements Comparator {
    public int compare(Object t1, Object t2) {
        return ((Weightturtle)t1).getWeight()-((Weightturtle)t2).getWeight();
    }
}