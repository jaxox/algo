package crackingTheCodingInterview.chp11;

import java.util.Arrays;

/**
 * Created by jason on 1/14/15.
 */
public class BubbleSort {


    public static void main(String[] args){

        int[] nums = {9,7,5,3,2,1};

        int max = nums.length - 1;
        boolean isSwap = true;

        while(max>0 && isSwap){
            isSwap = false;

            for(int i =0; i < max ; i++){
                if(nums[i] > nums[i+1]){
                    int temp = nums[i];
                    nums[i]  = nums[i+1];
                    nums[i+1]= temp;
                    isSwap = true;
                }

            }
            max--;
        }


        System.out.println(Arrays.toString(nums));


    }
}
