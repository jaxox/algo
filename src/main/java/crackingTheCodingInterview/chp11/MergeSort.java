package crackingTheCodingInterview.chp11;

import java.util.Arrays;

/**
 * Created by jason on 1/15/15.
 */
public class MergeSort {

    private static int[] nums;

    public static void sort(int[] nums2){
        nums = nums2;
        sort(0,nums2.length-1);
    }

    private static void sort(int start, int end){

        //base case
        if(start>=end){
            return;
        }

        int mid = (start + end)/2;

        //sort left
        sort(start, mid);

        //sort right
        sort(mid+1, end);


        //merge
        merge(start, mid, end);


    }

    private static void merge(int start, int mid, int end) {

        //temp
        int[] temp = new int[end+1];


        //copy the nums to the temp
        for(int i=start; i<=end; i++){
            temp[i] = nums[i];
        }


        //pointer for the left side of the array
        int p1 = start;
        //pointer for the right side of the array
        int p2 = mid+1;

        //pointer for the original array
        int p3 = start;


        //do as long as the p1 and p2 are within their elements
        while( p1 <=mid && p2 <=end){

            if(temp[p1] > temp[p2]){
                nums[p3] = temp [p2];
                p2++;
                p3++;
            }else{
                nums[p3] = temp[p1];
                p1++;
                p3++;
            }
        }


        //copy the remaining elements from the left side of the array to the original
//        for(int i = p1; i<=mid; i++, p3++){
//            nums[p3] = temp[i];
//        }
        while(p1 <= mid){
            nums[p3] = temp[p1];
            p1++;
            p3++;
        }

    }


    public static void main (String[] args){

        int[] nums = {9,8,7,6,5,4,3,2,1};

        sort(nums);

        System.out.println(Arrays.toString(nums));

    }
}
