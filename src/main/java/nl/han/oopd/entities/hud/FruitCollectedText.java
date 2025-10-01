package nl.han.oopd.entities.hud;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FruitCollectedText extends TextEntity {

    private static final String FONT_FAMILY = "Roboto";
    private static final int FONT_SIZE = 30;
    private static final Color FONT_COLOR = Color.PINK;
    private static final String LABEL = "Fruit collected: ";

    public FruitCollectedText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(Font.font(FONT_FAMILY, FontWeight.NORMAL, FONT_SIZE));
        setFill(FONT_COLOR);
    }

    public void updateFruitCount(final int fruitCollected) {
        setText(LABEL + fruitCollected);
    }
}
