package io.aturanj.hackerrank;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

/**
 *  https://www.hackerrank.com/challenges/one-week-preparation-kit-queue-using-two-stacks/
 */
public class QueueUsingTwoStacks {

    private Stack<String> stackOne = new Stack<>();
    private Stack<String> stackTwo = new Stack<>();

    public void enqueue(String value) {
        stackOne.push(value);
    }

    public void dequeue() {
        refillStackTwo();
        if (!stackTwo.isEmpty()) {
            stackTwo.pop();
        }
    }

    public String getTop() {
        refillStackTwo();
        if (!stackTwo.isEmpty()) {
            return stackTwo.peek();
        }
        return null;
    }

    private void refillStackTwo() {
        //only runs if stackTwo is empty
        if (stackTwo.isEmpty()) {
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
        }
    }

    public static void main(String[] args) {

        try (var scanner = new Scanner(System.in)) {
            
            var queue = new QueueUsingTwoStacks();
            
            while (scanner.hasNextLine()) {
                
                var line = scanner.nextLine();
                var arr = line.split("[ ]", 0);
                
                if (arr[0].equalsIgnoreCase("1")) {
                    queue.enqueue(arr[1]);
                } else if (arr[0].equalsIgnoreCase("2")) {
                    queue.dequeue();
                } else if (arr[0].equalsIgnoreCase("3")) {
                    String top = queue.getTop();
                    if (top != null) {
                        System.out.println(top);
                    } else {
                        System.out.println("Queue is empty");
                    }
                }
            }
        }
    }

    public void alternativeImplementationWithDeque(String[] args) {

        Scanner scanner = new Scanner(System.in);

        var deq = new ArrayDeque<String>();

        while (scanner.hasNextLine()) {

            var line = scanner.nextLine();
            var arr = line.split("[ ]", 0);

            if (arr[0].equalsIgnoreCase("1")) {
                deq.addLast(arr[1]);
            } else if (arr[0].equalsIgnoreCase("2")) {
                deq.removeFirst();
            } else if (arr[0].equalsIgnoreCase("3")) {
                System.out.println(deq.getFirst());
            }
        }
    }
}
