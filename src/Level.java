import java.util.ArrayList;

public class Level {
    // screen width is 1422
    // screen height is 800

    public static void Level1(Game game, Player player){

        ArrayList<Platform> platforms = new ArrayList<Platform>();
        platforms.add(new SolidPlatform(game, 0, 700, 1422, 100, new int[] {10, 255, 30 }));
        platforms.add(new SemisolidPlatform(game, 200, 500, 100, 20, new int[] {10, 40, 255 }));
        platforms.add(new SolidPlatform(game, 200, 600, 100, 20, new int[]{30, 200, 200}));
        platforms.add(new SolidPlatform(game, 350, 500, 100, 20, new int[]{30, 200, 200}));
        platforms.add(new SolidPlatform(game, 430, 450, 20, 70, new int[]{30, 200, 200}));
        platforms.add(new SolidPlatform(game, 430, 400, 20, 50, new int[]{30, 200, 200}));
        platforms.add(new Spike(game, 600, 600, 20, 100, new int[]{0,0,0}, 3));
        platforms.add(new Spike(game, 550, 600, 50, 20, new int[]{0,0,0}, 1));
        platforms.add(new Bouncepad(game, 1400, 700, 22, 10, new int[]{200, 50, 200}));
        platforms.add(new SolidPlatform(game, 1800, 700, 1000, 100));
        platforms.add(new SolidPlatform(game, 100, 180, 100, 20));
        platforms.add(new Bouncepad(game, 200, 400, 40, 20, new int[]{200, 50, 200}));




        game.setPlatforms(platforms);
        game.setLevelDimension(new int[] {0,0, 2100, -300, game.HEIGHT});
        player.setSpawnPosition(new int[] {50, 500});
        player.die();
        // Value 5 is for kill plain at the bottom of the screen. Sees use in player.update
    }

    public static void Level2(Game game, Player player){

        ArrayList<Platform> platforms = new ArrayList<>();
        platforms.add(new SolidPlatform(game, -1000, 1000, 2000, 100));
        platforms.add(new SolidPlatform(game, -1000, 700, 1422, 100, new int[] {10, 255, 30 }));
        platforms.add(new Bouncepad(game,0,700,10,10));
        platforms.add(new Bouncepad(game,0,500,10,10));
        platforms.add(new Bouncepad(game,0,300,10,10));

        game.setPlatforms(platforms);
        game.setLevelDimension(new int[] {-1000, 500, 2100, -300, 2000});
        player.setSpawnPosition(new int[] {50, 500});
        player.die();
    }

}
