/*
* By: Alonso Ortiz - 24/Mar/2020
* From: https://leetcode.com/problems/two-sum/
*
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
*
* You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

	int[] sum = new int[2];
	int diff = 0;
	Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>(); 

	for(int i = 0; i < nums.length; i++) { 
	    numsMap.put(nums[i], i);
	}

	for(int i = 0; i < nums.length; i++) {
	    if(nums[i] != 0) {
		diff = target-nums[i];
	    }

	    if(numsMap.containsKey(diff) && numsMap.get(diff) != i) {
		sum[0] = i;
		sum[1] = numsMap.get(diff);

		break;
	    }
	}

	return sum;

    }

}
