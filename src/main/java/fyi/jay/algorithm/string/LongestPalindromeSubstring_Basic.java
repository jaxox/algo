package fyi.jay.algorithm.string;

import java.util.Arrays;
import java.util.List;

/**
 * O(N^2) Approach - based on Manacher's algorithm with the DP that utilized
 * the symmetric property. Thus I can show how we can improve from this basic algorithm
 * to O(N).
 *
 * Created by jay on 2/20/16.
 */
public class LongestPalindromeSubstring_Basic extends LongestPalindromeSubstring{

    public static String longestPalindrome(String s) {

        String t = transform(s);

        int tSize = t.length();

        // Result array stores the final size of palindrome substrings and all the intermediate expansion results
        int[] result = new int[tSize];

        // Index i is used for finding the palindrome at the center, the center starts at 1 and the for-loop starts at the next char of center
        for (int i = 1; i < tSize-1; i++) {

            // Check the array is not out of bound and attempt to expand the palindrome centered at i
            while ( i - 1 - result[i] >=0 && i + 1 + result[i] < tSize && t.charAt(i + 1 + result[i]) == t.charAt(i - 1 - result[i])){
                result[i]++;
            }
        }

        //Using the result to get the longest palindrome
        return longestPalindrome(result,s);
    }

    public static void main(String[] args) {
        //Test cases
        List<String> strs = Arrays.asList("a", "an", "ana", "anana", "aa", "aaa", "aaaa", "taaae", "tcaaar");

        for (String str: strs) {
            System.out.println("LPS=" + LongestPalindromeSubstring_Basic.longestPalindrome(str) + "\n" );
        }
    }

}
