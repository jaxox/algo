import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: jyu
 * Date: 10/14/14
 */
public class PowerSet02 {



    public static <T> Set<Set<T>> getPowerSet(Set<T> orgiSet){

        //New sets
        Set<Set<T>> sets = new HashSet<Set<T>>();

        //base case : if original set is empty then return the empty sets
        if(orgiSet.isEmpty()){
            sets.add(new HashSet<T>());
            return sets;
        }

        //head of orgiSet
        List<T> lists = new ArrayList<T>(orgiSet);
        T head = lists.get(0);

        //rest of orgiSet
        List<T> listOfRest = lists.subList(1,lists.size());
        Set<T> rest = new HashSet<T>(listOfRest);

        //get powerSet from the rest
        Set<Set<T>> subSets = getPowerSet(rest);

        //loop ( set <-- subSets)
        for(Set<T> set : subSets){
            // new set
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            // add newSet to the Sets
            sets.add(newSet);
            sets.add(set);
        }


        return sets;

    }


    public static void main(String[] args){

        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);


        System.out.println(PowerSet02.getPowerSet(set));


    }
}
