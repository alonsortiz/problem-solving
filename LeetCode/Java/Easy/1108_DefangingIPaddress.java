/*
 * By: Alonso Ortiz - 19/Apr/2020
 * From: https://leetcode.com/problems/defanging-an-ip-address/
 * 
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * A defanged IP address replaces every period "." with "[.]".
 */

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class DefangingIPaddress {

    public static String defangIPaddr(String address) { 
        char[] ipArr = address.toCharArray();
        String defanged = "";

        for(int i = 0; i < ipArr.length; i++) { 
            if(ipArr[i] == '.') {
                defanged += "[" + ipArr[i] + "]";
            } else {
                defanged += ipArr[i];
            }
        }

        return defanged;
    }
}
