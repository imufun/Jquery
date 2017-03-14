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
import java.util.ArrayList;
import player.Heliboy;

/**
 *
 * @author imran
 */
public class Fight extends Applet implements Runnable, KeyListener {

    private Image image, currentSprite, charecter, charecter2, charecter3, charecterDown, charecterJumped, background, heliboy, heliboy2, heliboy3, heliboy4, heliboy5;
    private Graphics second;
    private URL base;

    private Robot robot;
    private Heliboy hb1, hb2;
    private Animation anim, hanim;
    private static Background bg1, bg2;

    @Override
    public void init() {

        setSize(800, 480);
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);
        Frame frame = (Frame) this.getParent().getParent();
        frame.setLocationRelativeTo(null);
        frame.setTitle("FIGHT");
        frame.setVisible(true);

        try {
            base = getDocumentBase();
        } catch (Exception e) {

        }

        //image setups
        //charecter = getImage(base, "res/charecter.png");
        //charecter = getImage(base, "data/chatecter.png");
        // Image Setups
        charecter = getImage(base, "../data/character.png");
        charecterDown = getImage(base, "../data/down.png");
        charecterJumped = getImage(base, "../data/jumped.png");
        currentSprite = charecter;

        heliboy = getImage(base, "../data/heliboy.png");
        heliboy2 = getImage(base, "../data/heliboy2.png");
        heliboy3 = getImage(base, "../data/heliboy3.png");
        heliboy4 = getImage(base, "../data/heliboy4.png");
        heliboy5 = getImage(base, "../data/heliboy5.png");

        background = getImage(base, "../data/background.png");

        anim = new Animation();
        anim.addFrame(charecter, 1250);
        anim.addFrame(charecter2, 50);
        anim.addFrame(charecter3, 50);
        anim.addFrame(charecter2, 50);

        hanim = new Animation();

        hanim.addFrame(heliboy, 100);
        hanim.addFrame(heliboy2, 100);
        hanim.addFrame(heliboy3, 100);
        hanim.addFrame(heliboy4, 100);
        hanim.addFrame(heliboy5, 100);
        hanim.addFrame(heliboy2, 100);
        hanim.addFrame(heliboy3, 100);
        hanim.addFrame(heliboy5, 100);
        hanim.addFrame(heliboy3, 100);

        currentSprite = anim.getImage();

        // charecter =getImage(getClass().getResource("data/chatecter.png"));
    }

    @Override
    public void start() {
        //set background 
        bg1 = new Background(0, 0);
        bg2 = new Background(2160, 0);

        //set Enemy-> Heliboy image & position
        hb1 = new Heliboy(340, 60);
        hb2 = new Heliboy(700, 360);

        //set robot images
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
            robot.update();
            if (robot.isJumped()) {
                currentSprite = charecterJumped;
            } else if (robot.isJumped() == false && robot.isDucked() == false) {
                currentSprite = anim.getImage();
            }

            ArrayList projecttils = robot.getProjectiles();
            for (int i = 0; i < projecttils.size(); i++) {
                ProjectTile p;
                p = (ProjectTile) projecttils.get(i);
                if (p.isVisible() == true) {
                    p.update();
                } else {
                    projecttils.remove(i);
                }
                System.out.println("Bullet---------------> " + i);
            }

            hb1.update();
            hb2.update();
            bg1.update();
            bg2.update();
            animation();
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
            second = image.getGraphics();
        }

        second.setColor(getBackground());
        second.fillRect(0, 0, getWidth(), getHeight());
        second.setColor(getForeground());
        paint(second);

        g.drawImage(image, 0, 0, this);
    }

    //paint method
    @Override
    public void paint(Graphics g) {

        //background position move with player 
        g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
        g.drawImage(background, bg2.getBgX(), bg2.getBgY(), this);

        g.drawImage(hanim.getImage(), hb1.getCenterX() - 48, hb1.getCenterY() - 48, this);
        g.drawImage(hanim.getImage(), hb2.getCenterX() - 48, hb2.getCenterY() - 48, this);
        //player position 
        g.drawImage(currentSprite, robot.getCenterX() - 61, robot.getCenterY() - 63, this);

        ArrayList projecttils = robot.getProjectiles();
        for (int i = 0; i < projecttils.size(); i++) {
            ProjectTile p = (ProjectTile) projecttils.get(i);
            g.setColor(Color.YELLOW);
            g.fillRect(p.getX(), p.getY(), 10, 5);

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                robot.Jummp();
                robot.shoot();
                System.out.println("Move Up");
                break;
            case KeyEvent.VK_DOWN:
                currentSprite = anim.getImage();
                if (robot.isJumped() == false) {
                    robot.setDucked(true);
                    robot.setSpeedX(0);

                    System.out.println("Move Down");
                }
                break;

            case KeyEvent.VK_LEFT:
                robot.MoveLeft();
                robot.setMovingLeft(true);
                System.out.println("Move Left");
                break;
            case KeyEvent.VK_RIGHT:
                robot.MoveRight();
                robot.setMovingRight(true);
                System.out.println("Move Right");
                break;

            case KeyEvent.VK_SPACE:
                robot.Jummp();
                System.out.println("Jump");
                break;

            case KeyEvent.VK_CONTROL:
                if (robot.isDucked() == false && robot.isJumped() == false) {
                    robot.shoot();
                }
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
                currentSprite = charecter;
                robot.setDucked(false);
                System.out.println("Stop moving down");
                break;

            case KeyEvent.VK_LEFT:
                robot.stopLeft();
                System.out.println("Stop moving left");
                break;

            case KeyEvent.VK_RIGHT:
                robot.stopRight();
                System.out.println("Stop moving right");
                break;

            case KeyEvent.VK_SPACE:
                System.out.println("Stop jumping");
                break;

        }
    }

    public static Background getBg1() {
        return bg1;
    }

    public static Background getBg2() {
        return bg2;
    }

    private void animation() {
        anim.update(10);
        hanim.update(50);
    }
}
