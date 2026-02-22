package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World{

    private Player player;

    public GameWorld() {
        // Adding the player into the world
        this.player = new Player(this);
        this.player.setPosition(new Vec2(0,0));
    }

    public Player getPlayer() {
        return this.player;
    }
}
