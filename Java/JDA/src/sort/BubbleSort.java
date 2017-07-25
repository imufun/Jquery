package sort;

/**
 *
 * @author imran
 */
public class BubbleSort {

    public static void bubbleSort(int arry[]) {
        //  int[] arry = {21, 18, 16, 0, 8, 14, 1, 9, 3, 2};
        int n = arry.length;
        // int n = arry.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {//21, 18, 16, 0, 8, 14, 1, 9, 3, 2
            //System.out.println(" " + n);
            for (int j = 1; j < (n - 1); j++) {

                System.out.print(" j =(" + j + ")," );
                System.out.print(" array = (" + arry[j-1] + "),");
                if (arry[j - 1] > arry[j]) {
                    //System.out.print(" " + arry[j]);

                    temp = arry[j - 1];
                    arry[j - 1] = arry[j];
                    arry[j] = temp;

                }
            }
        }
    }

    public static void main(String[] args) {
        int arry[] = {3, 60, 35, 2, 45, 3, 2, 0};
        BubbleSort bs = new BubbleSort();

        bubbleSort(arry);
        System.out.println();
        
        for (int i = 0; i < arry.length; i++) {
            System.out.println(arry[i]);
        }

        //int arry[] = {21, 18, 16, 0, 8, 14, 1, 9, 3, 2};
        //arry ][] = {21, 18, 16, 0, 8, 14, 1, 9, 3, 2}
        //bs.bubbleSort(arry);
//        System.out.println("Array After Bubble Sort");
//        for (int i = 0; i < arry.length; i++) {
//            System.out.print(arry[i] + " ");
//        }
    }

}
