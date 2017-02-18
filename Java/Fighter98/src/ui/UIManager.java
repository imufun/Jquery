package ui;

import java.util.ArrayList;
import tilegame.Handler;

public class UIManager {

    private Handler handler;
    private ArrayList<UIObject> objects;
    
    public UIManager(Handler handler){
        this.handler = handler;
        objects = new  ArrayList<>();
    }
}
