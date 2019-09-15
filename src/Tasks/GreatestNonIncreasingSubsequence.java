package Tasks;

import java.util.*;

/**
 * https://stepic.org/lesson/Наибольшая-возрастающая-подпоследовательность-13257/step/6?unit=3442
 *
 * https://sites.google.com/site/indy256/algo/lis_nlogn
 * http://e-maxx.ru/algo/longest_increasing_subseq_log
 * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 * http://www.capacode.com/array/longest-increasing-subsequence-in-on-log-n-time/
 */
public class GreatestNonIncreasingSubsequence {

    public static void main(String[] args) {
        new GreatestNonIncreasingSubsequence().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

        int[] lis = lis(a);

        System.out.println(lis.length);
        for (int i = 0; i < lis.length; i++)
            System.out.print(lis[i] + " ");
    }

    public static int[] lis(int[] a) {
        int n = a.length;
        int[] tail = new int[n];
        int[] prev = new int[n];

        int len = 0;
        for (int i = 0; i < n; i++) {
            int pos = lower_bound(a, tail, len, a[i]);
            if (pos == len) {
                ++len;
            }
            prev[i] = pos > 0 ? tail[pos - 1] : -1;
            tail[pos] = i;
        }

        int[] res = new int[len];
        for (int i = tail[len - 1]; i >= 0; i = prev[i]) {
            res[--len] = i + 1;
        }
        return res;
    }

    static int lower_bound(int[] a, int[] tail, int len, int key) {
        int lo = -1;
        int hi = len;
        while (hi - lo > 1) {
            int mid = (lo + hi) >>> 1;
            if (a[tail[mid]] >= key) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }
}
