package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Coin extends StaticBody {

    private static final Shape booksShape = new CircleShape(0.5f);

    public Coin(World world) {
        super(world,booksShape);
        super.setFillColor(new Color(243, 199, 13));
        super.setLineColor(new Color(243, 199, 13));
    }

    public void respawnCoin() {

        float x = -15 + (float)Math.random() * 29;
        float y = -15 + (float)Math.random() * 29;

        this.setPosition(new Vec2(x, y));
    }
}
