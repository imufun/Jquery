/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fighter98;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {

   // private int width = 600;
    // private int height = 400;
    private int width;
    private int height;
    private String title;

    private JFrame jFrame;
    private Canvas canvas;

    public Display() {
    }

    public Display(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        CreateDisplay();
    }

    public void CreateDisplay() {
        jFrame = new JFrame();
        jFrame.setSize(width, height);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setTitle(title);
        jFrame.setVisible(true);   
        
        //canvas
        canvas =new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        
        jFrame.add(canvas);
        jFrame.pack();
    }
    
    public Canvas getCanvas(){
        return  canvas;
    } 

}
