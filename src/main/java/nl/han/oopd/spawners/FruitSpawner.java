package nl.han.oopd.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.oopd.entities.fruit.*;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class FruitSpawner extends EntitySpawner {

    private static final int SPAWN_INTERVAL = 500;
    private static final double FRUIT_SPEED = 2.0;
    private static final double START_Y = 0.0;

    private final double sceneWidth;
    private final Random random = new Random();

    private final List<Supplier<Fruit>> fruitTypes;

    public FruitSpawner(double sceneWidth) {
        super(SPAWN_INTERVAL);
        this.sceneWidth = sceneWidth;

        this.fruitTypes = List.of(
                () -> new Banana(randomLocation(), FRUIT_SPEED),
                () -> new RottenBanana(randomLocation(), FRUIT_SPEED)
        );
    }

    @Override
    protected void spawnEntities() {
        var factory = fruitTypes.get(random.nextInt(fruitTypes.size()));
        spawn(factory.get());
    }

    private Coordinate2D randomLocation() {
        double x = random.nextInt((int) sceneWidth);
        return new Coordinate2D(x, START_Y);
    }
}