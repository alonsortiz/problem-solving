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

public class DayOfTheProgrammer {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        int jan, feb, mar, apr, may, jun, jul, aug;

        jan = mar = may = jul = aug = 31;
        apr = jun = 30;
        feb = 28;

        if(year >= 1700 && year <= 1917) {
            //Julian
            if(year%4 == 0) {
                feb = 29;
            }
        } else if(year == 1918) {
            //Transition
            feb = 15;
        } else if(year >= 1919 && year <= 2700){
            //Gregorian
            if(year%400 == 0 || (year%4 == 0 && year%100 != 0)) {
                feb = 29;
            }
        } else {
            throw new IllegalArgumentException("Year Out of Range");
        }

        int completeMonths = jan + feb + mar + apr +
                             may + jun + jul + aug;

        int leftDays = 256 - completeMonths;

        String programmerDay = leftDays + ".09." + year;

        return programmerDay;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

