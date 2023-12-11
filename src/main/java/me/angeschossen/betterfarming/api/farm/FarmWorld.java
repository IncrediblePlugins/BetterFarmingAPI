package me.angeschossen.betterfarming.api.farm;

import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Holds information of all farms in a world.
 */
public interface FarmWorld {

    /**
     * Get the Bukkit world.
     * @return Bukkit world
     */
    @NotNull
    World getWorld();

    /**
     * Get a farm by a block that belongs to a farm (radius)
     * @param x block X
     * @param y block Y
     * @param z block Z
     * @return null, if there is no farm at the given coordinates
     */
    @Nullable
    Farm getAccessedFarm(int x, int y, int z);

    /**
     * Get a farm by is ID.
     * @param iD numerical id
     * @return null, if no farm with this id in this world exists
     */
    @Nullable
    Farm getFarmById(int iD);

    /**
     * Check if a farm would overlap with another farm.
     * @param farm the farm to check
     * @param radius the theoretical new radius
     * @return the farm with which it would overlap. null, if no overlap
     */
    @Nullable
    Farm overlaps(@NotNull Farm farm, int radius);
}
