import java.awt.*;
import java.util.ArrayList;

public class Game extends Engine {
    private Player player = new Player(this);
    private ArrayList<SemisolidPlatform> semisolidPlatforms = new ArrayList<SemisolidPlatform>();
    private ArrayList<SolidPlatform> solidPlatforms = new ArrayList<SolidPlatform>();
    private ArrayList<Spike> spikes = new ArrayList<Spike>();
    public Game(int w, int h)  {
        super(w,h);
    semisolidPlatforms.add(new SemisolidPlatform(this, 0, HEIGHT - HEIGHT/8, WIDTH, HEIGHT, new int[] {10, 255, 30 }));
    semisolidPlatforms.add(new SemisolidPlatform(this, 200, 500, 100, 20, new int[] {10, 40, 255 }));
    solidPlatforms.add(new SolidPlatform(this, 200, 600, 100, 20, new int[]{30, 200, 200}));
    solidPlatforms.add(new SolidPlatform(this, 350, 500, 100, 20, new int[]{30, 200, 200}));
    solidPlatforms.add(new SolidPlatform(this, 430, 450, 20, 70, new int[]{30, 200, 200}));
    solidPlatforms.add(new SolidPlatform(this, 430, 400, 20, 50, new int[]{30, 200, 200}));
    spikes.add(new Spike(this, 600, 600, 20, 100, new int[]{0,0,0}, 3));
    spikes.add(new Spike(this, 550, 600, 50, 20, new int[]{0,0,0}, 1));
    }

    public void update() {

        player.updatePlayerSpeed(keys);
        for(SemisolidPlatform i : semisolidPlatforms){
            i.platformCollision(this.player);
        }
        for (SolidPlatform i : solidPlatforms){
            i.platformCollision(this.player);
        }
        for (Spike i : spikes){
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
        for (Spike i : spikes){
            i.drawPlatform(g);
        }
        player.drawPlayer(g);
        }

}


