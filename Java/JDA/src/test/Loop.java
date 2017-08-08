/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author imran
 */
public class Loop {

    public static void main(String[] args) {

        int A[] = new int[100];
        int B[] = new int[100];

        for (int i = 0; i < A.length; i++) {
            A[i] = i;
            if (A[i] % 2 == 0) {
                System.out.println(" Even => " + A[i]);
            } else {
                System.out.println(" Odd => " + A[i]);
            }
            //System.out.print(" Nmber " + A[i] + " - ");
        }
    }

}
