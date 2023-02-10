//Alonso Ortiz - 2018

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AppleAndOrange {

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        // Complete this function
        int myThrow = 0; 
        int larrysResult = 0;
        int robsResult = 0;
        
        for(int i = 0; i < apples.length; i++){
            myThrow = a + apples[i];
            if(myThrow >= s && myThrow <= t)
                larrysResult += 1;
        }
        
        System.out.println(larrysResult);
        
        for(int i = 0; i < oranges.length; i++){
            myThrow = b + oranges[i];
            if(myThrow >= s && myThrow <= t)
                robsResult += 1;
        }
        
        System.out.println(robsResult);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i = 0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i = 0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        countApplesAndOranges(s, t, a, b, apple, orange);
        in.close();
    }
}

