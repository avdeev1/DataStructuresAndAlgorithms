package Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MaxStack {
    public static void main(String[] args) {
        new MaxStack().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> max = new Stack<>();

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = scanner.next();

            if (str.charAt(1) == 'u') {
                int r = scanner.nextInt();
                stack.push(r);
                if (!max.isEmpty()) {
                    if (stack.peek() > max.peek()) {
                        max.push(stack.peek());
                    } else
                        max.push(max.peek());
                } else {
                    max.push(stack.peek());
                }
            }

            if (str.charAt(1) == 'o') {
                stack.pop();
                max.pop();
            }

            if (str.charAt(1) == 'a') {
                res.add(max.peek());
            }
        }

        for (int re : res) {
            System.out.println(re);
        }
    }
}
