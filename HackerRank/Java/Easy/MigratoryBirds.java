//Alonso Ortiz - 13/Aug/2019

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

public class MigratoryBirds {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        int type1, type2, type3, type4, type5;
        type1 = type2 = type3 = type4 = type5 = 0;

        for(Integer value : arr) {
            switch (value) {
                case 1:
                    type1 += 1;
                    break;
                case 2:
                    type2 += 1;
                    break;
                case 3:
                    type3 += 1;
                    break;
                case 4:
                    type4 += 1;
                    break;
                case 5:
                    type5 += 1;
                    break;
            }
        }

        List<Integer> birds = new ArrayList<Integer>();
        birds.add(type1);
        birds.add(type2);
        birds.add(type3);
        birds.add(type4);
        birds.add(type5);

        int biggest = 0;
        int mostCommon = 0;

        for(int i = 0; i < birds.size(); i++) {
            if(birds.get(i) > biggest) {
                biggest = birds.get(i);
                mostCommon = i;
            }
        }

        return mostCommon+1;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

