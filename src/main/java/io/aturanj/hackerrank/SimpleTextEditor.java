package io.aturanj.hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-simple-text-editor
 */
public class SimpleTextEditor {

    public static void main(String[] args) {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        var sb = new StringBuilder();
        var lastStatus = new Stack<String>();

        try (var scanner = new Scanner(System.in)) {

            while (scanner.hasNextLine()) {

                var line = scanner.nextLine();
                var arr = line.split("[ ]", 0);

                if (arr[0].equalsIgnoreCase("1")) {
                    lastStatus.push(sb.toString());
                    sb.append(arr[1]); //append
                } else if (arr[0].equalsIgnoreCase("2")) {
                    lastStatus.push(sb.toString());
                    sb.setLength(sb.length() - Integer.parseInt(arr[1])); //delete
                } else if (arr[0].equalsIgnoreCase("3")) {
                    var index = Integer.parseInt(arr[1]) - 1;
                    if (index >= 0) {
                        System.out.println(sb.charAt(index)); //print
                    }
                } else if (arr[0].equalsIgnoreCase("4")) {
                    if (!lastStatus.isEmpty()) {
                        sb = new StringBuilder(lastStatus.pop());
                    }
                }
            }
        }
    }
}
