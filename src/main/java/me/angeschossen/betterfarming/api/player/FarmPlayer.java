package me.angeschossen.betterfarming.api.player;

import me.angeschossen.betterfarming.api.farm.Farm;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;

/**
 * Represents an online player.
 */
public interface FarmPlayer {

    /**
     * Get the UUID of a player
     *
     * @return UUID of this player
     */
    UUID getUUID();

    /**
     * Get all farms that the player owns.
     * @return collection of farms the player owns
     */
    @NotNull
    Collection<? extends Farm>getFarms();
}
