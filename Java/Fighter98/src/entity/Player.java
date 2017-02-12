package entity;

import fighter98.Game;
import fighter98.gfx.Assets;
import static fighter98.gfx.Assets.mainplayer;
import java.awt.Graphics;

public class Player extends Creature {

    public Player(Game game, float x, float y) {
        super(game, x, y, Creature.DEFAULT_CREATER_WIDTH, Creature.DEFAULT_CREATER_HIGHT);
        this.game = game;
    }

    @Override
    public void tick() {
        getInput();
        move();
        game.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
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

        // speed boost
        if (game.geKeyManager().shift) {
            yMove = -boostspeed;
        }
        if (game.geKeyManager().shift) {
            yMove = boostspeed;
        }
        if (game.geKeyManager().shift) {
            xMove = -boostspeed;
        }
        if (game.geKeyManager().shift) {
            xMove = boostspeed;
        }

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.mainplayer, (int) (x - game.getGameCamera().getxOffest()), (int) (y - game.getGameCamera().getyOffset()), width, health, null);
        //this is proper movement with camera
    }

}
