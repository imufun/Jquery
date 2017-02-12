package world;

import fighter98.Game;
import java.awt.Graphics;
import tilegame.DirtTile;
import tilegame.Tile;

public class World {

    private Game game;
    private int width, height;
    private int spanX, spanY;
    private int[][] tiles;

    public World(Game game, String path) {
        this.game = game;
        loadWorld(path);
    }

    public void tick() {

    }

    public void render(Graphics graphics) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(graphics, (int) (x * Tile.TILEHEIGHT - game.getGameCamera().getxOffest()), (int) (y * Tile.TILEHEIGHT - game.getGameCamera().getyOffset()));
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
