/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithomwithgamedevelopment;

import display.Display;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;
import javafx.scene.shape.Circle;

public class GameLoop implements Runnable {

    public boolean Running = false;
    public Thread thread;
    private BufferStrategy bs;
    private Graphics graphics;
    private Display display;
    private Circle c;

    public GameLoop() {

        thread = new Thread();
        thread.start();
    }

    void init() {
        Display display = new Display(800, 600, "Game");
        display.CreateDisplay();

         
        graphics.setColor(Color.RED);
        graphics.fillOval(0, 0, 30, 30);
        graphics.drawOval(0, 50, 30, 30);
        graphics.fillRect(50, 0, 30, 30);
        graphics.drawRect(50, 50, 30, 30);
    }

//    public void paint(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setColor(Color.RED);
//        g2d.fillOval(0, 0, 30, 30);
//        g2d.drawOval(0, 50, 30, 30);
//        g2d.fillRect(50, 0, 30, 30);
//        g2d.drawRect(50, 50, 30, 30);
//
//        g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
//    }
    @Override
    public void run() {

        init();

        long FPS = 60;
        long timePerTick = 1000000000 / FPS;
        long delta = 0;
        long Now;
        long LasTime = System.nanoTime();

        while (Running) {
            try {

                Now = System.nanoTime();
                delta += (Now - LasTime) / timePerTick;
                LasTime = Now;
                long timer = 0;
                long ticks = 0;

                if (delta >= 1) {
                    // tick();
                    //render();
                    ticks++;
                    delta--;

                }
                if (timer >= 1000000000) {
                    System.out.println("Ticks and Frames: " + ticks);
                    ticks = 0;
                    timer = 0;
                }

                // render();
            } catch (Exception e) {
            }
        }
    }

    void render(Graphics bs) {
//        bs = display.getCanvas().getBufferStrategy();
//        if (bs == null) {
//            display.getCanvas().createBufferStrategy(3);
//            return;
//        }
//
//        graphics = bs.getDrawGraphics();
//        //Clear Screen 
//        graphics.clearRect(0, 0, width, height);
//
//        //Draw here  
//        if (State.getState() != null) {
//            State.getState().render(graphics);
//        }
//
//        bs.show();
        graphics.dispose();
    }

    public void draw(Graphics g) {
    }

    public void start() {
    }

    public void pause() {
    }

}
