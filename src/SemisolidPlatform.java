public class SemisolidPlatform extends Platform {
    public SemisolidPlatform (Game game, int x, int y, int width, int height, int[] color){
        super(game, x, y, width, height, color);

    }
    public SemisolidPlatform (Game game, int x, int y, int width, int height){
        super(game, x, y, width, height);

    }

    public void platformCollision(Player player){
        int[] platformPosition = this.getPlatformCollision();
        int[] playerPosition = player.getPosition();
        int playerSpeedX = player.getSpeedX();
        int playerSpeedY = player.getSpeedY();
        if ( playerPosition[0] + playerSpeedX <= platformPosition[0] + platformPosition[2] &&
                playerPosition[0] + playerPosition[2] + playerSpeedX >= platformPosition[0] &&
                playerPosition[1] + playerSpeedY <= platformPosition[1] + platformPosition[3] &&
                playerPosition[1] + playerPosition[3] + playerSpeedY >= platformPosition[1]) {
            boolean collidingTop = (playerPosition[1] + playerPosition[3] <= platformPosition[1] && playerPosition[1] + playerPosition[3] + playerSpeedY >= platformPosition[1]);
            if (collidingTop){
                player.setSpeedY(0);
                player.setGrounded(true);
                player.setPositionY(platformPosition[1] - playerPosition[3]);
            }


        }
    }
}
