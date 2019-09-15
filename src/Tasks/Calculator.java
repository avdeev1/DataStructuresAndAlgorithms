/**
 * У вас есть примитивный калькулятор,
 * который умеет выполнять всего три операции с текущим числом 𝑥:
 * заменить 𝑥 на 2𝑥, 3𝑥 или 𝑥+1.
 * По данному целому числу 1 ≤ 𝑛 ≤ 100000 определите минимальное число операций 𝑘,
 * необходимое, чтобы получить 𝑛 из 1.
 * Выведите 𝑘 и последовательность промежуточных чисел.
 */


package Tasks;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        new Calculator().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] a = new int[N+1];
        a[1]= 0;

        int min;
        for(int i=2; i<N+1; i++){
            min=a[i-1]+1;
            if(i%2==0) min=Math.min(min,a[i/2]+1);
            if(i%3==0) min=Math.min(min,a[i/3]+1);

            a[i] = min;
        }

        StringBuilder ret = new StringBuilder();

        int i=N;
        while(i>1){
            if(a[i]==a[i-1]+1){
                ret.insert(0, 1);
                i--;
                continue;
            }

            if(i%2==0&&a[i]==a[i/2]+1){
                ret.insert(0, 2);
                i/=2;
                continue;
            }

            ret.insert(0, 3);
            i/=3;
        }


        System.out.println(a[N]);

        int res = 1;
        System.out.print(res + " ");
        for (int j = 0; j < ret.length(); j++) {
            switch (ret.toString().charAt(j)) {
                case '1':
                    res++;
                    break;

                case '2':
                    res *= 2;
                    break;

                case '3':
                    res *= 3;
                    break;
            }
            System.out.print(res + " ");
        }
        System.out.println();
    }
}

