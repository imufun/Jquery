package sort;

import java.util.Random;

public class MargeSort {

    public static void main(String[] args) {

        Random r = new Random();
        int arr[] = {2, 1, 6, 8, 0, 7, 1, 2, 3, 5, 4};// a[], p to r and q is the half or mid point
        System.out.println("Give Array");
        printArray(arr);
        MargeSort ms = new MargeSort();
        ms.sort(arr, 0, arr.length - 1);

        System.out.println(" \nSorted Array");
        printArray(arr);
    }

    static public void margesort(int arr[], int m, int l, int r) {

        int i, j;
        int n1 = m - l + 1;
        int n2 = r - m;

        int left[] = new int[n1];
        int right[] = new int[n2];

        for (i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }

        for (j = 0; j < n2; j++) {
            right[j] = arr[m + 1 + j];
        }

        i = 0;
        j = 0;
        int k = 0;
        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            j++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }

    }

    void sort(int arr[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            sort(arr, l, r);
            sort(arr, mid + 1, r);
            margesort(arr, mid, l, r);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.println(" " + arr[i]);
        }
    }

}
