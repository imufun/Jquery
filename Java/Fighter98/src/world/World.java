package world;

import entity.EntityManager;
import entity.Player;
import java.awt.Graphics;
import tilegame.Handler;
import tilegame.Tile;
import tilegame.Tree;

public class World {

    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;

    //Entity
    private EntityManager entityManager;

    public World(Handler handler, String path) {
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        entityManager.addEntity(new Tree(handler, 689, 100));
        entityManager.addEntity(new Tree(handler, 844, 120));
        entityManager.addEntity(new Tree(handler, 125, 150));
        entityManager.addEntity(new Tree(handler, 352, 170));
        entityManager.addEntity(new Tree(handler, 100, 200));
        entityManager.addEntity(new Tree(handler, 426, 250));
        entityManager.addEntity(new Tree(handler, 120, 300));
        entityManager.addEntity(new Tree(handler, 950, 550));
        entityManager.addEntity(new Tree(handler, 503, 500));
        entityManager.addEntity(new Tree(handler, 800, 600));

        loadWorld(path);

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }

    public void tick() {
        entityManager.tick();
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

        //Entity
        entityManager.rendder(graphics);
    }

    public Tile getTile(int x, int y) {

        //Collision Detection
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.grassTile;
        }

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
        spawnX = utils.Utils.parseInt(token[2]);
        spawnY = utils.Utils.parseInt(token[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = utils.Utils.parseInt(token[x + y * width + 4]);
            }
        }

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    
    
}
