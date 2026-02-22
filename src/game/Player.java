package game;

import city.cs.engine.*;

public class Player extends DynamicBody {
    private static final Shape playerShape = new PolygonShape(
            0f,1.5f,
            0.5f,0f,
            -0.5f,0f);

    private int points;

    private int lives;

    public Player(World world) {
        super(world, playerShape);

        super.setGravityScale(0);

        points = 0;
        lives = 3;
    }
}
