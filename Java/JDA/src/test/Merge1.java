package test;

import sort.MargeSort;

/**
 *
 * @author imran
 */
public class Merge1 {

//    int arr[] = {4, 0, 5, 2, 14, 7, 9, 8, 3, 1};
//    int n1, n2;
//    int i, j, k, p, q, l, r;
//    int left, right;
    public static void main(String[] args) {
        //Merge1 m = new Merge1();
        int arr[] = {12, 11, 0, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        Merge1 ob = new Merge1();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
        //m.MargeSort();
    }

    public void MargeSort(int arr[], int p, int q, int r) {
        int n1 = q - p + 1; // 7 - 4 +1 =4
        int n2 = r - q;

        // create new array
        int L[] = new int[n1]; // 4 
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[p + i]; // 4 + 1 
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[q + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int p, int r) {
        if (p < r) {
            int mid = (p + r) / 2;
            sort(arr, p, r);
            sort(arr, mid + 1, r);
            MargeSort(arr, p, 1, r);
        }
    }
    /* A utility function to print array of size n */

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
