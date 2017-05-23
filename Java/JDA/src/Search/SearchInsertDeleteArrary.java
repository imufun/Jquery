package Search;

public class SearchInsertDeleteArrary {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 4, 55, 0, 22, 15, 11, 22, 0, 9, 65, 7, 5};
        int n = arr.length;

        //useing last element as search element
        int key = 15;
        int position = findElement(arr, n, key);
        if (position == -1) {
            System.out.println("Element not found ");

        } else {
            System.out.println("Eelement Found at Position " + (position + 1));
        }
    }

    /* Function to implement 
     search operation */
    static int findElement(int arr[], int n, int key) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) // 55 = 55
            {
                return i;
            }
        }
        return -1;
    }
}
