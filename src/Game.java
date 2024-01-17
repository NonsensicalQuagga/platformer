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

        player.updatePlayerSpeed(keys);
        for(Platform i : platforms){
            platformCollision(playerPosition, i);

        }
        player.updatePlayer();

        }

    public void draw(Graphics g){
        g.clearRect(0, 0, getWidth(), getHeight());
        for(Platform i : platforms){
            i.drawPlatform(g);
            }

        player.drawPlayer(g);
        }

    public void platformCollision(int[] player, Platform platform){
        int[] platformPosition = platform.getPlatformCollision();
        if (player[1] + player[3] + this.player.getSpeedY() >= platformPosition[1] && this.player.getSpeedY() >= 0){
            this.player.setSpeedY(0);
            this.player.setGrounded(true);
            this.player.setPositionY(platformPosition[1]- player[3]);
        }
    }
}


