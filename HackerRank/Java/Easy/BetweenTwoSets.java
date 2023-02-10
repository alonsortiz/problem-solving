//Alonso Ortiz - v1: 13/Aug/2019
//To improve complexity - 26/Aug/2019

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class BetweenTwoSets {

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {
        /*
         * Write your code here.
         */
        List<Integer> aFactors = new ArrayList<Integer>();
        List<Integer> bFactors = new ArrayList<Integer>();

        int start = a[a.length-1];

        boolean isFactorA, isFactorB;
        isFactorA = isFactorB = true;

        for (int i = start; i <= b[0]; i++) {
            for(int j = 0; j < a.length; j++) {
                if(i%a[j] != 0) {
                    isFactorA = false;
                }
            }

            if(isFactorA) {
                aFactors.add(i);
            } else {
                isFactorA = true;
            }

            for(int k = 0; k < b.length; k++) {
                if(b[k]%i != 0) {
                    isFactorB = false;
                }
            }

            if(isFactorB) {
                bFactors.add(i);
            } else {
                isFactorB = true;
            }
        }

        aFactors.retainAll(bFactors); 

        int inbetweeners = aFactors.size();

        return inbetweeners;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }
}

