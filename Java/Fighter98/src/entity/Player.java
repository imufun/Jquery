package entity;

import fighter98.Game;
import fighter98.gfx.Animation;
import fighter98.gfx.Assets;
import static fighter98.gfx.Assets.mainplayer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import tilegame.Handler;

public class Player extends Creature {

    //Animation
    private Animation AnimationDown, AnimationUp, AnimationLeft, AnimationRight;

    //Attack timere
    private long lastAttackTimer, attackCooldown = 800, attacTime = attackCooldown;

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
    public void die() {
        System.out.println("You Loss");
    }

    @Override
    public void tick() {
        //animation
        AnimationDown.tick();
        AnimationUp.tick();
        AnimationLeft.tick();
        AnimationRight.tick();

        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

        //Attact
        CheckAttacks();
    }

    private void CheckAttacks() {
        attacTime += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attacTime < attackCooldown) {
            return;
        }
        
        Rectangle cb = getCollisionBounds(0, 0);

        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if (handler.getKeyManager().aUp) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        } else if (handler.getKeyManager().aDown) {
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        } else if (handler.getKeyManager().aLeft) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else if (handler.getKeyManager().aRight) {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else {
            return;
        }
        
        attacTime = 0;       
        
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this)) {
                continue;
            }
            if (e.getCollisionBounds(0, 0).intersects(ar)) {
                e.hurt(1);
                return;
            }
        }
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up) {
            yMove = -speed;
        }

        if (handler.getKeyManager().down) {
            yMove = speed;
        }

        if (handler.getKeyManager().left) {
            xMove = -speed;
        }

        if (handler.getKeyManager().right) {
            xMove = speed;
        }

        // speed boost
        if (handler.getKeyManager().shift) {
            yMove = -boostspeed;
        }
        if (handler.getKeyManager().shift) {
            yMove = boostspeed;
        }
        if (handler.getKeyManager().shift) {
            xMove = -boostspeed;
        }
        if (handler.getKeyManager().shift) {
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
