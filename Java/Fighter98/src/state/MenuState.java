package state;

import fighter98.Game;
import fighter98.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import tilegame.Handler;

public class MenuState extends State{

    public MenuState(Handler handler) {
     super(handler);
    }     

    @Override
    public void tick() {
        if (handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed()) {
                State.setState(handler.getGame().Gamestate);
        }
    }

    @Override
    public void render(Graphics graphics) { 
        graphics.setColor(Color.RED);
        graphics.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
    }

}
