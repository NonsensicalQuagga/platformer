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
    private double friction = 1.5;
    private int[] spawnPosition = new int[] {50, 500};
    private int[] color = new int[] {255, 50, 50};
    private short dashCharge;


    public Player(Game game){
        this.game = game;
    } //creates an instance of player

    public void updatePlayerSpeed(ArrayList keys, int[] levelDimension){
        if (speedY <= maxFallingSpeed)speedY += gravity;
        if (keys.contains(KeyEvent.VK_A) || keys.contains(KeyEvent.VK_D)){
            if(keys.contains(KeyEvent.VK_A)){
                if(speedX > -speedCap){
                    speedX-=movementSpeed;
                    if (speedX < -speedCap) speedX = -speedCap;
                }
                if (x <= levelDimension[0]){
                    speedX = 0;
                    x = levelDimension[0];
                }
            }else if (speedX < 0 && speedX + movementSpeed <= 0) speedX += friction;
            if(keys.contains(KeyEvent.VK_D)){
                if(speedX < speedCap){
                    speedX+=movementSpeed;
                    if (speedX > speedCap) speedX = speedCap;
                }
                if (x + width>= levelDimension[2]){
                    speedX = 0;
                    x = levelDimension[2] - width;
                }
            } else if (speedX > 0 && speedX - movementSpeed >= 0) speedX-= friction;


        } else if (speedX > 0 && speedX - movementSpeed >= 0) speedX-= friction;
        else if (speedX < 0 && speedX + movementSpeed <= 0) speedX += friction;
        else speedX = 0;
        if (keys.contains(KeyEvent.VK_SPACE) && grounded) {
            speedY = jumpSpeed;
            grounded = false;

        }
        if (keys.contains(KeyEvent.VK_SPACE) && !(keys.contains(KeyEvent.VK_S))){
            holdJump++;
            if(holdJump > 1){
                holdJump = 0;
                speedY -= gravity;
            }
        }else holdJump = 0;


       if (coyoteFrames <= 0)grounded = false;
            else coyoteFrames--;

       if (keys.contains(KeyEvent.VK_SHIFT)){

       }

       if (y > levelDimension[4]) die();
    }// everything about how the player's acceleration changes
    //really should be broken up into different functions

    public void die(){
        x = spawnPosition[0];
        y = spawnPosition[1];
        speedX = 0;
        speedY = 0;
    } // spawns the player at the set spawnpoint


    public void updatePlayer(){
        x+=speedX;
        y+=speedY;
    } //changes where player is
    public void drawPlayer(Graphics g){
        g.setColor(new Color(color[0], color[1], color[2]));
        g.fillRect((int)Math.floor(x),(int)Math.floor(y), width, height);
    }
    public double[] getPosition(){
        return new double[] {x, y, width ,height};
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
    public void setPositionY(double newPosition){
        y = newPosition;
    }
    public void setPositionX(double newPosition){
        x = newPosition;
    }
    public void setSpawnPosition(int[] newSpawnPosition){
        spawnPosition = newSpawnPosition;
    }

    //bellow are redundant code from ideas that didn't get implemented
    /*
    public void setFriction(int friction){
        this.friction = friction;
    }
    public void resetFriction(){
        friction = 1.5;
    }
    public void dash(ArrayList keys){}*/
}
