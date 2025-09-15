package nl.han.oopd.scenes;

import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.Scene;
import nl.han.oopd.GeorgesFruitJacht;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer, TileMapContainer {

   private GeorgesFruitJacht georgesFruitJacht;

   public GameLevel(GeorgesFruitJacht georgesFruitJacht) { this.georgesFruitJacht = georgesFruitJacht; }

    @Override
    public void setupEntitySpawners() {
        setBackgroundImage("backgrounds/gamescene,jpg");
    }

    @Override
    public void setupTileMaps() {

    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/gamelevel,jpg");
    }

    @Override
    public void setupEntities() {

    }
}
