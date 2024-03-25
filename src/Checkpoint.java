public class Checkpoint extends Platform {

    private int[] spawnPosition;

    public Checkpoint (Game game, int x, int y, int width, int height, int[] spawnPosition, int[] color){
        super(game, x, y, width, height, color);
        this.spawnPosition = spawnPosition;

    }
    public Checkpoint (Game game, int x, int y, int width, int height, int[] spawnPosition){
        super(game, x, y, width, height);
        this.spawnPosition = spawnPosition;
    }
    public void platformCollision(Player player) {
        double[] platformPosition = this.getPlatformCollision();
        double[] playerPosition = player.getPosition();
        double playerSpeedX = player.getSpeedX();
        double playerSpeedY = player.getSpeedY();
        if (playerPosition[0] + playerSpeedX <= platformPosition[0] + platformPosition[2] &&
                playerPosition[0] + playerPosition[2] + playerSpeedX >= platformPosition[0] &&
                playerPosition[1] + playerSpeedY <= platformPosition[1] + platformPosition[3] &&
                playerPosition[1] + playerPosition[3] + playerSpeedY >= platformPosition[1]) {
            player.setSpawnPosition(spawnPosition);
        }
    }
}
