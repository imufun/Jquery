package Search;

public class SearchInsertDeleteArrary {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 4, 55, 0, 22, 15, 11, 22, 0, 9, 65, 7, 5};
        int n = arr.length;

        int arrInsert[] = new int[20];
        arrInsert[0] = 10;
        arrInsert[1] = 0;
        arrInsert[2] = 1;
        arrInsert[3] = 5;
        arrInsert[4] = 9;

        //useing last element as search element
        int key = 8;
        int position = findElement(arr, n, key);
        if (position == -1) {
            System.out.println("Element not found ");

        } else {
            System.out.println("Eelement Found at Position = " + (position + 1));
        }

        System.out.println(" \n");

        //insert with sort
        int capacity = 30;
        int nn=6;
        int i, keyy = 100;

        System.out.print("Before Insertion: ");
        for ( i = 0; i < nn; i++) {
            System.out.println(arrInsert[i] + " ");
        }
        nn = insertSorted(arrInsert, nn, keyy, capacity);

        System.out.print("\nAfter Insertion: ");
        for ( i = 0; i < nn; i++) {
            System.out.println(arrInsert[i]);
        }

    }

    /* Function to implement 
     search operation */
    static int findElement(int arrInsert[], int nn, int keyy) {
        for (int i = 0; i < nn; i++) {
            if (arrInsert[i] == keyy) // 55 = 55
            {
                return i;
            }
        }
        return -1;
    }

    static int insertSorted(int arr[], int n, int key, int capacity) {
        if (n >= capacity) {
            return n;
        }
        arr[n] = key;
        return (n + 1);
    }
}
