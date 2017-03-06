/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fight;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import player.Robot;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

/**
 *
 * @author imran
 */
public class Fight extends Applet implements Runnable, KeyListener {

    private Robot robot;
    private Image image, charecter;
    private Graphics graphics;
    private URL base;

    @Override
    public void init() {

        setSize(800, 480);
        setBackground(Color.BLACK);
        setFocusable(true);
        Frame frame = (Frame) this.getParent().getParent();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        try {
            base = getDocumentBase();
        } catch (Exception e) {
        }

        //image setups
        charecter = getImage(base, "res/charecter.png");
    }

    @Override
    public void start() {
        robot = new Robot();
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

    //update method
    @Override
    public void update(Graphics g) {
        if (image == null) {
            image = createImage(this.getHeight(), this.getHeight());
            graphics = image.getGraphics();
        }

        graphics.setColor(getBackground());
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.setColor(getForeground());
        paint(graphics);

        g.drawImage(image, 0, 0, this);
    }

    //paint method
    @Override
    public void paint(Graphics g) {
        g.drawImage(charecter, robot.getCenterX() - 60, robot.getCenterY() - 63, this);
    }

    
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("Move Up");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Move Down");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Move Right");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Move Left");
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("Jump");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("Stop moving up");
                break;

            case KeyEvent.VK_DOWN:
                System.out.println("Stop moving down");
                break;

            case KeyEvent.VK_LEFT:
                System.out.println("Stop moving left");
                break;

            case KeyEvent.VK_RIGHT:
                System.out.println("Stop moving right");
                break;

            case KeyEvent.VK_SPACE:
                System.out.println("Stop jumping");
                break;

        }
    }
}
