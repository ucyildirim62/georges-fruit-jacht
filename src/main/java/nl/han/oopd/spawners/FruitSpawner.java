package nl.han.oopd.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.oopd.entities.fruit.Banana;
import nl.han.oopd.entities.fruit.RottenBanana;

import java.util.Random;

public class FruitSpawner extends EntitySpawner {

    private static final double START_Y = 0;
    private static final double BANANA_CHANCE = 0.4;
    private static final double FRUIT_SPEED = 2.0;

    private final double sceneWidth;
    private final Random random = new Random();

    public FruitSpawner(double sceneWidth) {
        super(100); // interval in ms
        this.sceneWidth = sceneWidth;
    }

    @Override
    protected void spawnEntities() {
        if (Math.random() < BANANA_CHANCE) {
            spawn(new Banana(randomLocation(), FRUIT_SPEED));
        } else {
            spawn(new RottenBanana(randomLocation(), FRUIT_SPEED));
        }
    }

    private Coordinate2D randomLocation() {
        double x = random.nextInt((int) sceneWidth);
        return new Coordinate2D(x, START_Y);
    }
}
