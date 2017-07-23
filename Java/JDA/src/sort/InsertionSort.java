package sort;

import java.util.Scanner;

/**
 *
 * @author imran
 */
public class InsertionSort {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, i;
        System.out.println("Enter number of integer elements");
        n = s.nextInt();

        int arry[] = new int[n];

        System.out.println("\nEnter " + n + " integer elements");
        for (i = 0; i < n; i++) {
            arry[i] = s.nextInt();
        }
        /* Call method sort */
        Short(arry);
        /* Print sorted Array */
        System.out.println("\nElements after sorting ");
        for (i = 0; i < n; i++) {
            System.out.print(arry[i] + " ");
        }
        System.out.println();

    }

    public static void Short(int[] arry) {
        //int[] arry = {2, 1, 99, 4, 3, 8, 6, 10, -1, 1, -7, 7, 5, 6};
        int n = arry.length;
        for (int i = 0; i < n; i++) {
            int key = arry[i];
            int j = i - 1;
            while ((j > -1) && (arry[j] > key)) {
                arry[j + 1] = arry[j];
                j--;
            }
            arry[j + 1] = key;
        }

    }

}
