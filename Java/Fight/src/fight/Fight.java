/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fight;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;

/**
 *
 * @author imran
 */
public class Fight extends Applet implements Runnable {

    @Override
    public void init() {

        setSize(800, 480);
        setBackground(Color.WHITE);
        setFocusable(true);
        Frame frame = (Frame) this.getParent().getParent();        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        while (true) {

            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
