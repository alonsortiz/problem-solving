//Alonso Ortiz - 24/Sep/2019

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class PalindromePermutation {

    /*
     * 1.4 Given a string, write a function to check if it is a permutation of a palindrome.
     * A palindrome is a word or phrase that is the same forwards and backwards. A permutation is
     * a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
     */
    public static boolean palindromePermutation(String s) {

        boolean isPalindromePermutation = true;
        String lower = s.toLowerCase(); 
        int pairs = 0;
        char[] letters = lower.toCharArray();

        Arrays.sort(letters); 

        for(int i = 0; i < letters.length-1; i++) {
            if(letters[i] == letters[i+1] && letters[i] != ' ') {
                pairs++;
                i++;
            } 
        }   

        int len = letters.length - 1;
        int odd = len - pairs*2;

        if(odd > 1) 
            isPalindromePermutation = false;
    
        return isPalindromePermutation;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String word1 = scanner.next();
        String word2 = scanner.next();

        String s = word1 + " " + word2;
        boolean result = palindromePermutation(s);
        System.out.println(s + " is a Palindrome Permutation? -> " + result);
        
        scanner.close();

    }
}
