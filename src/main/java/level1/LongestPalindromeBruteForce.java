package level1;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by jay on 1/20/16.
 */
public class LongestPalindromeBruteForce {

    public static String longestPalindrome(String str){

        //Make sure the string is not null or empty
        if(StringUtils.isEmpty(str)){
            return "";
        }

        // Store the size of the longest palindrome
        int longest = 1;

        // Use the first char as the longest substring, in case there is none
        String longestSubstring = str.substring(0,1);

        int size = str.length();

        //e.g. deabcfg
        // This double for loop checks below string to see is the string a palindrome.
        //i=0,j=(1-6)     de, dea, deab, deabc, deabcf, deabcfg
        //i=1,j=(2-6)      ea, eab, eabc, eabcf, eabcfg
        //i=2,j=(3-6)       ab, abc, abcf, abcfg
        //i=3,j=(4-6)        bc, bcf, bcfg
        //i=4,j=(5-6)         cf, cfg
        //i=5,j=(6)            fg

        for(int i=0; i<size; i++){

            for(int j=i+1; j<size; j++){

                String substring = str.substring(i, j+1);

                //N^2
                boolean isPalindrome = isPalindrome(substring);

                // the substring is palindrome and longest than our record then replace this as the new record
                if(isPalindrome && substring.length() > longest){
                    longestSubstring = substring;
                    longest = substring.length();
                }
            }
        }

        return longestSubstring;
    }

    private static boolean isPalindrome(String substring) {

        for(int i=0, j=substring.length()-1; i<substring.length()/2; i++,j-- ){

            if(substring.charAt(i) != substring.charAt(j)){
                return false;
            }
        }
        return true;
    }

    private static boolean isPal(String str){
        return new StringBuilder(str).reverse().toString().equals(str);
    }

    public static void main(String[] args) {

        String result = LongestPalindromeBruteForce.longestPalindrome("eadcdbc");
        System.out.println(result);

        result = LongestPalindromeBruteForce.longestPalindrome("~!@#$$#@!~");
        System.out.println(result);

        result = LongestPalindromeBruteForce.longestPalindrome("abcdefg");
        System.out.println(result);

        result = LongestPalindromeBruteForce.longestPalindrome("iciadrmdaici");
        System.out.println(result);

    }



}
