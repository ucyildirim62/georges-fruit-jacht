package nl.han.oopd.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.oopd.GeorgesFruitJacht;
import nl.han.oopd.entities.buttons.StartButton;

public class TitleScene extends StaticScene {

    private GeorgesFruitJacht georgesFruitJacht;

    public TitleScene(GeorgesFruitJacht georgesFruitJacht) {this.georgesFruitJacht = georgesFruitJacht;}

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/titlescene.jpg");

    }

    @Override
    public void setupEntities() {
    var georgesFruitJachtText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 2), "Georges fruit jacht");
    georgesFruitJachtText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
    georgesFruitJachtText.setFill(Color.WHITE);
    georgesFruitJachtText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
    addEntity(georgesFruitJachtText);

    var playGameText = new StartButton(new Coordinate2D(getWidth() / 2, getHeight() /2) , georgesFruitJacht);
    playGameText.setAnchorPoint(AnchorPoint.TOP_CENTER);
    addEntity(playGameText);
    }
}
