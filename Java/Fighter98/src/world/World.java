package world;

import java.awt.Graphics;
import tilegame.DirtTile;
import tilegame.Tile;

public class World {

    private int width, height;
    private int spanX, spanY;
    private int[][] tiles;

    public World(String path) {
        loadWorld(path);
    }

    public void tick() {
    }

    public void render(Graphics graphics) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(graphics, x * Tile.TILEHEIGHT, y * Tile.TILEHEIGHT);
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
