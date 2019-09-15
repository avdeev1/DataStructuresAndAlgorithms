package DataStructure;

public class BinaryTree {
    public static void main(String[] args) {
        new BinaryTree().run();
    }

    private void run() {
//        BinaryNode left = new BinaryNode(4);
//        BinaryNode right = new BinaryNode(5);
        BinaryNode root = new BinaryNode(6, new BinaryNode(4, new BinaryNode(3), new BinaryNode(5)), new BinaryNode(7));
        traverseDFS(root);
    }

    private class BinaryNode {

        BinaryNode(int data) {
            this.data = data;
        }

        BinaryNode(int data, BinaryNode left, BinaryNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        int data;
        BinaryNode left;
        BinaryNode right;
    }

    private void traverseDFS(BinaryNode node) {
        if (node == null) return;

        traverseDFS(node.left);
        visit(node);
        traverseDFS(node.right);
    }

    private void visit(BinaryNode node) {
        System.out.print(node.data + " ");
    }
}
