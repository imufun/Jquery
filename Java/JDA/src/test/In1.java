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
public class In1 {

    public static void main(String[] args) {

        int arr[] = {2, 0, 4, 1, 9, 5, 3, 7, 6};
        for (int i = 0; i < 10; i++) {

            int key = arr[i];
            int j = i - 1;
            //   System.out.println(" " + j);

            while ((j > 0) && (arr[j] > key)) {

               // System.out.println("  " +   " array j " + arr[j] + " key == " + key);
                arr[j + 1] = arr[j];
               //  System.out.println(" jjjjjjjjjjjjjjjjjj " + arr[j + 1] + arr[j]);
                j--;
              //  System.out.println(" " + j);
            }

            arr[j + 1] = key;
            System.out.println("  " + arr[i]);
        }
    }

}
