/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import java.applet.*;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author imran
 */
public class Display {

    int WIDTH, HEIGHT;
    private String title;

    private JFrame jFrame;
    private Canvas canvas;

    public Display(int width, int height, String title) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.title = title;
        CreateDisplay();
    }

    public void CreateDisplay() {
        jFrame = new JFrame();
        jFrame.setSize(WIDTH, HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setTitle(title);
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

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFram() {
        return jFrame;
    }

}
