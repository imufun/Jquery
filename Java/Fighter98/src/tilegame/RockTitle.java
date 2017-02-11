 
package tilegame;
 
import fighter98.gfx.Assets;
import java.awt.image.BufferedImage;

public class RockTitle extends Tile{

    public RockTitle( int id) {
        super(Assets.stone, id);
    }
    
    @Override
    public boolean isSolid(){
        return  true;
    }
    
}
