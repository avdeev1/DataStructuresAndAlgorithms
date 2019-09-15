package Tasks;

public class Knapsack {
    public static void main(String[] args) {
        new Knapsack().run();
    }

    private void run() {
        int[] weight = {6, 3, 4, 2};
        int[] cost = {30, 14, 16, 9};

        int W = 20;

        int optimaCostWithRepsBU = knapsackWithRepsBU(W + 1, weight, cost);
        System.out.println("With repetitions: " + optimaCostWithRepsBU);
        int optimaCostWithoutRepsBU = knapsackWithoutRepsBU(W + 1, weight, cost);
        System.out.println("Without repetitions: " + optimaCostWithoutRepsBU);
    }

    private int knapsackWithRepsBU(int W, int[] weight, int[] cost) {
        int[] D = new int[W];

        for (int k = 0; k < W; k++) {
            for (int i = 0; i < weight.length; i++) {
                if (weight[i] <= k)
                    D[k] = Math.max(D[k], D[k - weight[i]] + cost[i]);
            }
        }
        return D[W - 1];
    }

    private int knapsackWithoutRepsBU(int W, int[] weight, int[] cost) {
        int[][] D = new int[W][weight.length + 1];

        for (int k = 0; k < W; k++)
            D[k][0] = 0;

        for (int i = 0; i < weight.length + 1; i++)
            D[0][i] = 0;

        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = 1; j < W; j++) {
                D[j][i] = D[j][i - 1];
                if (weight[i - 1] <= j)
                    D[j][i] = Math.max(D[j][i], D[j-weight[i-1]][i-1] + cost[i - 1]);
            }
        }
        return D[W-1][weight.length];
    }
}
