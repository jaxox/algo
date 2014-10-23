package projectEuler;

import math.PrimeFactorization;

import java.util.*;

/**
 * The solution is multiplying all maximum exponent of prime factors of the numbers between 2 to X
 *
 *
 * User: jyu
 * Date: 10/22/14
 */
public class SmallestMultiple_Q5 {



    public static long smallestDivisableNumFromOneTo(int num){

        List<List<Long>> results = new ArrayList<List<Long>>();

        for(int i=2; i<=num; i ++){

          List<Long> result = PrimeFactorization.getPrimeFactors(i);

          if(isSame(result)){
           results.add(PrimeFactorization.getPrimeFactors(i));
          }
        }

        removeSubset(results);
        return addUp(results);
    }

    private static void removeSubset(List<List<Long>> results) {

        Map<Long,Integer> infoMap = new HashMap<Long,Integer>();


        //Gather info
        for(List<Long> list: results){
            long key = list.get(0);
            long size = list.size();
            if( infoMap.containsKey(key) && infoMap.get(key)<size || !infoMap.containsKey(key) ){
                infoMap.put(key,list.size());
            }
        }

        //remove subset
        Iterator<List<Long>> iter = results.iterator();

        while(iter.hasNext()){
            List<Long> list = iter.next();
            long key = list.get(0);
            long size = list.size();

            if(!infoMap.containsKey(key)){
               //remove the duplicate
               iter.remove();
               continue;
            }

            if(infoMap.get(key)!=size){
                iter.remove();
            }else if(infoMap.get(key)==size){
                //in case of duplicate
                infoMap.remove(key);
            }
        }







    }

    private static long addUp(List<List<Long>> results) {

        long total =1;

        for(List<Long> list : results){
            for(long num : list){
                total = total * num;

                System.out.print(num + "*");
            }
        }

        System.out.println();
        return total;
    }

    private static boolean isSame(List<Long> result) {
        if(result.size()==0){
            return false;
        }

        long sameNum = result.get(0);

        for(Long num : result){
            if(num!=sameNum){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){

        long start = System.nanoTime();

        System.out.println(smallestDivisableNumFromOneTo(40));

        System.out.println("Time to processed:"+ (System.nanoTime() -start) /(float)100000);

    }
}
