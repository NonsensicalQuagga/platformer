import java.util.ArrayList;

public class SolidPlatform extends Platform{
    public SolidPlatform (Game game, int x, int y, int width, int height, int[] color){
        super(game, x, y, width, height, color);

    }//creates a solid platform with a set color
    public SolidPlatform (Game game, int x, int y, int width, int height){
        super(game, x, y, width, height);

    }//creates a solid platform with default color

    public void platformCollision(Player player){
        double[] platformPosition = this.getPlatformCollision();
        double[] playerPosition = player.getPosition();
        double playerSpeedX = player.getSpeedX();
        double playerSpeedY = player.getSpeedY();
        if ( playerPosition[0] + playerSpeedX <= platformPosition[0] + platformPosition[2] &&
                playerPosition[0] + playerPosition[2] + playerSpeedX >= platformPosition[0] &&
                playerPosition[1] + playerSpeedY <= platformPosition[1] + platformPosition[3] &&
                playerPosition[1] + playerPosition[3] + playerSpeedY >= platformPosition[1]) {
            boolean collidingTop = (playerPosition[1] + playerPosition[3] <= platformPosition[1] && playerPosition[1] + playerPosition[3] + playerSpeedY >= platformPosition[1]);
            boolean collidingBot = (playerPosition[1] >= platformPosition[1] + platformPosition[3] && playerPosition[1] + playerSpeedY <= platformPosition[1] + platformPosition[3]);
            boolean collidingLeft = (playerPosition[0] + playerPosition[2] <= platformPosition[0] && playerPosition[0] + playerPosition[2] + playerSpeedX >= platformPosition[0]);
            boolean collidingRight = (playerPosition[0] >= platformPosition[0] + platformPosition[2] && playerPosition[0] + playerSpeedX <= platformPosition[0] + platformPosition[2]);
            if (collidingLeft){
                player.setSpeedX(0);
                player.setPositionX(platformPosition[0] - playerPosition[2]);

            } else if (collidingRight){
                player.setSpeedX(0);
                player.setPositionX(platformPosition[0] + platformPosition[2]);
            } else if (collidingTop){
                    player.setSpeedY(0);
            player.setGrounded(true);
            player.setPositionY(platformPosition[1] - playerPosition[3]);
            } else if (collidingBot){
                player.setSpeedY(0);
                player.setPositionY(platformPosition[1] + platformPosition[3]);
            }




        }
    }// checks if the player is colliding with the platform and then where it is colliding from.
    // technically incomplete since intersection with other solid platforms can lead to player being unable to move when it should be able to
}
