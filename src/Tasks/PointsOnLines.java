/**
 * В первой строке задано два целых числа
 * 1 ≤ 𝑛 ≤ 50000 и 1≤𝑚≤50000 — количество отрезков и точек на прямой, соответственно.
 * Следующие 𝑛 строк содержат по два целых числа 𝑎𝑖 и 𝑏𝑖 (𝑎𝑖 ≤ 𝑏𝑖)
 * — координаты концов отрезков.
 * Последняя строка содержит 𝑚 целых чисел — координаты точек.
 * Все координаты не превышают 108 по модулю.
 * Точка считается принадлежащей отрезку, если она находится внутри него или на границе.
 * Для каждой точки в порядке появления во вводе выведите, скольким отрезкам она принадлежит.
 */


package Tasks;

import java.util.*;

public class PointsOnLines {
    public static void main(String[] args) {
        new PointsOnLines().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] points = new int[M];
        int[] starts = new int[N];
        int[] ends = new int[N];

        for (int i = 0; i < N; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }


        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0; i < M; i++) {
            points[i] = scanner.nextInt();
        }

        int[] counts = new int[M];

        int[] c1 = new int[M];
        int[] c2 = new int[M];

        for (int i = 0; i < M; i++) {
            c1[i] = partition(starts, points[i]);
            c2[i] = partition2(ends, points[i]);
            counts[i] = c1[i] - c2[i];
        }

        for (int i = 0; i < M; i++) {
            System.out.print(counts[i] + " ");
        }
    }

    private int partition(int[] arr, int point) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= point)
                j++;
            else break;
        }
        return j;
    }

    private int partition2(int[] arr, int point) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < point)
                j++;
            else break;
        }
        return j;
    }
}
