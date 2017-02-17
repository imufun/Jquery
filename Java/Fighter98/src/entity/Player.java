package entity;

import fighter98.Game;
import fighter98.gfx.Animation;
import fighter98.gfx.Assets;
import static fighter98.gfx.Assets.mainplayer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import tilegame.Handler;

public class Player extends Creature {

    //Animation
    private Animation AnimationDown, AnimationUp, AnimationLeft, AnimationRight;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATER_WIDTH, Creature.DEFAULT_CREATER_HIGHT);
        // this.handler = handler;

        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;

        //Animation
        AnimationDown = new Animation(500, Assets.player_down);
        AnimationUp = new Animation(500, Assets.player_up);
        AnimationLeft = new Animation(500, Assets.player_left);
        AnimationRight = new Animation(500, Assets.player_right);

    }

    @Override
    public void tick() {
        //animation
        AnimationDown.tick();
        //Movement

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
        graphics.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffest()), (int) (y - handler.getGameCamera().getyOffset()), width, health, null);

        //this is proper movement with camera
//        graphics.setColor(Color.red);
//        graphics.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffest()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame() {
        //return AnimationDown.getCurrentFrame();
        if (xMove < 0) {
            return AnimationLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return AnimationRight.getCurrentFrame();
        } else if (yMove < 0) {
            return AnimationUp.getCurrentFrame();
        } else {
            return AnimationDown.getCurrentFrame();
        }
    }

}
