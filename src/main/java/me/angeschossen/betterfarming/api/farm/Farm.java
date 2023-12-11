package me.angeschossen.betterfarming.api.farm;


import com.github.angeschossen.pluginframework.api.blockutil.BlockPosition;
import me.angeschossen.betterfarming.api.events.FarmBreakEvent;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.BlockVector;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Holds all information about a farm.
 */
public interface Farm {

    /**
     * Get the owner of a farm.
     * @return UUID of the owner
     */
    UUID getOwner();

    /**
     * Get the growth interval.
     * @return timeunit is seconds
     */
    int getInterval();

    /**
     * Get the growth radius.
     * @return radius in blocks
     */
    int getRadius();

    /**
     * Get the center position of this farm.
     * @return center position (the farm block)
     */
    BlockPosition getLocation();

    /**
     * Get the max. amount of storage slots.
     * @return max amount of storage slots
     */
    int getStorageSlots();

    /**
     * Check if the storage is full
     * @return true, if storage is full
     */
    boolean isStorageFull();

    /**
     * Get the remaining fuel time
     * @return timeunit is seconds
     */
    long getRemainingFuelTime();

    /**
     * Get the numerical id of this farm.
     * @return numerical id of farm
     */
    int getId();

    /**
     * Get the minimum point of the farms protection
     * @return minimum point
     */
    BlockVector getMinPoint();

    /**
     * Get the maximum point of the farms protection
     * @return maximum point
     */
    BlockVector getMaxPoint();

    /**
     * Check if the chunk of the center block is loaded ({@link #getLocation()}.
     * @return true, if the chunk is loaded
     */
    boolean isChunkLoaded();

    /**
     * Get trusted players.
     * @return collection of UUID's that are trusted
     */
    Set<UUID> getTrusted();

    /**
     * Delete the farm.
     * @param player the player that initiated the removal. null, if removed without player interaction
     * @param reason the reason of removal
     * @return false, if deletion was cancelled by another plugin
     */
    boolean delete(@Nullable Player player, FarmBreakEvent.Reason reason);

    /**
     * Get the world, in which the farm is placed
     * @return world of the farm
     */
    FarmWorld getFarmWorld();

    /**
     * Get the current harvested items in the storage
     * @return items in storage
     */
    List<? extends ItemStack> getStorage();
}
