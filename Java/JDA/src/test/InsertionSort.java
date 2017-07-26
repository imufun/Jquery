package test;

public class InsertionSort {

    public static void main(String[] args) {
        insertionsort();
    }

    public static void insertionsort() {
        // int n = arr.length;
        int arry[] = {2, 4, 8, 5, 9, 0, 3};

        for (int i = 0; i < arry.length; i++) {

            //System.out.println(" key and Value " + i + " =  " + arry[i]);
            int key = arry[i];
            // System.out.println(" key =  " + key);
            int j = i - 1;

            //System.out.println(" j minus value  " + j );
            //System.out.println(" print j = " + j);
            while ((j > 0) && (arry[j] > key)) {

                //System.out.println(" j value = " + j + ", " + " arry[j] = " + arry[j] + ", key =" + key + "\n" + "----------------------------------------------------");
                arry[j + 1] = arry[j];
                //System.out.println(" " + arry[j + 1]);
                j--;
               // System.out.println(" j Decriment " + j);

            }
            arry[j + 1] = key;
            
            for (int k = 0; k < arry.length; k++) {
                System.out.println(" " + arry[k]);
            }

          //  System.out.println(" final short is = " + key);
        }

        System.out.println("-----------------------------------------");
    }
}
