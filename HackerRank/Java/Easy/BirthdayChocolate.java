//Alonso Ortiz - v1: 2018
//To improve complexity - 26/Aug/2019

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BirthdayChocolate {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        int ways = 0;
        int temp = 0;
        int i = 0;
        int j = 0;
        while(i < s.size()) { 
            if(m == 1) {
                if(s.get(i) == d) {
                    ways+=1;
                }
            } else {
                while(j < (i+m) && (i+1) < s.size() && j < s.size()) {
                    temp += s.get(j);
                    j++;
                    if(j == (i+m)) {
                        if(temp == d) {
                            ways+=1;
                        }
                        temp = 0;
                        i++;
                        j=j-(m-1);
                    }
                }
            }
            
            i++;
        }
        return ways;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

