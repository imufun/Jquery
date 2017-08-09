/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author imran
 */
public class arr {

    public static void main(String[] args) {

        int n = 0;

        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        int a[][] = new int[n][n];
        int b[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = s.nextInt();

                System.out.print(" array " + a[i][j] * a[i][j]);
            }
        }
    }
}
