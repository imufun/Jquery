package sort;


public class HeapSort {

    public static void main(String[] args) {

        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;
        HeapSort h = new HeapSort();
        h.HeapBuild(arr);
        System.out.print(" Sorted array is ");
        printArray(arr);

    }

    // print
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //Heap Builder
    void HeapBuild(int arr[]) {

        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heap(arr, i, 0);
        }
    }

    public void heap(int arr[], int n, int i) {
        int largest = i;// root 
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heap(arr, n, largest);
        }
    }

}
