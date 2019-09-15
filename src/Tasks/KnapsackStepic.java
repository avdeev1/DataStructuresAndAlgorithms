package Tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KnapsackStepic {
    public static void main(String[] args) {
        new KnapsackStepic().run();
    }

    class Item {
        int weight;
        int cost;

        public Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }
    }

    private void run() {
        int n, W;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        W = scanner.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(scanner.nextInt(), scanner.nextInt());
        }

        knapsack(W, items, 0);
    }

    private void knapsack(int W, Item[] items, double result) {
        Arrays.sort(items, ((Item o1, Item o2) -> {
                double r1 = (double)o1.cost/o1.weight;
                double r2 = (double)o2.cost/o2.weight;
                return -Double.compare(r1, r2);
            }));

        for (Item item : items) {
            if (item.weight <= W) {
                result += item.cost;
                W -= item.weight;
            } else {
                result += (double)item.cost * W / item.weight;
                break;
            }
        }
        System.out.println(result);
    }
}
