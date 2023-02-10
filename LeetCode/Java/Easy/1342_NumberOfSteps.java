/*
 * By: Alonso Ortiz - 09/Apr/2020
 * From: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * 
 * Given a non-negative integer num, return the number of steps to reduce it to zero. 
 * If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class NumberOfSteps {

    public static String numberOfSteps(int num) { 
        int steps = 0;

        while(num != 0) {
            if(num%2 == 0) {
                num = num/2;
            } else {
                num--;
            }

            steps++;
        }

        return steps;
        
    }

}
