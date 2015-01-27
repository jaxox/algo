package crackingTheCodingInterview.chp11;

import org.apache.commons.lang3.ArrayUtils;
import until.ArrayUtil;

import java.util.Arrays;

/**
 * Created by jason on 1/16/15.
 */
public class QuickSort {

    private static int []a = {6,5,1,3,8,4,7,9,2};
    public static void main(String[] args) {
        // Get a random generated array
        //a = ArrayUtil.getArray(10);
        //a = {6,5,1,3,8,4,7,9,2};
        // prints the given array
        printArray();
        System.out.println();
        // sort the array
        sort();
        //prints the sorted array
        printArray();

    }

    // This method sorts an array and internally calls quickSort
    public static void sort(){
        int left = 0;
        int right = a.length-1;

        quickSort(left, right);
    }

    // This method is used to sort the array using quicksort algorithm.
    // It takes the left and the right end of the array as the two cursors.
    private static void quickSort(int left,int right){

        int partition = partition(left, right );

        // Recursively, calls the quicksort with the different left and right parameters of the sub-array

        if(left< partition -1) {
            printArray(left,partition - 1);
            quickSort(left, partition - 1);
        }

        if(partition<right) {
            printArray(partition,right);
            quickSort(partition, right);
        }
    }

    // This method is used to partition the given array and returns the integer which points to the sorted pivot index
    private static int partition(int leftCursor,int rightCursor ){

        // For the simplicity, we took the right most item of the array as a pivot
        int pivot = a[ (leftCursor + rightCursor)/2 ];

        while(leftCursor <= rightCursor){

            while(a[leftCursor] < pivot)leftCursor++;
            while(a[rightCursor] > pivot)rightCursor--;

            if(leftCursor <= rightCursor){
                System.out.println("swap(index[" + leftCursor + "]="+a[leftCursor] +", index[" + rightCursor + "]=" + a[rightCursor] + ") pivot=" + pivot );
                swap(leftCursor, rightCursor);
                leftCursor++;
                rightCursor--;
            }
        }


        return leftCursor;
    }

    // This method is used to swap the values between the two given index
    public static void swap(int left,int right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    public static void printArray(int from, int to){
        if(ArrayUtils.subarray(a, 0, from).length>0)
        System.out.print(Arrays.toString(ArrayUtils.subarray(a, 0, from)));

        System.out.print("{"+Arrays.toString(ArrayUtils.subarray(a, from, to + 1))+"}");

        if(ArrayUtils.subarray(a, to+1 , a.length).length>0)
        System.out.print(Arrays.toString(ArrayUtils.subarray(a, to +1 , a.length)));

        System.out.println();
    }


    public static void printArray( ){
        System.out.println(Arrays.toString(a));
    }



}
