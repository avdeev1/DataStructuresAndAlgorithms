package Algoritms;

import java.util.*;

public class BFSTree {

    public static void main(String[] args) {
        new BFSTree().run();
    }

    private void run() {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int f, s;

        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node();
        }

        for (int i = 0; i < M; i++) {
            f = scanner.nextInt();
            s = scanner.nextInt();
            nodes[f].list.add(s);
            nodes[s].list.add(f);
        }

        Queue<Node> queue = new LinkedList<>();

        nodes[0].data = 0;
        nodes[0].visit = true;
        queue.add(nodes[0]);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (int i = 0; i < curr.list.size(); i++) {
                if (!nodes[curr.list.get(i)].visit) {
                    queue.add(nodes[curr.list.get(i)]);
                    nodes[curr.list.get(i)].visit = true;
                    nodes[curr.list.get(i)].data = curr.data + 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(nodes[i].data + " ");
        }

    }

    class Node {
        int data;
        List<Integer> list;
        boolean visit;

        Node() {
            list = new ArrayList<>();
            visit = false;
        }
    }
}
