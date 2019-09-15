package Tasks;

import java.util.Scanner;

public class FastHeightTree {
    public static void main(String[] args) {
        new FastHeightTree().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] parents = new int[n];
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            parents[i] = scanner.nextInt();
            if (parents[i] != -1) {
                heights[parents[i]] = Math.max(heights[parents[i]], 1 + heights[i]);
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (parents[i] != -1) {
                    heights[parents[i]] = Math.max(heights[parents[i]], 1 + heights[i]);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
//            System.out.print(heights[i] + " ");
            if (heights[i] >= max)
                max = heights[i];
        }

//        System.out.println();
        System.out.println(max);
    }
}

//5
//-1 0 1 2 3

//10
//9 7 5 5 2 9 9 9 2 -1
