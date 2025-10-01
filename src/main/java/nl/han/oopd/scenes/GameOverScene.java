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
        var gameOverText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                GAME_OVER_TEXT
        );
        gameOverText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        gameOverText.setFill(Color.DEEPPINK);
        gameOverText.setFont(Font.font(FONT_FAMILY, FontWeight.SEMI_BOLD, FONT_SIZE));
        addEntity(gameOverText);

        var startButton = new StartButton(
                new Coordinate2D((getWidth() / 2) - BUTTON_OFFSET_X, getHeight() / 2),
                georgesFruitJacht
        );
        startButton.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(startButton);

        var quitButton = new QuitButton(
                new Coordinate2D((getWidth() / 2) + BUTTON_OFFSET_X, getHeight() / 2),
                georgesFruitJacht
        );
        quitButton.setAnchorPoint(AnchorPoint.TOP_LEFT);
        addEntity(quitButton);
    }
}
