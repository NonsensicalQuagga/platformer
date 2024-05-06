import java.util.ArrayList;

public class Spike extends Platform {
    public int collisionType = 1;
    // Default collision. If player touches the spike the player dies
    public Spike(Game game, int x, int y, int width, int height, int[] color) {
        super(game, x, y, width, height, color);

    } // creates a spike with a set color and default collision type

    public Spike(Game game, int x, int y, int width, int height, int[] color, int collisionType) {
        super(game, x, y, width, height, color);
        this.collisionType = collisionType;
    } // creates a spike with a set color and collision type


    public Spike(Game game, int x, int y, int width, int height) {
        super(game, x, y, width, height);

    } // creates a spike with default color and collision type

    public Spike(Game game, int x, int y, int width, int height, int collisionType) {
        super(game, x, y, width, height);
        this.collisionType = collisionType;
    } // creates a spike with a set color and collision type

    public void platformCollision(Player player) {
        double[] platformPosition = this.getPlatformCollision();
        double[] playerPosition = player.getPosition();
        double playerSpeedX = player.getSpeedX();
        double playerSpeedY = player.getSpeedY();
        if (playerPosition[0] <= platformPosition[0] + platformPosition[2] &&
                playerPosition[0] + playerPosition[2] >= platformPosition[0] &&
                playerPosition[1] <= platformPosition[1] + platformPosition[3] &&
                playerPosition[1] + playerPosition[3] >= platformPosition[1]) {
            if (collisionType == 1) {
                player.die();
                // if the player collides with the spike it dies
            } else {

                boolean collidingTop = (playerPosition[1] + playerPosition[3] <= platformPosition[1] && playerPosition[1] + playerPosition[3] + playerSpeedY >= platformPosition[1]);
                boolean collidingBot = (playerPosition[1] >= platformPosition[1] + platformPosition[3] && playerPosition[1] + playerSpeedY <= platformPosition[1] + platformPosition[3]);
                boolean collidingLeft = (playerPosition[0] + playerPosition[2] <= platformPosition[0] && playerPosition[0] + playerPosition[2] + playerSpeedX >= platformPosition[0]);
                boolean collidingRight = (playerPosition[0] >= platformPosition[0] + platformPosition[2] && playerPosition[0] + playerSpeedX <= platformPosition[0] + platformPosition[2]);

                if (collisionType == 2 && ((collidingRight || collidingTop || collidingBot) || playerSpeedX <= 0)) {
                    // no collision if player moves right through the block
                    player.die();
                }
                if (collisionType == 3 && ((collidingLeft || collidingTop || collidingBot) || playerSpeedX >= 0)) {
                    // no collision if player moves left through the block
                    player.die();
                }
                if (collisionType == 4 && ((collidingLeft || collidingTop || collidingRight) || playerSpeedY >= 0)) {
                    // no collision if player comes from bellow the block
                    player.die();
                }
            }
        }
    }// checks if player is colliding with the spike
}