package entity;

import fighter98.Game;
import fighter98.gfx.Assets;
import java.awt.Graphics;

public class Player extends Creature {

    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y);

        this.game = game;
    }

    @Override
    public void tick() {
        if (game.geKeyManager().up) {
            y -= 3;
        }
        if (game.geKeyManager().down) {
            y += 3;
        }
        if (game.geKeyManager().left) {
            x -= 3;
        }
        if (game.geKeyManager().right) {
            x += 3;
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.player, (int) x, (int) y, null);

    }

}
