package test;

public class SelectionSort {

    public static void main(String[] args) {
        SelectSort();
    }

    public static void SelectSort() {
        int arry[] = {2, 1, 3, 5, 9, 0, 3,};

        for (int i = 0; i < arry.length; i++) {
            int index = i;
            //System.out.println(" Array index item = " + index);
            for (int j = i; j < arry.length; j++) {
                // System.out.println(" \t" + " j value --> " + arry[j]);
                //System.out.print(" \t " + "-----------------------------------");
                if (arry[j] < arry[index]) { 
                    //System.out.print(" inddddddddddddd = " + arry[j]);
                  //  System.out.println();
                   // System.out.print(" xxxxxxxxxxxxxxxx = " + arry[index]);
                    //System.out.println();
                    index = j;
                    // System.out.println(" in = " + index );
                    int number = arry[index];
                    arry[index] = arry[i];
                    //System.out.print(" arry[i] " + arry[i]);                    
                    //System.out.print(" arry[index] " + arry[index]);
                    arry[i] = number;
                }
            }

             System.out.println();
            System.out.print(" final sort = " + arry[i]);
        }
        System.out.println();
    }
}
