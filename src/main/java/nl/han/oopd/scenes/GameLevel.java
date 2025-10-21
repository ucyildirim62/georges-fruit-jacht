package nl.han.oopd.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.han.oopd.GeorgesFruitJacht;
import nl.han.oopd.entities.player.George;
import nl.han.oopd.entities.hud.HealthText;
import nl.han.oopd.entities.hud.FruitCollectedText;
import nl.han.oopd.spawners.FruitSpawner;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {

    private static final String BACKGROUND_IMAGE = "backgrounds/gamelevel.jpg";
    private static final int HUD_HEALTH_Y = 0;
    private static final int HUD_FRUIT_Y = 30;
    private static final int PLAYER_START_X = 0;

    private final GeorgesFruitJacht georgesFruitJacht;

    public GameLevel(GeorgesFruitJacht georgesFruitJacht) {
        this.georgesFruitJacht = georgesFruitJacht;
    }

    @Override
    public void setupScene() {
        setBackgroundImage(BACKGROUND_IMAGE);
    }

    @Override
    public void setupEntities() {
        final var healthText = new HealthText(new Coordinate2D(0, HUD_HEALTH_Y));
        addEntity(healthText);

        final var fruitCollectedText = new FruitCollectedText(new Coordinate2D(0, HUD_FRUIT_Y));
        addEntity(fruitCollectedText);

        final double startY = getHeight();
        addEntity(new George(
                new Coordinate2D(PLAYER_START_X, startY),
                healthText,
                fruitCollectedText,
                georgesFruitJacht
        ));
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new FruitSpawner(getWidth()));
    }
}
