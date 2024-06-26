import java.util.ArrayList;

public class Level {
    // screen width is 1422
    // screen height is 800

   /* public static void Level1(Game game, Player player){

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
        // Value 5 is for kill plain at the bottom of the screen. Sees use in player.update
        player.setSpawnPosition(new int[] {50, 500});
        player.die();

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
        // Value 5 is for kill plain at the bottom of the screen. Sees use in player.update
        player.setSpawnPosition(new int[] {50, 500});
        player.die();
    }*/
    // old code that's preserved for if i ever find out the better solution

    public static void levelSelect(Game game, Player player, int level){
        if (level == 1){
            ArrayList<Platform> platforms = new ArrayList<Platform>();
            platforms.add(new SolidPlatform(game, 0, 700, 1422, 100, new int[] {10, 255, 30}));
            platforms.add(new SemisolidPlatform(game, 200, 500, 100, 20, new int[] {10, 40, 255}));
            platforms.add(new SolidPlatform(game, 200, 600, 100, 20, new int[]{30, 200, 200}));
            platforms.add(new SolidPlatform(game, 350, 500, 100, 20, new int[]{30, 200, 200}));
            platforms.add(new SolidPlatform(game, 430, 450, 20, 70, new int[]{30, 200, 200}));
            platforms.add(new SolidPlatform(game, 430, 400, 20, 50, new int[]{30, 200, 200}));
            platforms.add(new Spike(game, 600, 600, 20, 100, new int[]{0,0,0}, 3));
            platforms.add(new Spike(game, 550, 600, 50, 20, new int[]{0,0,0}, 1));
            platforms.add(new Bouncepad(game, 1400, 700, 22, 10, new int[]{200, 50, 200}));
            platforms.add(new SolidPlatform(game, 1800, 700, 50, 100, new int[] {10, 255, 30}));
            platforms.add(new SolidPlatform(game, 100, 180, 100, 20, new int[] {30, 200, 200}));
            platforms.add(new Bouncepad(game, 200, 400, 40, 20, new int[]{200, 50, 200}));
            platforms.add(new SolidPlatform(game, 2050, 570, 40, 20, new int[]{30, 200, 200}));
            platforms.add(new Bouncepad(game, 1970, 450, 40, 20, new int[]{200, 50, 200}));
            platforms.add(new Bouncepad(game, 2300, 300, 40, 20, new int[]{200, 50, 200}));
            platforms.add(new SolidPlatform(game, 2700, 200, 100, 20, new int[] {30, 200, 200}));
            platforms.add(new SemisolidPlatform(game, 2770, 70, 2300, 20, new int[] {10, 40, 255}));
            platforms.add(new Bouncepad(game, 3000, 71, 2000, 1, new int[] {10, 40, 255}, -1));
            platforms.add(new SemisolidPlatform(game, 3000, 70, 5, 20, new int[] {30, 200, 200}));
            platforms.add(new SolidPlatform(game, 3000, 170, 100, 20, new int[] {30, 200, 200}));
            platforms.add(new Bouncepad(game,3250, 310, 40, 20, new int[] {200, 50, 200}, -21));
            platforms.add(new SolidPlatform(game, 3600, 400, 100, 20, new int[] {30, 200, 200}));
            platforms.add(new Spike(game, 3700, 260, 100, 20, new int[]{0,0,0}));
            platforms.add(new SolidPlatform(game, 3800, 400, 100, 20, new int[] {30, 200, 200}));
            platforms.add(new Spike(game, 3900, 260, 100, 20, new int[]{0,0,0}));
            platforms.add(new SolidPlatform(game, 4000, 400, 100, 20, new int[] {30, 200, 200}));
            platforms.add(new Spike(game, 4150, 280, 100, 20, new int[]{0,0,0}));
            platforms.add(new SolidPlatform(game, 4300, 400, 100, 20, new int[] {30, 200, 200}));
            platforms.add(new Goal(game, 4800, 75, 200, 1000,2, new int[]{255, 16, 240}));
            platforms.add(new Checkpoint(game, 3100, 20, 50, 50, new int[]{3110, 20}, new int[]{255, 255, 50}));


            game.setPlatforms(platforms);
            game.setLevelDimension(new int[] {0,0, 5000, -300, game.HEIGHT});
            // Value 5 is for kill plain at the bottom of the screen. Sees use in player.update
            player.setSpawnPosition(new int[] {50, 600});
            player.die();

        } //Entirety of the first level
        if (level == 2){
            ArrayList<Platform> platforms = new ArrayList<>();
            platforms.add(new SolidPlatform(game, -1000, 1000, 2000, 100));
            platforms.add(new SolidPlatform(game, -1000, 700, 1422, 100, new int[] {10, 255, 30 }));
            platforms.add(new Bouncepad(game,0,700,10,10));
            platforms.add(new Bouncepad(game,0,500,10,10));
            platforms.add(new Bouncepad(game,0,300,10,10));
            platforms.add(new Bouncepad(game,0,100,10,10));
            platforms.add(new Bouncepad(game, 400, 1000, 100, 20, new int[]{200, 50, 200}, -30));

            game.setPlatforms(platforms);
            game.setLevelDimension(new int[] {-2000, 500, 2100, -300, 1100});
            // Value 5 is for kill plain at the bottom of the screen. Sees use in player.update
            player.setSpawnPosition(new int[] {50, 500});
            player.die();
        } //Entirety of the first level
    }
}
