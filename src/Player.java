import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;

public class Player {
    private Game game;
    private int width = 32;
    private int height = 64 ;
    private int x = 50;
    private int y = 100;
    private int movementSpeed = 1;
    private int jumpSpeed = 10;
    private int speedX = 0;
    private int speedY = 0;
    private int speedCap = 7;
    private boolean grounded;


    public Player(Game game){
        this.game = game;


    }

    public void updatePlayerSpeed(ArrayList keys){
        if (keys.contains(KeyEvent.VK_A) || keys.contains(KeyEvent.VK_D)){
            if(keys.contains(KeyEvent.VK_A) && x > 0){
                if(speedX > -speedCap) speedX-=movementSpeed;

            }
            if(keys.contains(KeyEvent.VK_D) && x + width < game.WIDTH){
                if(speedX < speedCap) speedX+=movementSpeed;

            }
        } else if (speedX > 0 && (speedX - movementSpeed >= 0)) speedX-= movementSpeed;
        else if (speedX < 0 && (speedX + movementSpeed <= 0)) speedX += movementSpeed;
        else speedX = 0;
       // KeyEvent.VK_SPACE
        //fix permenantly moveing left and right
    }
    public void updatePlayer(){
        x+=speedX;
        y+=speedY;
    }
    public void drawPlayer(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }

    public int[] getPosition(){
        return new int[]{x, y, width, height};
    }

    public void setSpeed(){

    }
}
