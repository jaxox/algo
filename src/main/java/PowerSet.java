/**
 * User: jyu
 * Date: 10/14/14
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {

    public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {


        Set<Set<T>> powerSet = new HashSet<Set<T>>();

        //base case if empty then return an empty set
        if (originalSet.isEmpty()) {
            powerSet.add(new HashSet<T>());
            return powerSet;
        }

        //covert set to List
        List<T> list = new ArrayList<T>(originalSet);
        //get first element
        T head = list.get(0);

        //the rest of the elements
        Set<T> rest = new HashSet<T>(list.subList(1, list.size()));

        Set<Set<T>> subSet = powerSet(rest);

        print(subSet);

        for (Set<T> set : subSet) {
            Set<T> newSet = new HashSet<T>();
                                 System.out.print("Adding head(" + head + ") to newSet(" + newSet + ")");
            newSet.add(head);    System.out.println(" --> newSet("+newSet+")");
                                 System.out.print("Adding set(" + set + ") to newSet(" + newSet + ")");
            newSet.addAll(set);  System.out.println(" --> newSet(" + newSet + ")");
                                 System.out.print("Adding newSet(" + newSet + ") to powerSet(" + powerSet + ")");
            powerSet.add(newSet);System.out.println(" --> powerSet(" + powerSet + ")");
                                 System.out.print("Adding set(" + set + ") to powerSet(" + powerSet + ")");
            powerSet.add(set);   System.out.println(" --> powerSet(" + powerSet + ")");
        }


        print(powerSet);

        return powerSet;
    }

    private static <T> void print(Set<Set<T>> sets) {

        for (Set<T> s :sets ) {
            System.out.print(s);
        }
        System.out.println();

    }

    public static void main(String args[])throws Exception{


        Set<Integer> mySet = new HashSet<Integer>();

        for(int i = 1; i <= 3; i++)
            mySet.add(i);

        long time1 = System.nanoTime();
        Set<Set<Integer>> powSet= PowerSet.powerSet(mySet);
        long time2 = System.nanoTime();

        print(powSet);

        System.out.println("Total time to calculate power set of Numbers " + 2 + " is " + (time2-time1)/(float)1000000 +" milli seconds");


//        Set<Integer> emptySet = new HashSet<Integer>();
//
//        Set<Integer> set = new HashSet<Integer>();
//        set.add(3);
//        set.addAll(emptySet);
//
//        System.out.print(set);



    }


}