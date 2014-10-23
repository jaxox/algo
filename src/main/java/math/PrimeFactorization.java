package math;

import java.util.*;

/**
 * User: jyu
 * Date: 10/22/14
 */
public class PrimeFactorization {

    public static List<Long> getPrimeFactors(long num){
        List<Long> pFacts = new ArrayList<Long>();
        long size = num;

        for(long i=2; i<=size ; i++){
            while(num%i==0){
               pFacts.add(i);
               num = num / i;
            }
        }
        return pFacts;
    }


    public static void main(String[] args){

        long start = System.nanoTime();
        System.out.println("Time to processed:"+ (System.nanoTime() -start) /(float)100000);

    }
}
