package fighter98.gfx;

import entity.Entity;
import fighter98.Game;
import tilegame.Handler;

public class GameCamera {

    private Handler handler;
    //  private Entity e;
    private float xOffest, yOffset;

    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffest = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBankSpace() {
        if (xOffest < 0) {
            xOffest = 0;
        } else if (xOffest > handler.getWorld().getWidth() * tilegame.Tile.TILEWIDTH - handler.getWidth()) {
            xOffest = handler.getWorld().getWidth() * tilegame.Tile.TILEWIDTH - handler.getWidth();
        }

        if (yOffset < 0) {
            yOffset = 0;
        } else if (yOffset > handler.getWorld().getHeight() * tilegame.Tile.TILEHEIGHT - handler.getHeight()) {
            yOffset = handler.getWorld().getHeight() * tilegame.Tile.TILEHEIGHT - handler.getHeight();
        }
    }

    public void centerOnEntity(Entity e) {
        xOffest = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
        checkBankSpace();
    }

    public void move(float xAmnt, float yAmnt) {
        xOffest += xAmnt;
        yOffset += yAmnt;
        checkBankSpace();
    }

    public float getxOffest() {
        return xOffest;
    }

    public void setxOffest(float xOffest) {
        this.xOffest = xOffest;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

}
