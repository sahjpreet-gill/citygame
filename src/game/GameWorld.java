package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World{

    private Player player;

    private Coin coin;

    public GameWorld() {
        // Adding the player into the world
        this.player = new Player(this);
        this.player.setPosition(new Vec2(0,0));

        this.coin = new Coin(this);
        this.coin.respawnCoin();

        coin.addCollisionListener(new CoinPickup(coin));
    }

    public Player getPlayer() {
        return this.player;
    }
}
