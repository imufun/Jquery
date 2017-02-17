package tilegame;

import fighter98.Game;
import fighter98.gfx.GameCamera;
import input.KeyManager;
import world.World;

public class Handler {

    private Game game;
    private World world;
    

    public Handler(Game game) {
        this.game = game;
    }

    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }

    public KeyManager geKeyManager() {
        return game.geKeyManager();
    }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    
}
