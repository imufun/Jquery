package fighter98;

import fighter98.gfx.ImageLoader;
import fighter98.display.Display;
import fighter98.gfx.Assets;
import fighter98.gfx.SpriteSheet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;

    private Thread thread;
    private boolean ruuning = false;
    private BufferStrategy bs;
    private Graphics graphics;

    //load 

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

    }

    private void init() {
        display = new Display(width, height, title);         
        Assets.init();
    }

    private void tick() {

    }

    private void render() {        
        bs  = display.getCanvas().getBufferStrategy();       
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        graphics = bs.getDrawGraphics();
        //Clear Screen 
        graphics.clearRect(0, 0, width, height);
        
        //Draw here  
        graphics.drawImage(Assets.dirt, 100, 100,null);
        graphics.drawImage(Assets.grass, 50, 70,null);
        graphics.drawImage(Assets.tree, 10, 120,null);
        graphics.drawImage(Assets.player, 140, 300,null);
        graphics.drawImage(Assets.stone,220, 500,null);
        
        bs.show();
        graphics.dispose();
        //end
         
    }

    @Override
    public void run() {
        init();
        while (ruuning) {
            tick();
            render();
        }
        stop();
    }

    public synchronized void start() {
        if (ruuning)    return; 
        ruuning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!ruuning)  return;        
        ruuning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
