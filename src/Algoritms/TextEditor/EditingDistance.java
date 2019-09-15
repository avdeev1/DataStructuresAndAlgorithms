/**
 * Levenshtein distance
 * https://en.wikipedia.org/wiki/Levenshtein_distance
 */

package Algoritms.TextEditor;


public class EditingDistance {
    public static void main(String[] args) {
        new EditingDistance().run();
    }

    private void run() {
        String a = "editing";
        String b = "distance";

        int res = EditDist(a, b);

        System.out.println(res);
    }

    private int EditDist(String a, String b) {
        int n = a.length() + 1;
        int m = b.length() + 1;

        int[][] distance = new int[n][m];

        for (int i = 0; i < n; i++)
            distance[i][0] = i;

        for (int j = 0; j < m; j++)
            distance[0][j] = j;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int c = diff(a.charAt(i - 1), b.charAt(j - 1));
                distance[i][j] = Min(distance[i-1][j] + 1, distance[i][j-1] + 1, distance[i-1][j-1] + c);
            }
        }
        return distance[n-1][m-1];
    }

    private int Min(int i, int i1, int i2) {
        return Math.min(i, Math.min(i1, i2));
    }

    private int diff(char c, char c1) {
        return (c == c1) ? 0 : 1;
    }
}
