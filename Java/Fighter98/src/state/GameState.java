package state;

import fighter98.gfx.Assets;
import java.awt.Graphics;

public class GameState extends State{

    public GameState() {
    }     

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics graphics) {
     graphics.drawImage(Assets.dirt, 0, 0, null);     
    } 
}
