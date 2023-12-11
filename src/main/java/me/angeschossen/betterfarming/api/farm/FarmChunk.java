package me.angeschossen.betterfarming.api.farm;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A chunk can contain multiple farms.
 */
public interface FarmChunk {

    /**
     * Check if the chunk contains at least a part of this farm.
     * @param farm the farm to check
     * @return true, if the chunk contains at least a part of this farm
     */
    boolean containsFarm(Farm farm);

    /**
     * Get X identifier of chunk
     * @return X identifier of chunk
     */
    int getX();

    /**
     * Get Z identifier of chunk
     * @return Z identifier of chunk
     */
    int getZ();

    /**
     * Get the world of the chunk
     * @return the world
     */
    @NotNull
    FarmWorld getFarmWorld();

    /**
     * Get farm by any block that belongs to the farm
     * @param x X block
     * @param y Y block
     * @param z Z block
     * @return null, if block not in chunk or simply no farm at the given coordinates
     */
    @Nullable
    Farm getAccessedFarm(int x, int y, int z);
}
