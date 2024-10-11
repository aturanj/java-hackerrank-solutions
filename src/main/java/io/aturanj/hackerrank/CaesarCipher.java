package io.aturanj.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-caesar-cipher-1/
 */
class CaesarCipherResult {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */
    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        for (char i : s.toCharArray()) {
            if (Character.isLetter(i)) {
                char base = Character.isUpperCase(i) ? 'A' : 'a';
                sb.append((char) ((i - base + k) % 26 + base));
            } else {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}

public class CaesarCipher {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = CaesarCipherResult.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
