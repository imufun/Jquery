package test;

public class SelectionSort_2 {

    public static void main(String[] args) {
        sel();
    }

    public static void sel() {
        int arry[] = {4, 5, 0, 1, 3, 8, 9, 4, 1, -1, 4, 6, 7, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 5};

        for (int i = 0; i < arry.length; i++) {

            for (int j = i; j < arry.length; j++) {

                int index = j;

                if (arry[j] < arry[i]) {
                    int num = arry[index];
                    arry[index] = arry[i];
                    arry[i] = num;
                }

            }
            System.out.println(" " + arry[i]);
        }
    }
}
