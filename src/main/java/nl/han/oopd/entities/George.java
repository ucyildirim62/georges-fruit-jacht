package nl.han.oopd.entities;

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
import nl.han.oopd.entities.map.Fruit;

import java.util.List;
import java.util.Set;

public class George extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, KeyListener, Collided, Collider, Newtonian {

    private GeorgesFruitJacht georgesFruitJacht;
    private final HealthText healthText;
    private final FruitCollectedText fruitCollectedText;
    private int health = 0;
    private int fruitCollected = 0;

    public George(final Coordinate2D location, final HealthText healthText, final FruitCollectedText fruitCollectedText, final GeorgesFruitJacht georgesFruitJacht, FruitCollectedText fruitCollectedText1) {
        super("sprites/george.jpg", location, new Size(20, 40), 1, 2);
        this.healthText = healthText;
        this.georgesFruitJacht = georgesFruitJacht;
        this.fruitCollectedText = fruitCollectedText;
        healthText.setText(health);
        fruitCollectedText.setText(fruitCollected);

        setGravityConstant(0.005);
        setFrictionConstant(0.04);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        var fruitCollision = false;

        for(Collider collider : collidingObject){
            if(collider instanceof Fruit){
                fruitCollision = true;
            }
        }
        if(fruitCollision){
            fruitCollectedText.setText(++fruitCollected);
            remove();
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        setSpeed(0);

        switch (sceneBorder) {
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setCurrentFrameIndex(0);
            setMotion(3, Direction.LEFT);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setCurrentFrameIndex(1);
            setMotion(3, Direction.RIGHT);
        }
    }
}
