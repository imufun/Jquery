package fighter98;

import fighter98.gfx.ImageLoader;
import fighter98.display.Display;
import fighter98.gfx.Assets;
import fighter98.gfx.GameCamera;
import fighter98.gfx.SpriteSheet;
import input.KeyManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;
import state.GameState;
import state.MenuState;
import state.State;
import tilegame.Handler;

public class Game implements Runnable {

    private Display display;
    private int width, height;
    public String title;

    private Thread thread;
    private boolean ruuning = false;
    private BufferStrategy bs;
    private Graphics graphics;

    //load 
    //State
    private State Gamestate;
    private State menuState;

    //input
    private KeyManager keyManager;

    //Camera
    private GameCamera gameCamera;
    
    //Handler
    private Handler handler;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        keyManager = new KeyManager();

    }

    private void init() {
        display = new Display(width, height, title);
        display.getFram().addKeyListener(keyManager);
        Assets.init();

        gameCamera = new GameCamera(this, 0, 0);
        handler =new Handler(this);
        Gamestate = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(Gamestate);
    }

    private void tick() {
        keyManager.tick();
        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        graphics = bs.getDrawGraphics();
        //Clear Screen 
        graphics.clearRect(0, 0, width, height);

        //Draw here  
        if (State.getState() != null) {
            State.getState().render(graphics);
        }

        bs.show();
        graphics.dispose();
        //end

    }

    @Override
    public void run() {
        init();

        // 
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        while (ruuning) {

            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;
            long timer = 0;
            long ticks = 0;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    public KeyManager geKeyManager() {
        return keyManager;

    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized void start() {
        if (ruuning) {
            return;
        }
        ruuning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!ruuning) {
            return;
        }
        ruuning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
