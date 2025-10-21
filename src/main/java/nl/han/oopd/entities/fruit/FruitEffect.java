package nl.han.oopd.entities.fruit;

import nl.han.oopd.entities.player.Player;

/**
 * Defines an effect that fruit applies when collected by a player.
 */
public interface FruitEffect {
    void applyEffect(Player player);
}
