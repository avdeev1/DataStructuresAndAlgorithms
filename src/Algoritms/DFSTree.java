package Algoritms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFSTree {

    public static void main(String[] args) {
        new DFSTree().run();
    }

    private void run() {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int f, s;

        Node[] nodes = new Node[N + 1];
        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new Node();
        }

        int k = 0;
        int l = 0;

        for (int i = 1; i <= M; i++) {
            f = scanner.nextInt();
            s = scanner.nextInt();
            nodes[f].list.add(s);
            nodes[s].list.add(f);
        }

        boolean[] usd = new boolean[N+1];

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (!usd[i]) {
                dfs(i, usd, nodes);
                count++;
            }
        }

        System.out.println(count);
    }

    private void dfs(int curr, boolean[] usd, Node[] nodes) {
        usd[curr] = true;
        for (int i = 0; i < nodes[curr].list.size(); i++) {
            int nxt = nodes[curr].list.get(i);
            if (!usd[nxt])
                dfs(nxt, usd, nodes);
        }
    }

    class Node {
        List<Integer> list;

        Node() {
            list = new ArrayList<>();
        }
    }
}
