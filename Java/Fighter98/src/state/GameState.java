package state;

import entity.Player;
import fighter98.Game;
import fighter98.gfx.Assets;
import java.awt.Graphics;
import tilegame.Handler;
import tilegame.Tile;
import tilegame.Tree;
import world.World;

public class GameState extends State {

    private Player player;
    private World world; 

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler, "res/world/world1.txt");
        handler.setWorld(world);
        player = new Player(handler, 100, 100); 
    }

    @Override
    public void tick() {
        world.tick();
        player.tick(); 
    }

    @Override
    public void render(Graphics graphics) {
        // graphics.drawImage(Assets.dirt, 0, 0, null);     
        world.render(graphics);
        player.render(graphics); 

    }
}
