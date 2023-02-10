//Alonso Ortiz - 2018

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Kangaroo {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        // Complete this function
        //can they land in the same place at the same time in any jump
        int distanceK1 = x1;
        int distanceK2 = x2;
        
        while(distanceK1 >= 0 && distanceK2 >= 0) {
            distanceK1 += v1;
            distanceK2 += v2;
            if(distanceK1 == distanceK2) {
                return "YES";
            } else if(distanceK1 > distanceK2) {
                if(v1 > v2)
                    return "NO";
            } else {
                if(v1 < v2)
                    return "NO";
            }

        }
        
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}

