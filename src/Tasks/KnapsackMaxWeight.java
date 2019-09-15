/**
 * Первая строка входа содержит целые числа
 * 1 ≤ 𝑊 ≤ 10000 и 1 ≤ 𝑛 ≤ 300 — вместимость рюкзака и число золотых слитков.
 * Следующая строка содержит 𝑛 целых чисел 0 ≤ 𝑤1,…,𝑤𝑛 ≤ 100000,
 * задающих веса слитков.
 * Найдите максимальный вес золота, который можно унести в рюкзаке.
 */

package Tasks;

import java.util.Scanner;

public class KnapsackMaxWeight {
    public static void main(String[] args) {
        new KnapsackMaxWeight().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt(); // вместимость рюкзака
        int n = sc.nextInt(); // число золотых слитков
        int[] weight = new int[n];
        int [][] D = new int[W+1][n+1];
        for(int i = 0 ; i < n ;i++){
            weight[i] = sc.nextInt();
        }
        for (int i = 0 ; i <= W ; i++){
            D[i][0] = 0;
        }
        for (int i = 0 ; i <= n ; i++){
            D[0][i] = 0;
        }


        for (int i = 1 ; i <= n ; ++i){
            for (int j = 0 ; j <= W ; ++j){
                D[j][i] = D[j][i-1];
                if(weight[i-1] <= j ){
                    D[j][i] = Math.max(D[j][i],D[j-weight[i-1]][i - 1]+weight[i-1]);
                }
            }
        }
        System.out.println(D[W][n]);
    }
}

