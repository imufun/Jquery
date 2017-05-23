
import java.awt.Graphics;


class CircleObject {

    int x=10, y=10;

    public CircleObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics graphics) {
        graphics.drawRect(x, y, x, x);         

    }
}
