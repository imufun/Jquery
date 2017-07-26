package sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arry = {100,9, -5, 5, 31, 0, 7, 8, 3, 6, 4, 2,-1};
        //  int[] arr1 = {9,14,3,2,43,11,58,22};
        for (int i = 0; i < arry.length; i++) {
            //System.out.println(" out = " + arry[i]);
            int index = i;
            // System.out.println(" out = " + index );
            for (int j = i; j < arry.length; j++) {
                if (arry[j] < arry[index]) {
                    index = j;
                }
            }

            int smallNumber = arry[index];
            arry[index] = arry[i];
            arry[i] = smallNumber;

            System.out.println("Sort Number  = "  + arry[i]);
        }
    }
}
