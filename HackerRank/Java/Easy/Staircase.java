//Alonso Ortiz - 2018

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Staircase {

    static void staircase(int n) {
        // Complete this function
        String hash = "#";
        String spaces = "";
        for(int i=0; i < n-1; i++) {
            spaces += " "; 
        }
        
        for(int i=0; i < n; i++) {
            System.out.println(spaces+hash);
            spaces = "";
            for(int j=n-i; j > 2; j--) {
                spaces += " ";
            }
            hash += "#";
        }
        
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        staircase(n);
        in.close();
    }
}

