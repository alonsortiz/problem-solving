/*
 * By: Alonso Ortiz - 20/Apr/2020
 * From: https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 * 
 * There are n people whose IDs go from 0 to n - 1 and each person belongs exactly to one group. 
 * Given the array groupSizes of length n telling the group size each person belongs to, 
 * return the groups there are and the people's IDs each group includes.
 *
 * You can return any solution in any order and the same applies for IDs. 
 * Also, it is guaranteed that there exists at least one solution. 
 */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class GroupPeople {

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> groups = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> groupsMap = new HashMap<Integer, List<Integer>>();

        for(int i = 0; i < groupSizes.length; i++) {
            if(groupsMap.containsKey(groupSizes[i])) {
                if(groupsMap.get(groupSizes[i]).size() >= groupSizes[i]) {
                    groups.add(groupsMap.get(groupSizes[i]));
                    groupsMap.remove(groupSizes[i]);
                } 
            }
            
            groupsMap.computeIfAbsent(groupSizes[i], k -> new ArrayList<>()).add(i);
        }
        
        groups.addAll(groupsMap.values());

        return groups;
    }
}
