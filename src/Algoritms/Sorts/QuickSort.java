package Algoritms.Sorts;

import java.util.Random;

public class QuickSort {

    private final static int N = 50000000;

    public static void main(String[] args) {
        //long start = System.currentTimeMillis();
        new QuickSort().run();
        //long finish = System.currentTimeMillis();
        //System.out.println("Time: " + (finish - start) + " ms");
    }

    private void run() {
        Random random = new Random();
        int[] array1 = new int[N];
        int[] array2 = new int[N];


        for (int i = 0; i < N; i++) {
            array1[i] = random.nextInt(1000000) + 1;
            array2[i] = array1[i];
            //System.out.print(array[i] + " ");
        }
        //System.out.println();
        long start1 = System.currentTimeMillis();
        quickSort(array1);
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        new MergeSort().mergeSort(array2);
        long end2 = System.currentTimeMillis();

        System.out.println("Quick - " + (end1 - start1) + " ms\nMerge - " + (end2 - start2) + " ms");

//        for (int i = 0; i < N; i++) {
//            System.out.print(array[i] + " ");
//        }
//        System.out.println();
    }

    private void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) return;

        int pivot = array[(left + right) / 2];
        int index = partition(array, left, right, pivot);
        quickSort(array, left, index - 1);
        quickSort(array, index, right);
    }

    private int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
