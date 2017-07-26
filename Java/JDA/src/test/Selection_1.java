package test;

public class Selection_1 {

    public static void main(String[] args) {
        selection();
    }

    public static void selection() {

        int arry[] = {2, 0, 1, 6, 3, 4, 8, 7, 9, 5};

        //  int n = arry.length;
        for (int i = 0; i < arry.length; i++) {

            for (int j = i; j < arry.length; j++) {
                int index = i;
                //  System.out.println(" " + index);
                if (arry[j] < arry[index]) {
                    index = j;

                    // System.out.println(" fffffffffffffffffffffffffffffffffff ---->  " + index);
                    int number = arry[index];
                    arry[index] = arry[i];
                    arry[i] = number;
                }

            }
            System.out.println(" " + arry[i]);
        }

    }

}
