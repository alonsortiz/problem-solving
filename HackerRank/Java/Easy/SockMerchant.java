//Alonso Ortiz - 15/Aug/2019

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Random;

public class SockMerchant {

    //Ordering socks
    static List<Integer> sortSocks(List<Integer> ar) {
        if(ar.size() < 2) {
            return ar;
        } else {
            List<Integer> less = new ArrayList<Integer>();
            List<Integer> more = new ArrayList<Integer>();
            List<Integer> subList = new ArrayList<Integer>();
            Random ran = new Random();
            
            int indexPivot = ran.nextInt(ar.size());
            int pivot = ar.get(indexPivot);
            ar.remove(indexPivot);

            for(Integer sock : ar) {
                if(sock < pivot) {
                    less.add(sock);
                } else {
                    more.add(sock);
                }
            }

            subList.addAll(sortSocks(less));
            subList.add(pivot);
            subList.addAll(sortSocks(more));
            return subList;
        }
    }

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        /*
        List<Integer> socks = new ArrayList<Integer>();

        for(int i : ar) {
            socks.add(i);
        }
        
        List<Integer> orderedSocks = sortSocks(socks);
        */

        Arrays.sort(ar);

        int pairs = 0;

        for(int i = 0; i < ar.length-1; i++) {
            if(ar[i] == ar[i+1]) {
                pairs++;
                i++;
            }
            
        }
        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

