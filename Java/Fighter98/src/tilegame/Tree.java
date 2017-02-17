package tilegame;

import fighter98.gfx.Assets;
import java.awt.Graphics;

public class Tree extends StaticEntity {

    public Tree(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.tree, (int) (x - handler.getGameCamera().getxOffest()), (int) (y - handler.getGameCamera().getyOffset()), null);
    }

}
