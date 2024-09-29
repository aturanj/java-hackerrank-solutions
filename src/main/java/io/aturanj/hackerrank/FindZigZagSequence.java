package io.aturanj.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-zig-zag-sequence/
 */
public class FindZigZagSequence {

    public static void main(String[] args) throws java.lang.Exception {

        Scanner kb = new Scanner(System.in);
        int testCases = kb.nextInt();

        for (int cs = 1; cs <= testCases; cs++) {
            int n = kb.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = kb.nextInt();
            }

            findZigZagSequence(a, n);
        }
    }

    public static void findZigZagSequence(int[] a, int n) {
        Arrays.sort(a);
        int mid = (n - 1) / 2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2;
        while (st <= ed) {
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(a[i]);
        }
    }
}
