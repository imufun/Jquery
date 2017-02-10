package state;

import entity.Player;
import fighter98.Game;
import fighter98.gfx.Assets;
import java.awt.Graphics;

public class GameState extends State{

    private Player player;
    
    public GameState(Game game) {
        super(game);
        player = new Player(game,100, 100);
    }     

    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics graphics) {
    // graphics.drawImage(Assets.dirt, 0, 0, null);     
       player.render(graphics);
    } 
}
