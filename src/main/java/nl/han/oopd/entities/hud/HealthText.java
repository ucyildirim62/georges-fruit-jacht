package nl.han.oopd.entities.hud;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;

public class HealthText extends BaseHudText {
    private static final Color COLOR = Color.WHITE;
    private static final String LABEL = "Health: ";

    public HealthText(Coordinate2D location) {
        super(location, LABEL, COLOR);
    }
    public void updateHealth(int health) { setValue(health); }
}