package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Coin extends StaticBody {

    private static final Shape booksShape = new CircleShape(0.5f);

    public Coin(World world) {
        super(world,booksShape);
        super.setFillColor(Color.yellow);
        super.setLineColor(Color.yellow);
    }

    public void respawnCoin() {

        float x = -15 + (float)Math.random() * 28;
        float y = -15 + (float)Math.random() * 28;

        this.setPosition(new Vec2(x, y));
    }
}
