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
import nl.han.oopd.entities.buttons.QuitButton;

public class GameOverScene extends StaticScene {

    private static final String BACKGROUND_IMAGE = "backgrounds/gameoverscene.jpg";
    private static final String GAME_OVER_TEXT = "Game Over";
    private static final String FONT_FAMILY = "Roboto";
    private static final int FONT_SIZE = 80;
    private static final int BUTTON_OFFSET_X = 20;

    private final GeorgesFruitJacht georgesFruitJacht;

    public GameOverScene(GeorgesFruitJacht georgesFruitJacht) {
        this.georgesFruitJacht = georgesFruitJacht;
    }

    @Override
    public void setupScene() {
        setBackgroundImage(BACKGROUND_IMAGE);
    }

    @Override
    public void setupEntities() {
        final double centerX = getWidth() / 2;
        final double centerY = getHeight() / 2;

        addEntity(createCenteredTitle(centerX, centerY));

        var startButton = new StartButton(new Coordinate2D(centerX - BUTTON_OFFSET_X, centerY), georgesFruitJacht);
        startButton.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(startButton);

        var quitButton = new QuitButton(new Coordinate2D(centerX + BUTTON_OFFSET_X, centerY), georgesFruitJacht);
        quitButton.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(quitButton);
    }

    private TextEntity createCenteredTitle(double centerX, double centerY) {
        var t = new TextEntity(new Coordinate2D(centerX, centerY), GameOverScene.GAME_OVER_TEXT);
        t.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        t.setFill(Color.DEEPPINK);
        t.setFont(Font.font(FONT_FAMILY, FontWeight.SEMI_BOLD, FONT_SIZE));
        return t;
    }
}
