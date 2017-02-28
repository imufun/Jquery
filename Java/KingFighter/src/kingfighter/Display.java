/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kingfighter;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author imran
 */
public class Display {

    private int WIDTH;
    private int HEIGHT;
    private String Title;

    private JFrame jFrame;
    private Canvas canvas;

    public Display(int WIDTH, int HEIGHT, String Title) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.Title = Title;

        CreateDisplay();
    }

    private void CreateDisplay() {
        jFrame = new JFrame();
        jFrame.setSize(WIDTH, HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setTitle(Title);
        jFrame.setVisible(true);

        //canvas
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(false);
        jFrame.add(canvas);
        jFrame.pack();
    }

}
