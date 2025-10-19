package nl.han.oopd.entities.player;

import com.github.hanyaeger.api.entities.Direction;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class PlayerController {

    private static final int MOVE_SPEED = 3;
    private final George george;

    public PlayerController(George george) {
        this.george = george;
    }

    public void handleInput(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            george.setCurrentFrameIndex(0);
            george.setMotion(MOVE_SPEED, Direction.LEFT);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            george.setCurrentFrameIndex(1);
            george.setMotion(MOVE_SPEED, Direction.RIGHT);
        } else {
            // stop movement als geen toetsen ingedrukt zijn
            george.setSpeed(0);
        }
    }
}
