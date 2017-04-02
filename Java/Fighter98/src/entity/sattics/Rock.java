package entity.sattics;

import fighter98.gfx.Assets;
import java.awt.Graphics;
import tilegame.Handler;
import tilegame.StaticEntity;
import tilegame.Tile;

public class Rock extends StaticEntity {

    public Rock(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);

        bounds.x = 3;
        bounds.y = (int) (height / 2f);
        bounds.width = width - 6;
        bounds.height = (int) (height - height / 2f);
    }

    @Override
    public void die() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.stone, (int) (x - handler.getGameCamera().getxOffest()), (int) (y - handler.getGameCamera().getyOffset()), null);
    }

}
