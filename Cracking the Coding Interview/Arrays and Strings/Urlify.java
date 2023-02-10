//Alonso Ortiz - 16/Sep/2019

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Urlify {

    /*
     * 1.3 Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient 
     * space at the end to hold the additional characters, and that you are given the "true" length of the string. 
     * (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
     */
    public static String urlify(String word, int originalLen) {
        
        char[] wordArr = word.toCharArray(); 

        int extraSpaces = wordArr.length - originalLen;
        boolean wordStarted = false;

        for(int i = wordArr.length-1; i >= 0; i--) {
            if(wordArr[i] != ' ') {
                wordStarted = true; //Extra spaces end 
                wordArr[i+extraSpaces] = wordArr[i]; 
            } else {
                if(wordStarted) {
                    wordArr[i+extraSpaces] = '0';
                    wordArr[i+(extraSpaces-1)] = '2';
                    wordArr[i+(extraSpaces-2)] = '%';
                    extraSpaces -= 2;
                }        
            }
        }

        return String.valueOf(wordArr);
    }

    public static void main(String[] args) throws IOException {

        String s = "Mr John Smith    ";
        String result = urlify(s, 13);
        System.out.println(s);
        System.out.println("URLified -> " + result);

        s = "Mr  John  Smith        ";
        result = urlify(s, 15);
        System.out.println("\n"+s);
        System.out.println("URLified -> " + result);

        s = "H e l l o  W o r l d                    ";
        result = urlify(s, 20);
        System.out.println("\n"+s);
        System.out.println("URLified -> " + result);

    }
}
