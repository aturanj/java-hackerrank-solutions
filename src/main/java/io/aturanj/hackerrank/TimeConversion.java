package io.aturanj.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-time-conversion/
 */
class TimeConversionResult {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public String timeConversion(String s) {

        if (s.contains("AM")) {
            s = s.replaceAll("AM", "");
            if (Integer.parseInt(s.substring(0, 2)) == 12) {
                s = s.replaceAll("12", "00");
            }
            return s;
        } else {
            s = s.replaceAll("PM", "");
            if (Integer.parseInt(s.substring(0, 2)) == 12) {
                return s;
            } else {
                var b = Integer.parseInt(s.substring(0, 2)) + 12;
                return b + s.substring(2);
            }
        }
    }
}

public class TimeConversion {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        var result = new TimeConversionResult();
        var r = result.timeConversion(s);

        bufferedWriter.write(r);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
