import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class Game {

    public Game() {
        World world = new World();

        Shape playerShape = new PolygonShape(0,1.5f, 0.5f,0, -0.5f,0);
        DynamicBody player = new DynamicBody(world, playerShape);
        player.setPosition(new Vec2(0, 0));


        UserView view = new UserView(world, 600, 600);
        view.setGridResolution(1);

        final JFrame frame = new JFrame("Game");
        frame.add(view);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        world.start();


    }



    public static void main(String[] args) {
        new Game();
    }
}