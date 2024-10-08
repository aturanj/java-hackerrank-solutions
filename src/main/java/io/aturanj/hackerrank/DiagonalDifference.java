package io.aturanj.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-diagonal-difference/
 */
public class DiagonalDifference {

    class Result {

        /*
        * Complete the 'diagonalDifference' function below.
        *
        * The function is expected to return an INTEGER.
        * The function accepts 2D_INTEGER_ARRAY arr as parameter.
         */
        public static int diagonalDifference(List<List<Integer>> arr) {

            int sumLtr = 0;
            int sumRtl = 0;
            int size = arr.size();

            for (int i = 0, j = 0; i < size && j < size; i++, j++) {
                sumLtr += arr.get(i).get(j);
            }

            for (int i = 0, j = size - 1; i < size && j >= 0; i++, j--) {
                sumRtl += arr.get(i).get(j);
            }

            return Math.abs(sumLtr - sumRtl);
        }

        public static int diagonalDifferenceAlternative(List<List<Integer>> arr) {
            
            int sumLtr = 0, sumRtl = 0;
            
            for (int i = 0; i < arr.size(); i++) {
                sumLtr += arr.get(i).get(i);
                sumRtl += arr.get(i).get(arr.size() - 1 - i);
            }
            
            return Math.abs(sumLtr - sumRtl);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
