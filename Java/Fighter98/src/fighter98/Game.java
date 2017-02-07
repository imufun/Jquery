package fighter98;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;

    private Thread thread;
    private boolean ruuning = false;
    private BufferStrategy bs;
    private Graphics graphics;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

    }

    private void init() {
        display = new Display(width, height, title);
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
        
        
        //Draw here
        
        graphics.fillRect(0, 0, width, height);
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
