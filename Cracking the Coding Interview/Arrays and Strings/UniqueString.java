//Alonso Ortiz - 23/Aug/2019

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class UniqueString {

    /*
     * 1.1 Implement an algorithm to determine if a string has all unique characters. 
     */
    public static boolean isUnique(String word, int solution) {
        
        boolean uniqueCharacters = true;   
        String s = word.toLowerCase(); 

        switch(solution) { 
            case 1: 
                //Using Data Structures. Complexity: O(N)
                uniqueCharacters = solution1(s);

                break; 
            
            case 2: 
                //Using sort. Complexity: O(N log N)
                uniqueCharacters = solution2(s);

                break; 
            
            default: 
                throw new IllegalArgumentException("Invalid option");
        }      

        return uniqueCharacters;
    }

    public static boolean solution1(String s) { 

        boolean uniqueCharacters = true;   

        HashSet<Character> h = new HashSet<Character>(); 

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);       
            
            if(h.contains(c)) {
                uniqueCharacters = false;
                break;
            } else {
                h.add(c); 
            }
            
        } 

        return uniqueCharacters;
    }


    public static boolean solution2(String s) { 

        boolean uniqueCharacters = true;   

        char[] stringArr = s.toCharArray(); 
  
        Arrays.sort(stringArr); 

        for(int i = 0; i < stringArr.length - 1; i++) {
            if(stringArr[i] == stringArr[i+1]) {
                uniqueCharacters = false; 
                break;
            }
        } 

        return uniqueCharacters;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.next();
        boolean result = isUnique(s, 2);
        System.out.println(s + " is unique? -> " + result);
        
        scanner.close();

    }
}
