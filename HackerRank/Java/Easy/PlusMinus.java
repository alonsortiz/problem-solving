//Alonso Ortiz - 2018

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PlusMinus {

    static void plusMinus(int[] arr) {
        // Complete this function
        float pos = 0;
        float neg = 0;
        float neu = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0) {
                neu += 1;
            } else if(arr[i] > 0) {
                pos += 1;
            } else {
                neg += 1;
            }
        }
        
        System.out.println(pos/n);
        System.out.println(neg/n);
        System.out.println(neu/n);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }
}

