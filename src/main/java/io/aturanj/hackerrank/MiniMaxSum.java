package io.aturanj.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-mini-max-sum/
 */
class MiniMaxSumResult {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public void miniMaxSum(List<Integer> arr) {

        Collections.sort(arr);

        var min = arr.subList(0, 4)
                .stream()
                .map(BigInteger::valueOf)
                .reduce(BigInteger.ZERO, BigInteger::add)
                .longValue();

        Collections.sort(arr, Collections.reverseOrder());

        var max = arr.subList(0, 4)
                .stream()
                .map(BigInteger::valueOf)
                .reduce(BigInteger.ZERO, BigInteger::add)
                .longValue();

        System.out.println(min + " " + max);
    }
}

public class MiniMaxSum {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        var result = new MiniMaxSumResult();
        result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
