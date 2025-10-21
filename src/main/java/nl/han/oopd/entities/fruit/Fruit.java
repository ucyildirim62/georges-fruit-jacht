package nl.han.oopd.entities.fruit;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import nl.han.oopd.entities.player.Player;

import java.util.List;

/**
 * Abstract base class for all fruit entities.
 */
public abstract class Fruit extends DynamicCircleEntity implements FruitEffect, Collider, Collided {

    protected final double speed;

    protected Fruit(Coordinate2D initialLocation, double speed) {
        super(initialLocation);
        this.speed = speed;

        setMotion(speed, Direction.DOWN);

        setRadius(20);
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        for (Collider collider : collidingObjects) {
            if (collider instanceof Player player) {
                applyEffect(player);
                remove();
                break;
            }
        }
    }
}
