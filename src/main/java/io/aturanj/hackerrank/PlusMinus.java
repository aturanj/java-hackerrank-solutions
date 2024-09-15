package io.aturanj.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/*
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-plus-minus
 */
class ResultPlusMinus {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public void plusMinus(List<Integer> arr) {

        var map = new HashMap<String, Integer>();

        for (var key : arr) {
            if (key > 0) {
                map.put("pos", map.getOrDefault("pos", 0) + 1);
            } else if (key < 0) {
                map.put("neg", map.getOrDefault("neg", 0) + 1);
            } else {
                map.put("zero", map.getOrDefault("zero", 0) + 1);
            }
        }

        System.out.println(Double.parseDouble(map.getOrDefault("pos", 0).toString()) / arr.size());
        System.out.println(Double.parseDouble(map.getOrDefault("neg", 0).toString()) / arr.size());
        System.out.println(Double.parseDouble(map.getOrDefault("zero", 0).toString()) / arr.size());
    }
}

public class PlusMinus {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        var result = new ResultPlusMinus();
        result.plusMinus(arr);

        bufferedReader.close();
    }
}
