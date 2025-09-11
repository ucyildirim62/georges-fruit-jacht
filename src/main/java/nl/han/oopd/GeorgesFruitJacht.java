package nl.han.oopd;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.han.oopd.scenes.GameLevel;
import nl.han.oopd.scenes.TitleScene;

import java.text.AttributedCharacterIterator;

/**
 * Hello world!
 *
 */
public class GeorgesFruitJacht extends YaegerGame
{
    public static void main( String[] args )
    {
       launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("George's Fruit Jacht");
        setSize(new Size(800, 600));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevel(this));
    }
}
