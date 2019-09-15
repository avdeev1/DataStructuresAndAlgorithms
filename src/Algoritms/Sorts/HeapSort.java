package Algoritms.Sorts;

import java.util.PriorityQueue;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        new HeapSort().run();
    }

    private void run() {
        Random random = new Random();
        final int N = 50;
        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = random.nextInt(100) + 1;
            System.out.print(array[i] + " ");
        }
        System.out.println();

        heapSort(array);

        for (int i = 0; i < N; i++)
            System.out.print(array[i] + " ");

        System.out.println();

    }

    private void heapSort(int[] array) {
        PriorityQueue<Integer> cache = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++)
            cache.add(array[i]);

        for (int i = 0; i < array.length; i++)
            array[i] = cache.poll();
    }
}
