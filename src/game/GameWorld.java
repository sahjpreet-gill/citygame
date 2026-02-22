package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World{

    private Player player;

    private Coin coin1;
    private Coin coin2;

    public GameWorld() {
        // Adding the player into the world
        this.player = new Player(this);
        this.player.setPosition(new Vec2(0,0));

        this.coin1 = new Coin(this);
        this.coin1.respawnCoin();

        this.coin2 = new Coin(this);
        this.coin2.respawnCoin();

        coin1.addCollisionListener(new CoinPickup(coin1));
        coin2.addCollisionListener(new CoinPickup(coin2));
    }

    public Player getPlayer() {
        return this.player;
    }
}
