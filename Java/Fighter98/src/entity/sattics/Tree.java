package entity.sattics;

import fighter98.gfx.Assets;
import java.awt.Graphics;
import tilegame.Handler;
import tilegame.StaticEntity;
import tilegame.Tile;

public class Tree extends StaticEntity {

    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);

        bounds.x = 10;
        bounds.y = (int) (height / 1.5f);
        bounds.width = width - 20;
        bounds.height = (int) (height - height / 1.5f);
    }

    @Override
    public void die() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffest()), (int) (y - handler.getGameCamera().getyOffset()), null);
    }

}
