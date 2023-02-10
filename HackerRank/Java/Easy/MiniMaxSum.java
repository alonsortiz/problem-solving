//Alonso Ortiz - 2018

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MiniMaxSum {

    static void miniMaxSum(int[] arr) {
        // Complete this function
        long total = 0;
        //int max = 0;
        
        long temp = 0;
        
        for(int i = 0; i < arr.length; i++){
            total += arr[i];
        }
        
        long min = total-arr[0];
        long max = min;
        //Total: 15
        
        for(int i=0; i < arr.length; i++) {
            temp = total-arr[i];
            
            if(temp >= max) {
                max = temp;
            }
            
            if(temp < min){
                min = temp;
            }
                
        }
        
        System.out.print(min + " " + max); //10 14
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i = 0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        miniMaxSum(arr);
        in.close();
    }
}

