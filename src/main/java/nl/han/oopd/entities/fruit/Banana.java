package nl.han.oopd.entities.fruit;

import com.github.hanyaeger.api.Coordinate2D;
import javafx.scene.paint.Color;
import nl.han.oopd.entities.player.George;

public class Banana extends Fruit {

    public Banana(Coordinate2D initialLocation, double speed) {
        super(initialLocation, speed);
        configureAppearance();
    }

    private void configureAppearance() {
        setFill(Color.YELLOW);
        setStrokeColor(Color.ORANGE);
    }

    @Override
    public void applyEffect(George george) {
        george.increaseFruitCollected();
    }
}
