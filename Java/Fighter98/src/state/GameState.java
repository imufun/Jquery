package state;

import entity.Player;
import fighter98.Game;
import fighter98.gfx.Assets;
import java.awt.Graphics;
import tilegame.Tile;
import world.World;

public class GameState extends State {
    
    private Player player;
    private World world;
    
    public GameState(Game game) {
        super(game);
        player = new Player(game, 100, 100);
        world = new World(game, "res/world/world1.txt"); 
    }
    
    @Override
    public void tick() {
        player.tick(); 
    }
    
    @Override
    public void render(Graphics graphics) {
        // graphics.drawImage(Assets.dirt, 0, 0, null);     
        world.render(graphics);
        player.render(graphics);
        
    }
}
