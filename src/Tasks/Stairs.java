/**
 * Даны число 1≤𝑛≤100 ступенек лестницы
 * и целые числа −10000 ≤ 𝑎1,…,𝑎𝑛 ≤ 10000,
 * которыми помечены ступеньки.
 * Найдите максимальную сумму, которую можно получить,
 * идя по лестнице снизу вверх (от нулевой до 𝑛-й ступеньки),
 * каждый раз поднимаясь на одну или две ступеньки.
 */

package Tasks;

import java.util.Scanner;

public class Stairs {
    public static void main(String[] args) {
        new Stairs().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] stairs = new int[n + 1];

        for (int i = 0; i < n; i++) {
            stairs[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) continue;
            if (i == 1) { stairs[i] += Math.max(0, stairs[i-1]); continue; }
            stairs[i] += Math.max(stairs[i-2], stairs[i-1]);
        }

        System.out.println(stairs[n-1]);
    }
}

