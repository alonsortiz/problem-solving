//Alonso Ortiz - 25/Aug/2019

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class PermutationStrings {

    /*
     * 1.2. Given two strings, write a method to decide if one is a permutation of the other.
     *
     * A Permutation of a string is another string that contains same characters, only the 
     * order of characters can be different. 
     * For example, “abcd” and “dabc” are Permutation of each other.
     */
    public static boolean checkPermutations(String word1, String word2, int solution) { 

        if (word1.length() != word2.length()) 
            return false;         

        String a = word1.toLowerCase(); 
        String b = word2.toLowerCase();  
        boolean isPermutation = true;

        switch(solution) { 
            case 1: 
                //First Solution. Complexity: 0(N^2)
                isPermutation = solution1(a, b); 

                break; 
            
            case 2: 
                //Using Data Structures. Complexity: O(N + N) = 0(N)
                isPermutation = solution2(a, b); 

                break; 

            case 3:
                //Using sort. Complexity: O(N log N)
                isPermutation = solution3(a, b);

                break;
            
            default: 
                throw new IllegalArgumentException("Invalid option");
        }    
 

        return isPermutation;
    }

    public static boolean solution1(String a, String b) { 

        boolean isInB = false;
        boolean isPermutation = true;

        for (int i = 0; i < a.length(); i++) {
            char c1 = a.charAt(i); 
            for(int j = 0; j < b.length(); j++) {
                char c2 = b.charAt(j);
                if(c1 == c2) {
                    isInB = true;
                    break;
                }
            }   

            if(!isInB) {
                isPermutation = false;
                break;
            } else {
                isInB = false;
            }
        } 

        return isPermutation;
    }

    public static boolean solution2(String a, String b) { 

        boolean isPermutation = true;

        HashSet<Character> h1 = new HashSet<Character>(); 
        HashSet<Character> h2 = new HashSet<Character>(); 

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i); 
            h1.add(c); 
        }

        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i); 
            h2.add(c); 
        }

        if(!h1.equals(h2)) isPermutation = false;

        return isPermutation;
    }


    public static boolean solution3(String a, String b) { 

        boolean isPermutation = true;

        char[] arrA = a.toCharArray(); 
        char[] arrB = b.toCharArray(); 

        Arrays.sort(arrA); 
        Arrays.sort(arrB); 

        for(int i = 0; i < arrA.length; i++) {
            if(arrA[i] != arrB[i]) {
                isPermutation = false; 
                break;
            }
        }

        return isPermutation;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String a = scanner.next();
        String b = scanner.next();

        boolean result = checkPermutations(a, b, 3);
        System.out.println(a + " is Permutation of " + b + "? -> " + result);
        

        scanner.close();

    }
}
