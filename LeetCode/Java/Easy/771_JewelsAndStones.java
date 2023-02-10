/*
 * By: Alonso Ortiz - 19/Apr/2020
 * From: https://leetcode.com/problems/jewels-and-stones/
 * 
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, 
 * so "a" is considered a different type of stone from "A".
 */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class JewelsAndStones {

    public static String numJewelsInStones(String J, String S) { 
        char[] jArr = J.toCharArray();
        char[] sArr = S.toCharArray();
        Set<Character> jewels = new HashSet<Character>();
        int myJewels = 0;

        for(int i = 0; i < jArr.length; i++) {
            jewels.add(jArr[i]);
        }

        for(int i = 0; i < sArr.length; i++) {
            if(jewels.contains(sArr[i])) {
                myJewels++;
            } 
        }

        return myJewels;
    }
}
