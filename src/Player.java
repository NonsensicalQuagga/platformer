import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;

public class Player {
    private Game game;
    private int width = 32;
    private int height = 64 ;
    private int x = 50;
    private int y = 500;
    private int movementSpeed = 1;
    private int jumpSpeed = -15;
    private int gravity = 1;
    private int maxFallingSpeed = 10;
    private boolean grounded;
    private int holdJump;
    private int speedX = 0;
    private int speedY = 0;
    private int speedCap = 7;


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
        if (keys.contains(KeyEvent.VK_SPACE) && grounded) {
            speedY = jumpSpeed;
            grounded = false;

        }
        if (keys.contains(KeyEvent.VK_SPACE) ){
            holdJump++;
            if(holdJump > 2){
                holdJump = 0;
                speedY -= gravity;
            }
        }else holdJump = 0;
        if (speedY <= maxFallingSpeed)speedY += gravity;


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

    public void setSpeedX(int newSpeed){
       this.speedX = newSpeed;
    }
    public void setSpeedY(int newSpeed){
        this.speedY = newSpeed;
    }
    public int getSpeedX(){
        return x;
    }
    public int getSpeedY(){
        return speedY;
    }
    public void setGrounded(boolean change){
        grounded = change;
    }
    public void setPositionY(int newPosition){
        y = newPosition;
    }

}
