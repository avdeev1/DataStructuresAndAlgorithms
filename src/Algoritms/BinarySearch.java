package Algoritms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        new BinarySearch().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        int[] search = new int[k];
        for (int i = 0; i < k; i++) {
            search[i] = scanner.nextInt();
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            list.add(binarySearch(array, search[i]));
        }

        for (int el : list) {
            System.out.print(el + " ");
        }


    }

    int binarySearch(int[] arr, int elem) {
        int l = 0;
        int r = arr.length-1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == elem) return m;
            else if (arr[m] > elem) r = m - 1;
            else l = m + 1;
        }
        return -1;
    }
}
