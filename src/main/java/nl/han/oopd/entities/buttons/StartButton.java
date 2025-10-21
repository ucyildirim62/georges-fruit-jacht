package nl.han.oopd.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import nl.han.oopd.GeorgesFruitJacht;

public class StartButton extends BaseButton {

    private final GeorgesFruitJacht georgesFruitJacht;

    public StartButton(Coordinate2D location, GeorgesFruitJacht georgesFruitJacht) {
        super(location, "Play game");
        this.georgesFruitJacht = georgesFruitJacht;
    }

    @Override
    protected void onClick() {
        georgesFruitJacht.setActiveScene(1);
    }
}
