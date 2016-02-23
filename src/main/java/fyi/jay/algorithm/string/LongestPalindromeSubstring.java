package fyi.jay.algorithm.string;

import java.util.Arrays;

/**
 * Linear Approach
 *
 * Created by jay on 2/20/16.
 */
public class LongestPalindromeSubstring {

    private final static String pipe = "|";

    private final static String start = "<";
    private final static String end = ">";


    /**
     * Transform string s into string t using a special pipe char "|" at both end of the string s
     * and in between chars
     *
     * start and end characters are use for preventing index out of bound, otherwise the program has
     * to check the is the expanding index is within the range.
     *
     * For example, "banana" --> “<|b|a|n|a|n|a|>”.
     **/
    public static String transform(String s) {

        StringBuilder sb = new StringBuilder(start + pipe);

        for(char c : s.toCharArray()){
            sb.append(c).append(pipe);
        }

        return sb.append(end).toString();
    }



    /**
     * Returns the largest elements from the array r
     * @param r
     * @return
     */
    public static int largestElement(int[] r){
        int max = 0;
        int index = 0;

        for ( int i=0; i<r.length; i++){
           if (r[i] > max) {
               max = r[i];
               index = i;
           }
        }
        return index;
    }

    public static String longestPalindrome(int[] result, String s){
        // Find the maximum element in P.
        int centerIndex = largestElement(result);
        int maxLen = result[centerIndex];

        System.out.println(Arrays.toString(result));

        return s.substring((centerIndex - maxLen)/2, maxLen+1 );
    }


}
