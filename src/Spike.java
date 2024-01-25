public class Spike extends Platform {
    public int collisionType = 1;

    public Spike(Game game, int x, int y, int width, int height, int[] color) {
        super(game, x, y, width, height, color);

    }

    public Spike(Game game, int x, int y, int width, int height, int[] color, int collisionType) {
        super(game, x, y, width, height, color);
        this.collisionType = collisionType;
    }


    public Spike(Game game, int x, int y, int width, int height) {
        super(game, x, y, width, height);

    }

    public Spike(Game game, int x, int y, int width, int height, int collisionType) {
        super(game, x, y, width, height);
        this.collisionType = collisionType;
    }

    public void platformCollision(Player player) {
        int[] platformPosition = this.getPlatformCollision();
        int[] playerPosition = player.getPosition();
        int playerSpeedX = player.getSpeedX();
        int playerSpeedY = player.getSpeedY();
        if (playerPosition[0] <= platformPosition[0] + platformPosition[2] &&
                playerPosition[0] + playerPosition[2] >= platformPosition[0] &&
                playerPosition[1] <= platformPosition[1] + platformPosition[3] &&
                playerPosition[1] + playerPosition[3] >= platformPosition[1]) {
            if (collisionType == 1) {
                player.die();
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
    }
}