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

    private static final String BACKGROUND_IMAGE = "backgrounds/titlescene.jpg";
    private static final String TITLE_TEXT = "George's Fruit Jacht";
    private static final String TITLE_FONT = "Roboto";
    private static final int TITLE_FONT_SIZE = 80;

    private final GeorgesFruitJacht georgesFruitJacht;

    public TitleScene(GeorgesFruitJacht georgesFruitJacht) {
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

        var startButton = new StartButton(new Coordinate2D(centerX, centerY), georgesFruitJacht);
        startButton.setAnchorPoint(AnchorPoint.TOP_CENTER);
        addEntity(startButton);
    }

    private TextEntity createCenteredTitle(double centerX, double centerY) {
        var title = new TextEntity(new Coordinate2D(centerX, centerY), TitleScene.TITLE_TEXT);
        title.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        title.setFill(Color.WHITE);
        title.setFont(Font.font(TITLE_FONT, FontWeight.SEMI_BOLD, TITLE_FONT_SIZE));
        return title;
    }
}
