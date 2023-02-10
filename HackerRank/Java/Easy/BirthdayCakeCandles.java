//Alonso Ortiz - 2018

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BirthdayCakeCandles {

    static int birthdayCakeCandles(int n, int[] ar) {
        // Complete this function
        //long candles = 0;
        long tallest = 0;
        long temp = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            temp = ar[i];
            
            if (temp > tallest) {
                tallest = temp;
                count = 0;
            }
            
            if(temp == tallest) {
                count += 1;
            } 
        }
        
        return count;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}

