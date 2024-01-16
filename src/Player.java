import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player {
    private Game game;
    private int width = 32;
    private int height = 64 ;
    private int x = 50;
    private int y = 100;
    private int speedX = 2;
    private int speedY = 2;

    public Player(Game game){
        this.game = game;


    }

    public void updatePlayer(ArrayList keys){
        if(keys.contains(KeyEvent.VK_A) && x > 0){
            x-=speedX;
        }
        if(keys.contains(KeyEvent.VK_D) && x + width < game.WIDTH){
            x+=speedX;
        }
        if(keys.contains(KeyEvent.VK_W) && y > 0){
            y-=speedY;
        }
        if(keys.contains(KeyEvent.VK_S) && y + height < game.HEIGHT){
            y+=speedY;
        }
    }
    public void drawPlayer(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }

    public int[] getPosition(){
        return new int[]{x, y, width, height};
    }
}
