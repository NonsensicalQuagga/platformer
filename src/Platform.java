import java.awt.*;

public class Platform {

    private int x;
    private int y;
    private int width;
    private int height;
    private Game game;
    private int[] color;

    public Platform(Game game, int x, int y, int width, int height){
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public Platform(Game game, int x, int y, int width, int height, int[] color){
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void drawPlatform(Graphics g){
        if(color.length > 3){
        g.setColor(new Color(color[0], color[1], color[2]));
        } else g.setColor(Color.green);
        g.fillRect(x, y, width, height);
    }

    public int[] getPlatformCollision(){
        return new int[] {x, y, width, height};
    }
}
