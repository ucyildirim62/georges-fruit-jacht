package nl.han.oopd.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import nl.han.oopd.GeorgesFruitJacht;

public class QuitButton extends BaseButton {

    private final GeorgesFruitJacht georgesFruitJacht;

    public QuitButton(Coordinate2D location, GeorgesFruitJacht georgesFruitJacht) {
        super(location, "Quit game");
        this.georgesFruitJacht = georgesFruitJacht;
    }

    @Override
    protected void onClick() {
        georgesFruitJacht.quit();
    }
}
