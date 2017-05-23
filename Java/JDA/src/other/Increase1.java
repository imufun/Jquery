/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package other;

/**
 *
 * @author imran
 */
public class Increase1 {

    public static void main(String[] args) {
        int i, x, y, speed, max = 0, min = 0;

        Increase1 increase1 = new Increase1();
        for (i = 0; i < 10; i++) {

            System.out.print(" i = " + i);

        }
        System.out.println(" \n");
        if (max <= i) {
            System.out.println(" min " + i);
        } else if (min >= i) {
            System.out.println(" MAx " + i);
        }
    }

    public Increase1() {
    }

    public Increase1(int x, int speed) {
        x = 10;
        speed = 0;
        if (x < speed) {
            x += speed;
            System.out.println(" " + x);
        }

    }
}
