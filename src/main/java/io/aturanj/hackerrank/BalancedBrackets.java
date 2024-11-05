package io.aturanj.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-balanced-brackets/
 */
class BalancedBracketsResult {

    static Map<Character, Character> map = Map.of('{', '}', '[', ']', '(', ')');

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String isBalanced(String s) {

        // Write your code here
        var arr = s.toCharArray();
        var stack = new Stack<Character>();

        for (var item : arr) {
            if (map.containsKey(item)) { //openning brackets
                stack.push(item);
            } else if (map.containsValue(item) && (stack.isEmpty() || map.get(stack.pop()) != item)) { //closing brackets
                return "NO";
            }
        }

        return stack.isEmpty() ? "YES" : "NO"; //nothing left in stack (all brackets closed)
    }

}

public class BalancedBrackets {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = BalancedBracketsResult.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
