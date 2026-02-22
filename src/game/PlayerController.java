package game;

import org.jbox2d.common.Vec2;
import city.cs.engine.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener, StepListener {

    private static final float ROTATION_SPEED = 4;
    private static final float THRUST = 2;
    private static final float BOOST = 6;
    private static float stamina = 3000;
    private static float acceleration;

    private final Player player;

    private boolean leftDown = false;
    private boolean rightDown = false;
    private boolean upDown = false;
    private boolean shiftDown = false;

    public PlayerController(Player player, World world) {
        this.player = player;
        world.addStepListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT, KeyEvent.VK_A:
                leftDown = true;
                break;
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D:
                rightDown = true;
                break;
            case KeyEvent.VK_UP, KeyEvent.VK_W:
                upDown = true;
                break;
            case KeyEvent.VK_SHIFT:
                shiftDown = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT, KeyEvent.VK_A:
                leftDown = false;
                break;
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D:
                rightDown = false;
                break;
            case KeyEvent.VK_UP, KeyEvent.VK_W:
                upDown = false;
                break;
            case KeyEvent.VK_SHIFT:
                shiftDown = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void preStep(StepEvent e) {
        // Stops the player from spinning out of control
        player.setAngularVelocity(0);

        if (leftDown) {
            player.rotateDegrees(ROTATION_SPEED);
        }
        if (rightDown) {
            player.rotateDegrees(-ROTATION_SPEED);
        }
        if (upDown) {
            applyThrust();
        } else if (stamina < 3000) {
            stamina += 1;
        }
    }

    @Override
    public void postStep(StepEvent e) {}

    private void applyThrust() {
        if (shiftDown && stamina > 0) {
            acceleration = THRUST + BOOST;
            stamina -= 5;
        } else {
            acceleration = THRUST;
        }
        float angle = player.getAngle();
        float x = (float) Math.cos(angle);
        float y = (float) Math.sin(angle);
        player.applyForce(new Vec2(x * acceleration, y * acceleration));
    }

    public static float getStamina() {
        return stamina;
    }
}