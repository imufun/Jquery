package fighter98.gfx;

import entity.Entity;
import fighter98.Game;

public class GameCamera {

    private Game game;
    private Entity e;
    private float xOffest, yOffset;

    public GameCamera(Game game, float xOffset, float yOffset) {
        this.game = game;
        this.xOffest = xOffset;
        this.yOffset = yOffset;
    }

    public void centerOnEntity(Entity e) {
        xOffest = e.getX() - game.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - game.getHeight() / 2 + e.getHeight() / 2;
    }

    public void move(float xAmnt, float yAmnt) {
        xOffest += xAmnt;
        yOffset += yAmnt;
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
