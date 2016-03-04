package fyi.jay.algorithm.string;

import java.util.Arrays;
import java.util.List;

/**
 * Linear Approach
 * http://www.jay.fyi/2016/03/longest-palindrome-manacher-part-ii.htm
 *
 * Created by Jay Yu on 03/02/16.
 * www.jay.fyi
 *
 *
 */
public class LongestPalindromeSubstring_Manacher extends LongestPalindromeSubstring_Basic {

    public static String longestPalindrome(String s) {

        String t = transform(s);
        System.out.println(s + " -->" +t);

        int tSize = t.length();

        // Array result to store the final size of palindrome substrings and all the intermediate expansion results
        int[] result = new int[tSize];

        // center variable uses for the current substring's center, notice that the center index starts from 1
        // as we added a char pipe at the both ends.
        int center = 1;
        // right variable uses for indicate the right boundary of the current substring
        int right = 2;

        // index i is used for finding the palindrome
        for (int i = 1; i < tSize-1; i++) {

            // Find the mirror of the i
            int i_mirror = 2 * center-i; // equals to i' = C - (i-C)

            // This main logic here is to reduce the complexity - trying to skip the expansion if possible
            // First checking is the current index i within the boundary,
            // if so then return smaller value from either (right boundary - current index ) or result of the mirror i
            result[i] = ( i < right ) ? Math.min(right-i, result[i_mirror]) : 0;

            // Check the array is not out of bound and attempt to expand the palindrome centered at i
            while ( i - 1 - result[i] >=0 && i + 1 + result[i] < tSize && t.charAt(i + 1 + result[i]) == t.charAt(i - 1 - result[i])){
                result[i]++;
            }

            // check is palindrome centered at i expand past the right boundary
            if (i + result[i] > right) {
                // then adjust center based on expanded palindrome.
                center = i;
                right = i + result[i];
            }
        }

        // Find the maximum element in P.
        int centerIndex = largestElement(result);
        int maxLen = result[centerIndex];
        int origStrStart = (centerIndex - maxLen)/2;
        int origStrEnd = origStrStart + maxLen;

        System.out.println("Result=" + Arrays.toString(result));

        return s.substring(origStrStart, origStrEnd);
    }



    public static void main(String[] args) {
        //Test cases
        List<String> strs = Arrays.asList("a", "an", "ana", "anana", "aa", "aaa", "aaaa", "taaae", "tcaaar");

        for (String str: strs) {
            System.out.println("LPS=" + LongestPalindromeSubstring_Manacher.longestPalindrome(str) + "\n" );
        }
    }

}
