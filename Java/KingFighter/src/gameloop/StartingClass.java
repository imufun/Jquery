/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameloop;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import kingfighter.Robot;

/**
 *
 * @author imran
 */
public class StartingClass implements Runnable, KeyListener {

    private boolean running = false;

    private Robot robot;
    private Image image;
    private Graphics graphics;
    
    public void init() {
        start();
        
        
    }

    public void start() {
        robot = new Robot();
        Thread thread = new Thread(this);      
        thread.start(); 
    }

    public void stop() {
    }

    public void destroy() {
    }
    
    private void update(Graphics g){
        
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i += 2) {
            System.out.println("hello");
        }
        while (true) {
            robot.update();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
