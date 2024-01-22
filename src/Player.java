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
    private int jumpSpeed = -11;
    private int gravity = 1;
    private int maxFallingSpeed = 10;
    private boolean grounded;
    private int coyoteFrames;
    private int holdJump;
    private int speedX = 0;
    private int speedY = 0;
    private int speedCap = 7;


    public Player(Game game){
        this.game = game;


    }

    public void updatePlayerSpeed(ArrayList keys){
        if (keys.contains(KeyEvent.VK_A) || keys.contains(KeyEvent.VK_D)){
            if(keys.contains(KeyEvent.VK_A)){
                if(speedX > -speedCap) speedX-=movementSpeed;
                if (x <= 0){
                    speedX = 0;
                    x = 0;
                }
            }
            if(keys.contains(KeyEvent.VK_D)){
                if(speedX < speedCap) speedX+=movementSpeed;
                if (x + width>= game.WIDTH){
                    speedX = 0;
                    x = game.WIDTH - width;
                }
            }
        } else if (speedX > 0 && speedX - movementSpeed >= 0) speedX-= movementSpeed;
        else if (speedX < 0 && speedX + movementSpeed <= 0) speedX += movementSpeed;
        else speedX = 0;
        if (keys.contains(KeyEvent.VK_SPACE) && grounded) {
            speedY = jumpSpeed;
            grounded = false;

        }
        if (keys.contains(KeyEvent.VK_SPACE) ){
            holdJump++;
            if(holdJump > 1){
                holdJump = 0;
                speedY -= gravity;
            }
        }else holdJump = 0;
        if (speedY <= maxFallingSpeed)speedY += gravity;

       if (coyoteFrames <= 0)grounded = false;
            else coyoteFrames--;
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
        return speedX;
    }
    public int getSpeedY(){
        return speedY;
    }
    public void setGrounded(boolean change){
        grounded = change;
        coyoteFrames = 3;
    }
    public void setPositionY(int newPosition){
        y = newPosition;
    }
    public void setPositionX(int newPosition){
        x = newPosition;
    }

}
