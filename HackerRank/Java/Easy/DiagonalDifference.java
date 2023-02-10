//Alonso Ortiz - 2018

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DiagonalDifference {

    static int diagonalDifference(int[][] a) {
        // Complete this function
        int diag1 = 0;
        int diag2 = 0;
        int n = a.length;
        int i = 0;
        int j = 0;
        int res;
        
        while(i < n) {
            diag1 += a[i][j];
            i++;
            j++;
        }
        
        i=n-1;
        j=0;
        
        while(i >= 0) {
            diag2 += a[i][j];
            i--;
            j++;
        }
        
        res = Math.abs(diag1-diag2);
        
        return res;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for(int a_i = 0; a_i < n; a_i++){
            for(int a_j = 0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();
    }
}

