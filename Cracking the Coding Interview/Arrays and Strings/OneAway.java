//Alonso Ortiz - 25/Sep/2019

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class OneAway {

    /*
     * 1.5 There are three types of edits that can be performed on strings: insert a character, 
     * remove a character, or replace a character. Given two strings, write a function to check 
     * if they are one edit (or zero edits) away.
     */
    public static boolean equalLengthWords(char[] arr1, char[] arr2) { 

        int diff, i, j;
        diff = i = j = 0;

        while(j < arr1.length) {
            if(arr1[i] != arr2[j]) {
                diff++;

                if(diff > 1) return false;
            } 

            i++;
            j++;
        }

        return true;

    }

    public static boolean diffLengthWords(char[] arr1, char[] arr2) { 

        int diff, i, j;
        diff = i = j = 0;

        while(j < arr1.length) {
            if(arr1[i] != arr2[j]) {
                diff++;

                if(diff > 1) return  false;  
            } else {
                i++;
            }

            j++;
        }

        return true;

    }

    public static boolean oneAway(String word1, String word2) {

        char[] wordArr1 = word1.toCharArray();
        char[] wordArr2 = word2.toCharArray();

        if(wordArr1.length - wordArr2.length > 1 || wordArr2.length - wordArr1.length > 1)
            return false;

        if(wordArr1.length < wordArr2.length) {
            return diffLengthWords(wordArr1, wordArr2);
        } else if(wordArr1.length > wordArr2.length) {
            return diffLengthWords(wordArr2, wordArr1);
        } else {
            return equalLengthWords(wordArr1, wordArr2);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String word1 = scanner.next();
        String word2 = scanner.next();

        boolean result = oneAway(word1, word2);
        System.out.println(word1 + ", " + word2 + " -> " + result);
        
        scanner.close();

    }
}
