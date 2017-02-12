package world;

import java.awt.Graphics;
import tilegame.Handler;
import tilegame.Tile;

public class World {

    private Handler handler;
    private int width, height;
    private int spanX, spanY;
    private int[][] tiles;

    public World(Handler handler, String path) {
        this.handler = handler;
        loadWorld(path);
    }

    public void tick() {

    }

    public void render(Graphics graphics) {

        //start Rendering Efficiency // here condition checking...
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffest() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffest() + handler.getWidth()) / Tile.TILEWIDTH + 1);

        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
        //end Rendering Efficiency

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(graphics, (int) (x * Tile.TILEHEIGHT - handler.getGameCamera().getxOffest()), (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
    }

    public Tile getTile(int x, int y) {
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.dirTile;
        }
        return t;
    }

    private void loadWorld(String path) {
        String file = utils.Utils.loadFileAsString(path);
        String[] token = file.split("\\s+");
        width = utils.Utils.parseInt(token[0]);
        height = utils.Utils.parseInt(token[1]);
        spanX = utils.Utils.parseInt(token[2]);
        spanY = utils.Utils.parseInt(token[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = utils.Utils.parseInt(token[x + y * width + 4]);
            }
        }

    }

}
