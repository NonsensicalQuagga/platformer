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
            platformCollision(this.player, i);

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

    public void platformCollision(Player player, Platform platform){
        int[] platformPosition = platform.getPlatformCollision();
        int[] playerPosition = player.getPosition();
        int playerSpeedX = player.getSpeedX();
        int playerSpeedY = player.getSpeedY();
             if ( playerPosition[0] + playerSpeedX <= platformPosition[0] + platformPosition[2] &&
                     playerPosition[0] + playerPosition[2] + playerSpeedX >= platformPosition[0] &&
                     playerPosition[1] + playerSpeedY <= platformPosition[1] + platformPosition[3] &&
                     playerPosition[1] + playerPosition[3] + playerSpeedY >= platformPosition[1]) {
            if (playerSpeedY > 0){
            player.setSpeedY(0);
            player.setGrounded(true);
            player.setPositionY(platformPosition[1] - playerPosition[3]);
            }


        }
    }
}


