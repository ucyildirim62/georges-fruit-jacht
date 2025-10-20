package nl.han.oopd.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import nl.han.oopd.GeorgesFruitJacht;

public class QuitButton extends BaseButton {

    private final GeorgesFruitJacht game;

    public QuitButton(Coordinate2D location, GeorgesFruitJacht game) {
        super(location, "Quit game");
        this.game = game;
    }

    @Override
    protected void onClick() {
        game.quit();
    }
}
