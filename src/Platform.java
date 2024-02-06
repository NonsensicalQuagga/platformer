import java.awt.*;

public class Platform {

    private double x;
    private double y;
    private int width;
    private int height;
    private Game game;
    private int[] color = new int[]{255, 200, 200};

    public Platform(Game game, double x, double y, int width, int height){
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public Platform(Game game, double x, double y, int width, int height, int[] color){
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void drawPlatform(Graphics g){
        g.setColor(new Color(color[0], color[1], color[2]));
        g.fillRect((int)Math.floor(x), (int)Math.floor(y), width, height);
    }

    public double[] getPlatformCollision(){
        return new double[] {x, y, width, height};
    }
    public void platformCollision(Player player){
        System.out.println("platform type error");
    }
}
