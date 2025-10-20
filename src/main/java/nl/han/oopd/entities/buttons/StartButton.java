package nl.han.oopd.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import nl.han.oopd.GeorgesFruitJacht;

public class StartButton extends BaseButton {

    private final GeorgesFruitJacht game;

    public StartButton(Coordinate2D location, GeorgesFruitJacht game) {
        super(location, "Play game");
        this.game = game;
    }

    @Override
    protected void onClick() {
        game.setActiveScene(1); // Naar GameLevel
    }
}
