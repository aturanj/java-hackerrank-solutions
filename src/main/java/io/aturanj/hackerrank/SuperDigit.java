package io.aturanj.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  https://www.hackerrank.com/challenges/one-week-preparation-kit-recursive-digit-sum
 */
class SuperDigitResult {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */
    public static int superDigit(String n, int k) {

        long number = sumOfDigits(n) * k;

        return (int) check(number);
    }

    private static long sumOfDigits(String text) {
        long total = 0;
        for (int i = 0; i < text.length(); i++) {
            total += Character.getNumericValue(text.charAt(i));
        }
        return total;
    }

    private static long check(long number) {
        if (number > 9) {
            return check(sumOfDigits(String.valueOf(number)));
        } else {
            return number;
        }
    }
}

public class SuperDigit {

    public static void main(String[] args) throws IOException {
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = SuperDigitResult.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
