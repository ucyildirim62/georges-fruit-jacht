package nl.han.oopd.entities.hud;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public abstract class BaseHudText extends TextEntity {
    protected static final String FONT_FAMILY = "Roboto";
    protected static final int FONT_SIZE = 30;

    private final String label;

    protected BaseHudText(Coordinate2D initialLocation, String label, Color color) {
        super(initialLocation);
        this.label = label;
        setFont(Font.font(FONT_FAMILY, FontWeight.NORMAL, FONT_SIZE));
        setFill(color);
    }

    protected void setValue(int value) {
        setText(label + value);
    }
}
