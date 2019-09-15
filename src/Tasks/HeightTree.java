/**
 * Программа находит высоту дерева.
 *
 * Input: Корневое дерево с вершинами {0, . . . , n−1},
 * заданное как последовательность parent0, . . . , parentn−1,
 * где parenti — родитель i-й вершины.
 *
 * Output: Tree's height
 *
 */

package Tasks;

import java.util.Scanner;

public class HeightTree {
    public static void main(String[] args) {
        new HeightTree().run();
    }

    int[] nodes;

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        nodes = new int[N];

        for (int i = 0; i < N; i++) {
            nodes[i] = scanner.nextInt();
        }

        Node[] tree = new Node[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new Node(i);
        }

        for (int i = 0; i < N; i++) {
            tree[i].parent = nodes[i];
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            int curr = height(tree[i]);
            if (curr >= max) max = curr;
        }

        System.out.println(max);

    }

    int height(Node node) {
        int count = 1;

        int idx = node.parent;
        while(idx != -1) {
            count++;
            idx = nodes[idx];
        }
        return count;
    }

    class Node {
        int data;
        int left;
        int right;
        int parent;

        Node() {}

        Node(int data) {
            this.data = data;

        }
    }
}

