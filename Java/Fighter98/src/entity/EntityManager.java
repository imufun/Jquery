package entity;

import com.oracle.jrockit.jfr.FlightRecorder;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import tilegame.Handler;

public class EntityManager {

    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    
    
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if (a.getY() + a.getHeight() < b.getY() + b.getHeight()) {
                return -1;
            }
            return 1;
        }
    };

    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<>();
    }

    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.tick();
            //if player hurt then remove
            if (!e.isActive()) {
               entities.remove(e);
            }
        }
        player.tick();
        //entities.sort(renderSorter);
    }

    public void rendder(Graphics graphics) {
        for (Entity e : entities) {
            e.render(graphics);
        }
        player.render(graphics);
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
