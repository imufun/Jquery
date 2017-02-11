package entity;

import fighter98.Game;
import fighter98.gfx.Assets;
import java.awt.Graphics;

public class Player extends Creature {

    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y, Creature.DEFAULT_CREATER_WIDTH, Creature.DEFAULT_CREATER_HIGHT);
        this.game = game;
    }

    @Override
    public void tick() {
        getInput();
        move();
    }
    
    private void getInput(){
        xMove = 0;
        yMove = 0;
        
        if (game.geKeyManager().up) {
            yMove = -speed;
        }
        
        if (game.geKeyManager().down) {
            yMove = speed;
        }
        
        if (game.geKeyManager().left) {
            xMove = -speed;
        }
        
        if (game.geKeyManager().right) {
            xMove = speed;
        }
        
             
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.player, (int) x, (int) y, width, health, null);
    }

}
