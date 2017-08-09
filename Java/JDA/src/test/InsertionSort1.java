package test;

public class InsertionSort1 {

    static int i, j, k;
    static int arr[] = {1, 0, 6, 3, 4, 8, 7, 5, 9};

    public static void main(String[] args) {
        insertion();
    }

    private static void insertion() {

        for (i = 0; i < arr.length; i++) {
            //System.out.print(" " + i);
            int key = arr[i];
            // System.out.print(" " + key);

            j = i - 1;

            while ((j > 0) && (arr[i] > key)) {

                arr[j + 1] = arr[i];
                j--;

                // System.out.println(" " + j + arr[i]);
            }
            arr[i + 1] = key;
            System.out.println(" " + arr[i]);
            // System.out.println(" "  + j + " "  + arr[i] + " " +  key);
        }

    }

}
