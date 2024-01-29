import java.util.ArrayList;

public class SolidPlatform extends Platform{
    public SolidPlatform (Game game, int x, int y, int width, int height, int[] color){
        super(game, x, y, width, height, color);

    }
    public SolidPlatform (Game game, int x, int y, int width, int height){
        super(game, x, y, width, height);

    }

    public void platformCollision(Player player){
        int[] platformPosition = this.getPlatformCollision();
        ArrayList tempPosition = player.getPosition();
        int[] playerPosition = new int[] {(int) Math.floor((double)tempPosition.get(0)) ,(int) Math.floor((double)tempPosition.get(1)),(int) tempPosition.get(2),(int) tempPosition.get(3),};
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
    }
}
