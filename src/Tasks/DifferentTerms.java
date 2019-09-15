package Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferentTerms {
    public static void main(String[] args) {
        new DifferentTerms().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int n  = scanner.nextInt();
        int count = 0;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        int foo = 0;

        for (int i = 1; i <= n/2+1; i++) {
            if (i > (n - sum)) {
                sum -= i - 1;
                foo = n - sum;
                list.remove(list.size() - 1);
                list.add(foo);
                break;
            } else {
                list.add(i);
                sum += i;
                count++;
            }
        }



        System.out.println(count);
        for (int a : list) {
            System.out.print(a + " ");
        }
    }
}
