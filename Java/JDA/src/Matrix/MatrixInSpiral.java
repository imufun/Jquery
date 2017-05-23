/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrix;

/**
 *
 * @author imran
 */
public class MatrixInSpiral {

    static int[][] a = new int[4][4];

    void PrintSpiral(int m, int n, int a[][]) {

        int i, k = 0, l = 0;

        /*  k - starting row index
         m - ending row index
         l - starting column index
         n - ending column index
         i - iterator
         */
        while (k < m && l < n) {
            for (i = 0; i < n; i++) {
                System.out.println(" First row" + a[k][l]);
            }
            k++;
            for (i = k; i < m; i++) {
                System.out.println("Last column" + a[i][n - 1]);
            }
            n--;
            /* Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.println(" " + a[m - 1][i]);
                }
                m--;
            }

            /* Print the first column from the remaining columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.println("  " + a[i][l]);
                }
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int a[][] = {{1, 2, 3, 4, 5, 6},
        {7, 8, 9, 10, 11, 12},
        {13, 14, 15, 16, 17, 18}
        };
        //int[][] multi = new int[5][10];
        MatrixInSpiral matrixInSpiral = new MatrixInSpiral();

        matrixInSpiral.PrintSpiral(20, 20, a);

    }
}
