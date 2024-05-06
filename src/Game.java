import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game extends Engine {
    private Player player = new Player(this);
    private ArrayList<Platform> platforms = new ArrayList<Platform>();
    private Camera camera = new Camera(this);
    public int[] levelDimension;

    public Game(int w, int h)  {
        super(w,h);
        Level.levelSelect(this, player, 1);
    }

    public void update() {
        if (keys.contains(KeyEvent.VK_2)) Level.levelSelect(this,player, 2 );
        if (keys.contains(KeyEvent.VK_1)) Level.levelSelect(this,player, 1 );

        // Change the level

        player.updatePlayerSpeed(keys, levelDimension);
        //changes player acceleration values

        for(Platform i : platforms){
            i.platformCollision(this.player);
        } //checks collision between player and all platforms

        player.updatePlayer();
        //applies acceleration values to player's current position

        camera.update(player, levelDimension);
        //moves camera
        }

    public void draw(Graphics g){
        g.clearRect(0, 0, getWidth(), getHeight());
        //clears the screen
        camera.apply(g);
        //applies camera context change

        for(Platform i : platforms){
            i.drawPlatform(g);
            }

        player.drawPlayer(g);
        g.translate(0,0);
        }

    public void setPlatforms(ArrayList<Platform> newPlatforms ){
        platforms = newPlatforms;
    }
    //Removes all current platforms and exchanges them with new ones.

    public void setLevelDimension(int[] newLevel){
        levelDimension = newLevel;
    }
    //Sets the dimensions for the level. Restricts how the player and the camera can move.

}


