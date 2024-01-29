import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;

public class Player {
    private Game game;
    private int width = 32;
    private int height = 50 ;
    private double x = 50;
    private double y = 500;
    private double movementSpeed = 1;
    private double jumpSpeed = -11.0;
    private double gravity = 1;
    private int maxFallingSpeed = 9;
    private boolean grounded;
    private int coyoteFrames;
    private int holdJump;
    private double speedX = 0;
    private double speedY = 0;
    private int speedCap = 7;
    private int[] spawnPosition = new int[] {50, 500};


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
    public void die(){
        x = spawnPosition[0];
        y = spawnPosition[1];
        speedX = 0;
        speedY = 0;
    }

    public void updatePlayer(){
        x+=speedX;
        y+=speedY;
    }
    public void drawPlayer(Graphics g){
        g.setColor(Color.red);
        g.fillRect((int)Math.floor(x),(int)Math.floor(y), width, height);
    }
    public ArrayList getPosition(){
        ArrayList returns = new ArrayList<>();
        returns.add(x);
        returns.add(y);
        returns.add(width);
        returns.add(height);
        return returns;
    }
    public void setSpeedX(int newSpeed){
       this.speedX = newSpeed;
    }
    public void setSpeedY(int newSpeed){
        this.speedY = newSpeed;
    }
    public double getSpeedX(){
        return speedX;
    }
    public double getSpeedY(){
        return speedY;
    }
    public void setGrounded(boolean change){
        grounded = change;
        coyoteFrames = 3;
        holdJump = 1;
    }
    public void setPositionY(int newPosition){
        y = newPosition;
    }
    public void setPositionX(int newPosition){
        x = newPosition;
    }
    public void setSpawnPosition(int[] newSpawnPosition){
        spawnPosition = newSpawnPosition;
    }
}
