/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uva;

import java.util.Scanner;

/**
 *
 * @author imran
 */
public class The_3n_1_problem_100 {

    public static void main(String[] args) {

        int n = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of Element");
        n = input.nextInt();
        int r[] = new int[n];

        System.out.println("Enter any number ");
        for (int i = 0; i < n; i++) {
            r[i] = input.nextInt();

            if (r[i] % 2 == 1) {

                n = (3 * n) + 1;
                //System.out.println(" odd");
                System.out.println(" " + n);
            } else {
                n = n % 2;
                System.out.println(" " + n);
            }

        }

//        if (n == 1) {
//            if (n % 2 == 0) {
//                
//            }
//        }
    }

}
