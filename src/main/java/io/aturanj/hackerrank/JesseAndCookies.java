package io.aturanj.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-jesse-and-cookies
 */
class JesseAndCookiesResult {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */
    public static int cookies(int k, List<Integer> A) {
        // Write your code here

        if (A.isEmpty()) {
            return -1;
        }

        var priorityQueue = new PriorityQueue<Integer>(A);
        var counter = 0;

        while (priorityQueue.peek() < k && priorityQueue.size() > 1) {
            
            var first = priorityQueue.poll();
            var second = priorityQueue.poll();
            var cookie = first + second * 2;

            priorityQueue.add(cookie);
            counter++;
        }

        if (priorityQueue.peek() < k) {
            return -1;
        }

        return counter;
    }
}

public class JesseAndCookies {

    public static void main(String[] args) throws IOException {
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = JesseAndCookiesResult.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
