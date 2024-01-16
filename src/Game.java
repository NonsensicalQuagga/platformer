import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Game extends Engine {

    Engine e;
    private Player player = new Player(this);
    private ArrayList<Platform> platforms = new ArrayList<Platform>();
    public Game(int w, int h)  {
        super(w,h);
    platforms.add(new Platform(this, 0, HEIGHT - HEIGHT/8, WIDTH, HEIGHT, new int[] {10, 255, 30 }));
    }

    public void update() {
        int[] playerPosition = player.getPosition();

        player.updatePlayer(keys);

        }

    public void draw(Graphics g){
        g.clearRect(0, 0, getWidth(), getHeight());

        player.drawPlayer(g);
        for(Platform i : platforms){
            i.drawPlatform(g);
            }
        }

    public void platformCollision(){

    }
}


