package nl.han.oopd;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.han.oopd.scenes.GameLevel;
import nl.han.oopd.scenes.GameOverScene;
import nl.han.oopd.scenes.TitleScene;

public class GeorgesFruitJacht extends YaegerGame {


    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 600;

    private static final int TITLE_SCENE = 0;
    private static final int GAME_LEVEL_SCENE = 1;
    public static final int GAME_OVER_SCENE = 2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("George's Fruit Jacht");
        setSize(new Size(GAME_WIDTH, GAME_HEIGHT));
    }

    @Override
    public void setupScenes() {
        addScene(TITLE_SCENE, new TitleScene(this));
        addScene(GAME_LEVEL_SCENE, new GameLevel(this));
        addScene(GAME_OVER_SCENE, new GameOverScene(this));
    }
}
