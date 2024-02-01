import java.awt.*;
import java.util.ArrayList;

public class Game extends Engine {
    private Player player = new Player(this);
    private ArrayList<Platform> platforms = new ArrayList<Platform>();
    private Camera camera = new Camera(this);
    public Game(int w, int h)  {
        super(w,h);
    platforms.add(new SemisolidPlatform(this, 0, HEIGHT - HEIGHT/8, WIDTH, HEIGHT, new int[] {10, 255, 30 }));
    platforms.add(new SemisolidPlatform(this, 200, 500, 100, 20, new int[] {10, 40, 255 }));
    platforms.add(new SolidPlatform(this, 200, 600, 100, 20, new int[]{30, 200, 200}));
    platforms.add(new SolidPlatform(this, 350, 500, 100, 20, new int[]{30, 200, 200}));
    platforms.add(new SolidPlatform(this, 430, 450, 20, 70, new int[]{30, 200, 200}));
    platforms.add(new SolidPlatform(this, 430, 400, 20, 50, new int[]{30, 200, 200}));
    platforms.add(new Spike(this, 600, 600, 20, 100, new int[]{0,0,0}, 3));
    platforms.add(new Spike(this, 550, 600, 50, 20, new int[]{0,0,0}, 1));
    }

    public void update() {

        player.updatePlayerSpeed(keys);
        for(Platform i : platforms){
            i.platformCollision(this.player);
        }

        player.updatePlayer();
        camera.update(player);
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

}


