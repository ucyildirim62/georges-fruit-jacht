package nl.han.oopd.scenes;

import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.Scene;
import nl.han.oopd.GeorgesFruitJacht;

public class TitleScene extends StaticScene {

    private GeorgesFruitJacht georgesFruitJacht; {this.georgesFruitJacht = georgesFruitJacht;}

    public TitleScene(GeorgesFruitJacht georgesFruitJacht) {}

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/titlescreen.jpg");

    }

    @Override
    public void setupEntities() {

    }
}
