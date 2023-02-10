//Alonso Ortiz - v1: 2018
//Alonso Ortiz - v2: 26/Aug/2019

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
         // Complete this function
        String[] newHour = s.split(":");

        String[] time = newHour[2].split("[0-9]");
        String[] seconds = newHour[2].split("[A-Z]");
        
        if(time[2].equals("PM")) {
            switch(newHour[0]) { 
                case "01":
                    newHour[0] = "13";
                    break;
                
                case "02":
                    newHour[0] = "14";
                    break;
                
                case "03":
                    newHour[0] = "15";
                    break;

                case "04":
                    newHour[0] = "16";
                    break;

                case "05":
                    newHour[0] = "17";
                    break;

                case "06":
                    newHour[0] = "18";
                    break;

                case "07":
                    newHour[0] = "19";
                    break;

                case "08":
                    newHour[0] = "20";
                    break;

                case "09":
                    newHour[0] = "21";
                    break;

                case "10":
                    newHour[0] = "22";
                    break;

                case "11":
                    newHour[0] = "23";
                    break;

                default:
                    newHour[0] = "12";
                    break;
            }
        } 
        
        if(time[2].equals("AM")) {
            if(newHour[0].equals("12")) 
                newHour[0] = "00";
        }
        
        
        newHour[2] = seconds[0];
     
        int i =0;
        String newS = "";
        while(i < newHour.length) {
            newS+=newHour[i];
            if(i+1 < newHour.length)
                newS+=":";
            i++;
        }
        
        return newS;

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
