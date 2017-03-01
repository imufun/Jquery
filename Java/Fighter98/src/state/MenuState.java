package state;

import fighter98.Game;
import fighter98.gfx.Assets;
import java.awt.Color;
import java.awt.Graphics;
import tilegame.Handler;
import ui.ClickListener;
import ui.UIImageButton;
import ui.UIManager;

public class MenuState extends State {
    
    private UIManager uIManager;
    
    public MenuState(Handler handler) {
        super(handler);
        uIManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uIManager);
        uIManager.addObeject(new UIImageButton(200, 200, 128, 64, Assets.btn_start, new ClickListener() {
            
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().Gamestate);                
            }
        }));
    }
    
    @Override
    public void tick() {
        uIManager.tick();
    }
    
    @Override
    public void render(Graphics graphics) {
        uIManager.render(graphics);
    }
    
}
