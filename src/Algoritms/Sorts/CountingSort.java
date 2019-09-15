package Algoritms.Sorts;

import java.util.Scanner;

public class CountingSort {

    public static void main(String[] args) {
        new CountingSort().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        arr = countingSort(arr);

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    private int[] countingSort(int[] arr) {
        int n = arr.length;
        int[] counts = new int[11];

        for (int anArr : arr) {
            counts[anArr]++;
        }

        for (int i = 1; i < 11; i++) {
            counts[i] += counts[i-1];
        }

        int[] res = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            res[counts[arr[i]]] = arr[i];
            counts[arr[i]]--;
        }
        return res;
    }
}