package io.aturanj.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-lonely-integer
 */
public class LonelyInteger {

    class Result {

        public static int lonelyinteger(List<Integer> a) {

            for (Integer i : a) {
                if (Collections.frequency(a, i) == 1) {
                    return i;
                }
            }

            return 0;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int r = Result.lonelyinteger(a);

        bufferedWriter.write(String.valueOf(r));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
