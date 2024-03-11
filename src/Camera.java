import java.awt.*;

public class Camera {
    private Game game;
    private int minX = 0;
    private int minY = 0;
    private int maxX;
    private int maxY;
    private int width;
    private int height;
    private double x;
    private double y;
    private double lerpFactor = 0.1;
    public Camera(Game game){
        this.game = game;
        width = game.WIDTH;
        height = game.HEIGHT;

    }
    public void update(Player player, int[] levelDimension){
        double halfWidth = width/2;
        double halfHeight = height/2;
        double[] playerPosition = player.getPosition();
        minX = levelDimension[0];
        minY = levelDimension[1];
        maxX = levelDimension[2];
        maxY = levelDimension[3];
        double targetX = Math.min(Math.max(playerPosition[0] - halfWidth, minX), (maxX - width + 9));
        double targetY = Math.min(Math.max( playerPosition[1] - halfHeight, maxY), minY);

        x += Math.floor((targetX - x) * lerpFactor);
        y += Math.floor((targetY - y) * lerpFactor);
    }

    public void apply(Graphics g){
        g.translate((int) -x, (int) -y);
    }
}
