import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Game extends Engine {

    Engine e;
    private Player player = new Player(this);
    private ArrayList<SemisolidPlatform> semisolidPlatforms = new ArrayList<SemisolidPlatform>();
    private ArrayList<SolidPlatform> solidPlatforms = new ArrayList<SolidPlatform>();
    public Game(int w, int h)  {
        super(w,h);
    semisolidPlatforms.add(new SemisolidPlatform(this, 0, HEIGHT - HEIGHT/8, WIDTH, HEIGHT, new int[] {10, 255, 30 }));
    semisolidPlatforms.add(new SemisolidPlatform(this, 200, 550, 100, 5, new int[] {10, 40, 255 }));
    solidPlatforms.add(new SolidPlatform(this, 200, 620, 100, 5, new int[]{30, 200, 200}));
    }

    public void update() {
        int[] playerPosition = player.getPosition();

        player.updatePlayerSpeed(keys);
        for(SemisolidPlatform i : semisolidPlatforms){
            i.platformCollision(this.player);
        }
        for (SolidPlatform i : solidPlatforms){
            i.platformCollision(this.player);
        }
        player.updatePlayer();

        }

    public void draw(Graphics g){
        g.clearRect(0, 0, getWidth(), getHeight());
        for(Platform i : semisolidPlatforms){
            i.drawPlatform(g);
            }
        for (SolidPlatform i : solidPlatforms){
            i.drawPlatform(g);
        }
        player.drawPlayer(g);
        }

}


