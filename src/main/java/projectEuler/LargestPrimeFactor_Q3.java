package projectEuler;

import math.PrimeFactorization;

import java.util.List;

/**
 * The solution is multiplying all maximum exponent of prime factors of the numbers between 2 to X
 *
 *
 * User: jyu
 * Date: 10/22/14
 */
public class LargestPrimeFactor_Q3 {


    public static void main(String[] args){
       long start = System.nanoTime();
        List<Long> primeFactors = PrimeFactorization.getPrimeFactors(600851475143L);
        long largestPrimeFactor = primeFactors.get(primeFactors.size()-1);
        System.out.println(largestPrimeFactor);
        System.out.println("Time to processed:"+ (System.nanoTime() -start) /(float)100000);
    }
}
