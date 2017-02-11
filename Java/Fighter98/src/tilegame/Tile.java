package tilegame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

    // STATIC STUFF HERE
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirTile = new DirtTile(1);
    public static Tile rockTile = new RockTitle(2);

    protected BufferedImage texture;
    protected final int id;

    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
        
    }

    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }

    public int getId() {
        return id;
    }

}
