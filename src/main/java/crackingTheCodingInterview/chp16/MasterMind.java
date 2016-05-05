package crackingTheCodingInterview.chp16;

import java.util.*;

/**
 * Created by wljas on 5/4/2016.
 */
public class MasterMind {

    static void play(List<Character> solution, List<Character> guess){

        int hit = 0;
        int pHit =0;

        int index = 0;

        Map<Character,Integer> pMap = new HashMap<>();

        //Find hit
        for(Iterator<Character> iter = guess.iterator(); iter.hasNext();){

            char c1 = solution.get(index++);
            char c2 = iter.next();

            if(c1==c2){
                hit++;
                iter.remove();
            }else{
                if(pMap.containsKey(c1)){
                    pMap.put(c1,pMap.get(c1)+1);
                }else{
                    pMap.put(c1,1);
                }
            }
        }

        System.out.println("Hit="+hit);

        //find partial hit
        for(char c: guess){
            if(pMap.containsKey(c)){
                pHit += pMap.get(c);
            }
        }

        System.out.println("Partial Hit="+pHit);

    }

    public static void main(String[] args) {

        List<Character> solution = new ArrayList<>();
        solution.add('R');
        solution.add('Y');
        solution.add('G');
        solution.add('B');

        List<Character> guess = new ArrayList<>();
        guess.add('R');
        guess.add('R');
        guess.add('G');
        guess.add('G');

        play(solution,guess);

    }
}
