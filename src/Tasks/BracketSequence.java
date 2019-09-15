/**
 * Проверка скобочной последовательности на правильность
 *
 * Input: строка s[1..n], 1 <= n <= 100000
 * Output: Если скобки в s расставлены правильно, выведите строку “Success".
 * В противном случае выведите индекс (исполь- зуя индексацию с единицы) первой закрывающей скобки,
 * для которой нет соответствующей открывающей.
 * Если такой нет, выведите индекс первой открывающей скобки, для которой нет соответствующей закрывающей.
 */


package Tasks;

import java.util.Scanner;
import java.util.Stack;

public class BracketSequence {
    public static void main(String[] args) {
        new BracketSequence().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        scanner.close();

        Stack<Character> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        boolean isTrue = true;
        int idx = 0;

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    index.push(i + 1);
                    break;


                case ')':
                    if (stack.isEmpty()) {
                        idx = i + 1;
                        isTrue = false;
                    } else {
                        char g = stack.pop();
                        if (g != '(') {
                            idx = i + 1;
                            isTrue = false;
                        } else index.pop();
                    }

                    break;

                case ']':
                    if (stack.isEmpty()) {
                        idx = i + 1;
                        isTrue = false;
                    } else {
                        char d = stack.pop();
                        if (d != '[') {
                            idx = i + 1;
                            isTrue = false;
                        } else index.pop();
                    }

                    break;

                case '}':
                    if (stack.isEmpty()) {
                        idx = i + 1;
                        isTrue = false;
                    } else {
                        char e = stack.pop();
                        if (e != '{') {
                            idx = i + 1;
                            isTrue = false;
                        } else index.pop();
                    }

                    break;
            }
            if (!isTrue) {
                break;
            }
        }

        if (!stack.isEmpty() && !index.isEmpty() && isTrue)
            idx = index.pop();

        if (isTrue && stack.isEmpty())
            System.out.println("Success");
        else
            System.out.println(idx);

    }
}
