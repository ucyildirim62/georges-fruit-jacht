package nl.han.oopd.entities.hud;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class FruitCollectedText extends BaseHudText {
    private static final Color COLOR = Color.WHITE;
    private static final String LABEL = "Fruit collected: ";

    public FruitCollectedText(Coordinate2D loc) {
        super(loc, LABEL, COLOR);
    }
    public void updateFruitCount(int count) { setValue(count); }
}

