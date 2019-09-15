package Tasks;

import java.util.Random;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        new LongestIncreasingSubsequence().run();
    }

    private void run() {
//        final int N = 50;
//        Random random = new Random();
//                int[] sequence = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            sequence[i] = random.nextInt(1000);
//            System.out.print(sequence[i] + " ");
//        }
//        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = scanner.nextInt();
        }

        int[] res = lis(sequence);
//        int res = lis2(sequence);
        System.out.println(res.length);
        for (int elem : res) {
            System.out.print((elem+1) + " ");
        }
    }


    /**
     *
     * Находит ннаибольшую возрастающую подпоследовательность
     * a[i] <= a[j] для всех i < j
     *
     * @param sequence
     * @return res
     */

    private int[] lis(int[] sequence) {
        int[] D = new int[sequence.length];
        int[] prev = new int[sequence.length];

        for (int i = 0; i < sequence.length; i++) {
            D[i] = 1;
            prev[i] = -1;
            for (int j = 0; j <= i - 1; j++) {
                if ((sequence[j] < sequence[i]) && (D[j] + 1 > D[i])) {
                    D[i] = D[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < sequence.length; i++)
            ans = Math.max(ans, D[i]);

        int[] L = new int[ans];
        int k = 1;
        for (int i = 1; i < sequence.length; i++)
            if (D[i] > D[k])
                k = i;

            int j = ans - 1;
            while (k > 0) {
                L[j] = k;
                j--;
                k = prev[k];
            }

            int[] res = new int[ans];
        for (int i = 0; i < ans; i++)
            res[i] = sequence[L[i]];

        return res;

    }

    /**
     * Находит наибольшую последовательнократнцю подпоследовательность
     * a[i] <= a[j] && (a[j] % a[i] == 0) для i < j
     *
     * @param sequence
     * @return ans
     */

    private int lis2(int[] sequence) {
        int[] D = new int[sequence.length];
        int[] prev = new int[sequence.length];

        for (int i = 0; i < sequence.length; i++) {
            D[i] = 1;
            prev[i] = -1;
            for (int j = 0; j <= i - 1; j++) {
                if ((sequence[j] < sequence[i]) && (D[j] + 1 > D[i]) && (sequence[i] % sequence[j] == 0)) {
                    D[i] = D[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < sequence.length; i++)
            ans = Math.max(ans, D[i]);
            return ans;
    }
}
