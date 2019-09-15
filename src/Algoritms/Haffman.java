package Algoritms;

import java.util.*;

public class  Haffman {
    public static void main(String[] args) {
        new Haffman().go();
    }

    class Node implements Comparable<Node>{
        final int sum;
        String code;

        void buildCode(String code) {
            this.code = code;
        }

        public Node(int sum) {
            this.sum = sum;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(sum, o.sum);
        }
    }

    class InternalNode extends Node {
        Node left;
        Node right;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            left.buildCode(code + "0");
            right.buildCode(code + "1");
        }

        public InternalNode(Node left, Node right) {
            super(left.sum + right.sum);
            this.left = left;
            this.right = right;
        }
    }

    class LeafNode extends Node {
        char symbol;

        @Override
        void buildCode(String code) {
            super.buildCode(code);
            System.out.println(symbol + ": " + code);
        }

        public LeafNode(char symbol, int count) {
            super(count);
            this.symbol = symbol;
        }
    }

    private void go() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
//        String str = "asdjgjhkjdfhajfdjfkhalsdiuf";
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
        Map<Character, Node> charNodes = new HashMap<>();
        PriorityQueue<Node> tree = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            LeafNode node = new LeafNode(entry.getKey(), entry.getValue());
            charNodes.put(entry.getKey(), node);
            tree.add(node);
        }
        int sum = 0;
        while (tree.size() > 1) {
            Node first = tree.poll();
            Node second = tree.poll();
            InternalNode node = new InternalNode(first, second);
            sum += node.sum;
            tree.add(node);
        }
        if (count.size() == 1) {
            sum = str.length();
        }
        System.out.println(count.size() + " " + sum);
        Node root = tree.poll();
        if (count.size() == 1) {
            root.buildCode("0");
        } else {
            root.buildCode("");
        }

        StringBuilder encodedString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            encodedString.append(charNodes.get(c).code);
        }
        System.out.println(encodedString.toString());
    }
}
