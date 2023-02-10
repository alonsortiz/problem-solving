/*
 * By: Alonso Ortiz - 26/Mar/2020
 * From: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array. 
 */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class SmallerNumbers {

    public static int[] smallerNumbersThanCurrent(int[] nums) {

	Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>(); 
	int[] smaller = new int[nums.length];
	int[] sortedNums = new int[nums.length]; 

	sortedNums = Arrays.copyOf(nums, nums.length);
	Arrays.sort(sortedNums);

	for(int i = 0; i < sortedNums.length; i++) { 
	    if(!numsMap.containsKey(sortedNums[i])) {
		numsMap.put(sortedNums[i], i);
	    }
	}

	for(int i = 0; i < nums.length; i++) { 
	    smaller[i] = numsMap.get(nums[i]);
	}

	return smaller;

    }
}
