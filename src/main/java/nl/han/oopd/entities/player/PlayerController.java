package nl.han.oopd.entities.player;

import com.github.hanyaeger.api.entities.Direction;
import javafx.scene.input.KeyCode;
import java.util.Set;

public class PlayerController {

    private static final int MOVE_SPEED = 3;
    private static final int FRAME_LEFT = 0;
    private static final int FRAME_RIGHT = 1;

    private final George george;

    public PlayerController(final George george) {
        this.george = george;
    }

    public void handleInput(final Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            moveLeft();
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            moveRight();
        } else {
            stopMoving();
        }
    }

    private void moveLeft() {
        george.setCurrentFrameIndex(FRAME_LEFT);
        george.setMotion(MOVE_SPEED, Direction.LEFT);
    }

    private void moveRight() {
        george.setCurrentFrameIndex(FRAME_RIGHT);
        george.setMotion(MOVE_SPEED, Direction.RIGHT);
    }

    private void stopMoving() {
        george.setSpeed(0);
    }
}