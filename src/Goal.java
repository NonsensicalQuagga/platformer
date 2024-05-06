public class Goal extends Platform{
    Game game;
    int nextLevel;
    public Goal (Game game, int x, int y, int width, int height, int nextLevel, int[] color){
        super(game, x, y, width, height, color);
        this.game = game;
        this.nextLevel = nextLevel;
    } // creates a goal with a set color and next level.
    public Goal (Game game, int x, int y, int width, int height, int nextLevel){
        super(game, x, y, width, height);
        this.game = game;
        this.nextLevel = nextLevel;
    } //creates a goal with default color and a set next level

    public void platformCollision(Player player){
        double[] platformPosition = this.getPlatformCollision();
        double[] playerPosition = player.getPosition();
        double playerSpeedX = player.getSpeedX();
        double playerSpeedY = player.getSpeedY();
        if ( playerPosition[0] + playerSpeedX <= platformPosition[0] + platformPosition[2] &&
                playerPosition[0] + playerPosition[2] + playerSpeedX >= platformPosition[0] &&
                playerPosition[1] + playerSpeedY <= platformPosition[1] + platformPosition[3] &&
                playerPosition[1] + playerPosition[3] + playerSpeedY >= platformPosition[1]) {
            Level.levelSelect(game, player, nextLevel);
        }
    } //checks if player is colliding with the goal
}


