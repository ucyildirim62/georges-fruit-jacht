package nl.han.oopd.entities.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import nl.han.oopd.GeorgesFruitJacht;
import nl.han.oopd.entities.hud.FruitCollectedText;
import nl.han.oopd.entities.hud.HealthText;
import nl.han.oopd.entities.fruit.FruitEffect;

import java.util.List;
import java.util.Set;

public class George extends DynamicSpriteEntity
        implements Player, Collided, Collider, KeyListener, SceneBorderTouchingWatcher, Newtonian {

    private static final int START_HEALTH = 3;
    private static final double FRICTION = 0.04;
    private static final double EDGE_OFFSET = 1.0;
    private static final double PLAYER_WIDTH = 20;
    private static final double PLAYER_HEIGHT = 40;
    private static final int SPRITE_ROWS = 1;
    private static final int SPRITE_COLUMNS = 2;
    private static final Size SPRITE_SIZE = new Size(PLAYER_WIDTH, PLAYER_HEIGHT);

    private final GeorgesFruitJacht georgesFruitJacht;
    private final HealthText healthText;
    private final FruitCollectedText fruitCollectedText;
    private final PlayerController playerController;

    private int health;
    private int fruitCollected;

    public George(final Coordinate2D location,
                  final HealthText healthText,
                  final FruitCollectedText fruitCollectedText,
                  final GeorgesFruitJacht georgesFruitJacht) {

        super("sprites/george.jpg", location, SPRITE_SIZE, SPRITE_ROWS, SPRITE_COLUMNS);
        this.healthText = healthText;
        this.fruitCollectedText = fruitCollectedText;
        this.georgesFruitJacht = georgesFruitJacht;

        this.health = START_HEALTH;
        this.fruitCollected = 0;
        updateHUD();

        setFrictionConstant(FRICTION);

        this.playerController = new PlayerController(this);
    }

    private void updateHUD() {
        healthText.updateHealth(health);
        fruitCollectedText.updateFruitCount(fruitCollected);
    }

    @Override
    public void increaseFruitCollected() {
        fruitCollected++;
        updateHUD();
    }

    @Override
    public void decreaseHealth() {
        if (--health <= 0) {
            health = 0;
            updateHUD();
            georgesFruitJacht.setActiveScene(GeorgesFruitJacht.GAME_OVER_SCENE);
        } else {
            updateHUD();
        }
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getFruitCollected() {
        return fruitCollected;
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        for (Collider collider : collidingObjects) {
            if (collider instanceof FruitEffect effect) {
                effect.applyEffect(this);
            }
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        setSpeed(0);
        switch (sceneBorder) {
            case TOP -> setAnchorLocationY(EDGE_OFFSET);
            case BOTTOM -> setAnchorLocationY(getSceneHeight() - getHeight() - EDGE_OFFSET);
            case LEFT -> setAnchorLocationX(EDGE_OFFSET);
            case RIGHT -> setAnchorLocationX(getSceneWidth() - getWidth() - EDGE_OFFSET);
            default -> { }
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        playerController.handleInput(pressedKeys);
    }
}
