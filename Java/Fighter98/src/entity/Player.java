package entity;

import fighter98.Game;
import fighter98.gfx.Assets;
import static fighter98.gfx.Assets.mainplayer;
import java.awt.Graphics;
import tilegame.Handler;

public class Player extends Creature {

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATER_WIDTH, Creature.DEFAULT_CREATER_HIGHT);
       // this.handler = handler;
    }

    @Override
    public void tick() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.geKeyManager().up) {
            yMove = -speed;
        }

        if (handler.geKeyManager().down) {
            yMove = speed;
        }

        if (handler.geKeyManager().left) {
            xMove = -speed;
        }

        if (handler.geKeyManager().right) {
            xMove = speed;
        }

        // speed boost
        if (handler.geKeyManager().shift) {
            yMove = -boostspeed;
        }
        if (handler.geKeyManager().shift) {
            yMove = boostspeed;
        }
        if (handler.geKeyManager().shift) {
            xMove = -boostspeed;
        }
        if (handler.geKeyManager().shift) {
            xMove = boostspeed;
        }

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.mainplayer, (int) (x - handler.getGameCamera().getxOffest()), (int) (y - handler.getGameCamera().getyOffset()), width, health, null);
        //this is proper movement with camera
    }

}
