import java.awt.*;
import java.util.ArrayList;

public class Game extends Engine {
    private Player player = new Player(this);
    private ArrayList<Platform> platforms = new ArrayList<Platform>();
    private Camera camera = new Camera(this);
    public int[] levelDimension;

    public Game(int w, int h)  {
        super(w,h);
        Level.levelSelect(this, player, 2);
    }

    public void update() {

        player.updatePlayerSpeed(keys, levelDimension);
        for(Platform i : platforms){
            i.platformCollision(this.player);
        }

        player.updatePlayer();
        camera.update(player, levelDimension);
        }

    public void draw(Graphics g){
        g.clearRect(0, 0, getWidth(), getHeight());
        camera.apply(g);

        for(Platform i : platforms){
            i.drawPlatform(g);
            }

        player.drawPlayer(g);
        g.translate(0,0);
        }

    public void setPlatforms(ArrayList<Platform> newPlatforms ){
        platforms = newPlatforms;
    }
    public void setLevelDimension(int[] newLevel){
        levelDimension = newLevel;
    }

}


