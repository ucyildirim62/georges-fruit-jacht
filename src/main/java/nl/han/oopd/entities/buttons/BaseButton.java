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

/**
 * Base class for all menu buttons.
 * Handles styling, hover behaviour and click template.
 */
public abstract class BaseButton extends TextEntity
        implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {


    protected static final String FONT_FAMILY = "Roboto";
    protected static final int FONT_SIZE = 30;
    protected static final Color DEFAULT_COLOR = Color.WHITE;
    protected static final Color HOVER_COLOR = Color.BLACK;

    protected BaseButton(Coordinate2D initialLocation, String label) {
        super(initialLocation, label);
        setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, FONT_SIZE));
        setFill(DEFAULT_COLOR);
    }

    /** Template method for subclasses to define their click behaviour. */
    protected abstract void onClick();

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if (mouseButton == MouseButton.PRIMARY) {
            onClick();
        }
    }

    @Override
    public void onMouseEntered() {
        setFill(HOVER_COLOR);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(DEFAULT_COLOR);
        setCursor(Cursor.DEFAULT);
    }
}
