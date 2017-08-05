/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Imran
 */
public class Selection_2 {

    public static void main(String[] args) {
        selectionSort();
    }

    private static void selectionSort() {
        int arr[] = {1, 0, 7, 4, 6, 2, 5, 9};

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {
                int index = i;
                if (arr[j] < arr[index]) {
                    System.out.println(" index -------------" + arr[j]);
                    index = j;
                    System.out.println(" ii  " + index);
                    int num = arr[index];
                   System.out.println(" number " + " " + num);
                    arr[index] = arr[i];
                    arr[i] = num;
                }

            }
            //System.out.println(" sort number " + arr[i]);
        }

    }
}
