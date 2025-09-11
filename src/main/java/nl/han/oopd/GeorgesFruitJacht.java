package nl.han.oopd;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

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
        //addScene

    }
}
