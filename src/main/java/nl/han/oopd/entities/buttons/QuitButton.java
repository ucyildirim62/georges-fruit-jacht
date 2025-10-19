package nl.han.oopd.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.oopd.GeorgesFruitJacht;

public class QuitButton extends TextEntity
        implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private static final String LABEL = "Quit game";
    private static final String FONT_FAMILY = "Roboto";
    private static final int FONT_SIZE = 30;
    private static final Color DEFAULT_COLOR = Color.ORANGE;
    private static final Color HOVER_COLOR = Color.BLACK;
    private static final Color EXIT_COLOR = Color.WHITE;

    private final GeorgesFruitJacht georgesFruitJacht;

    public QuitButton(Coordinate2D initialPosition, GeorgesFruitJacht georgesFruitJacht) {
        super(initialPosition, LABEL);
        this.georgesFruitJacht = georgesFruitJacht;

        setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, FONT_SIZE));
        setFill(DEFAULT_COLOR);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        georgesFruitJacht.quit();
    }

    @Override
    public void onMouseEntered() {
        setFill(HOVER_COLOR);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(EXIT_COLOR);
        setCursor(Cursor.DEFAULT);
    }
}
