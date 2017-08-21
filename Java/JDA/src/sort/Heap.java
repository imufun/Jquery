
import java.util.*;

public class Heap {

    public static void main(String[] args) {

    }

    static heapBuild(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {

        }

    }

    void heap(int[] arr, int n, int i) {
        int length = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (i < n && arr[left] > arr[length]) {
            length = left;
        }
        if (i < n && arr[right] > arr[length]) {
            length = right;
        }

        if (length != i) {
            int swap = arr[i];
            arr[i] = length;
            arr[i] = swap;
            heap(arr, n, i);
        }
    }
}
