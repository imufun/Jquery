package ch2_conditional_structures_and_loops;

public class TernaryOperator {

    public static void main(String[] args) {

        double x = 50;
        double y = 70;
        System.out.println( "X value is \n " + x);
        System.out.println( "Y value is \n " + y);
        System.out.println("------------------");
        double min = (x > y) ? x : y;
        double diff = (x > y) ? x - y : x - y;

        System.out.println(min + "this \n " + diff);

    }
}
