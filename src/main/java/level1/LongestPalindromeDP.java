package level1;

/**
 * Created by jay on 1/26/16.
 */
public class LongestPalindromeDP {

    public static String longestPalindromeDP(String str) {


        int size = str.length();

        int[][] matrix = new int[size][size];
        //Highest in the array (where the longest palindrome substring end)
        int highest = 0;
        // where the longest palindrome substring start
        int start = 0;


        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size - i; j++) {

                char head = str.charAt(j);
                char tail = str.charAt(j+i);
                // Head and tail are the same chars
                // AND either
                //            ( The current iteration of the inner for-loop is the first 2 rounds )
                //         OR
                //            ( The previous comparison result (1 row down & 1 left column) which indicates
                //              whether is a palindrome substring)
                if (head == tail && (i < 2 || matrix[j + 1][j + i - 1]==1)) {

                        matrix[j][j + i] = 1;
                        // When comparing the head and tail characters of each substrings,
                        // it starts from the shortest ones to the longest ones. when the i ( outer for-loop) is bigger
                        // than the highest we can safely say that the current substring is at least equal in length or longer.
                        if (i > highest) {
                            highest = i;
                            start = j;
                        }
                }
            }
            printMatrix(matrix);
        }
        System.out.println("Start:"+ start + " End:" + (start+highest+1)  );
        return str.substring(start, start + highest + 1);
    }




    public static void printMatrix(int[][] matrix){

        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print("  " + col);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        String str = LongestPalindromeDP.longestPalindromeDP("AAAA");
        System.out.println(str);
    }

}
