//Alonso Ortiz - 16/Aug/2019

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class DrawingBook {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
        int i = 1; //First Page
        int startDistance = p - 1;
        int endDistance = n - p;
        int turns = 0;

        if(endDistance <= startDistance) {
            //Start searching from the end
            if(n%2 != 0) {
                n = n-1;
            }

            i = n; 

            while(i > p) {
                turns++;
                i = i-2;
            }
        } else {
            while(i < p) {
                turns++;
                i = i+2;
            }
        }

        return turns;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

