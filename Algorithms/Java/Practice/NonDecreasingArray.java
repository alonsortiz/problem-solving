//Alonso Ortiz - 06/Aug/2020

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class NonDecreasingArray {

    /*
     * From: https://www.geeksforgeeks.org/sort-an-almost-sorted-array-where-only-two-elements-are-swapped/
     *
     * Sort an almost sorted array where only two elements are swapped, how to sort the array efficiently?
     *
     * Input:  arr[] = {10, 20, 60, 40, 50, 30}  
     * // 30 and 60 are swapped
     * Output: arr[] = {10, 20, 30, 40, 50, 60}
     *
     * Input:  arr[] = {10, 20, 40, 30, 50, 60}  
     * // 30 and 40 are swapped
     * Output: arr[] = {10, 20, 30, 40, 50, 60}
     *
     * Input:   arr[] = {1, 5, 3}
     * // 3 and 5 are swapped
     * Output:  arr[] = {1, 3, 5}
     *
     */
    public static boolean checkPossibility(int[] nums) {

        int errors = 0;
        int min = nums[0];

        for(int i = 1; i <= nums.length-1; i++) {
            if(nums[i] >= min) {
                min = nums[i];
            } else {
                errors++;

                if(i == 1) {
                    min = 0;
                    i--; 
                }

                if(errors > 1) return false;
            } 

            System.out.println("Min: " + min + ", Num: " + nums[i] + ", Errors: " + errors);  
        }

        return true;
        
    }

    public static void main(String[] args) throws IOException {

        //1,5,4,6,7,10,8,9
        int[] arr = {4,2,3};
        
        System.out.println("Expected: true,  Value: " + checkPossibility(arr));

        int[] arr1 = {1,4,2,3};
        
        System.out.println("Expected: true,  Value: " + checkPossibility(arr1));

        int[] arr2 = {3,4,2,3};
        
        System.out.println("Expected: false, Value: " + checkPossibility(arr2));

        int[] arr3 = {1,1,1,1};
         
        System.out.println("Expected: true,  Value: " + checkPossibility(arr3));

        int[] arr4 = {2,3,3,2,3};
        
        System.out.println("Expected: true,  Value: " + checkPossibility(arr4));

        int[] arr5 = {1,5,4,6,7,10,8,9};
        
        System.out.println("Expected: false, Value: " + checkPossibility(arr5));

    }
}
