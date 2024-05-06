import java.awt.event.KeyEvent;

public class Bouncepad extends Platform {
    Game game;
    int bounceStrength = -15;
    // default strength

    public Bouncepad (Game game, int x, int y, int width, int height, int[] color){
        super(game, x, y, width, height, color);
        this.game = game;
    }//creates a bouncepad with a set color and default strength

    public Bouncepad (Game game, int x, int y, int width, int height){
        super(game, x, y, width, height);
        this.game = game;
    } //creates a bouncepad with default color and strength

    public Bouncepad (Game game, int x, int y, int width, int height, int[] color, int bounceStrength){
        super(game, x, y, width, height, color);
        this.game = game;
        this.bounceStrength = bounceStrength;
    } //creates a bouncepad with a set color and strength

    public void platformCollision(Player player){
        double[] platformPosition = this.getPlatformCollision();
        double[] playerPosition = player.getPosition();
        double playerSpeedX = player.getSpeedX();
        double playerSpeedY = player.getSpeedY();
        if ( playerPosition[0] + playerSpeedX <= platformPosition[0] + platformPosition[2] &&
                playerPosition[0] + playerPosition[2] + playerSpeedX >= platformPosition[0] &&
                playerPosition[1] + playerSpeedY <= platformPosition[1] + platformPosition[3] &&
                playerPosition[1] + playerPosition[3] + playerSpeedY >= platformPosition[1] &&
                playerPosition[1] + playerPosition[3] <= platformPosition[1] &&
                playerPosition[1] + playerPosition[3] + playerSpeedY >= platformPosition[1]) {
            player.setSpeedY(bounceStrength);
            player.setGrounded(false);
            player.setPositionY(platformPosition[1] - playerPosition[3]);
        }
    }// checks if player is colliding with the top with of the platform while falling down
}
