package nl.han.oopd.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public abstract class Fruit extends DynamicCircleEntity implements Collided, Collider, SceneBorderCrossingWatcher {


    protected Fruit(Coordinate2D initialLocation, double speed) {
        super(initialLocation);
        setRadius(8);
        setMotion(speed, Direction.UP);
        setOpacity(0.5);
        setStrokeWidth(0.2);
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        var shouldCollect = false;

        for (Collider collider : collidingObject) {
            if (collider instanceof Fruit) {
                shouldCollect = true;
                break;
            }
        }
        if (shouldCollect) {

            remove();
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        if (border.equals(SceneBorder.TOP)) {
            remove();
        }
    }

}
