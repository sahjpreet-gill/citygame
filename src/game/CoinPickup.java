package game;

import city.cs.engine.*;

public class CoinPickup implements CollisionListener {

    private Coin coin;

    public CoinPickup(Coin coin) {
        this.coin = coin;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Player) {
            coin.respawnCoin();
        }
    }

}