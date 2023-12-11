package me.angeschossen.betterfarming.api.events;

import me.angeschossen.betterfarming.api.farm.Farm;
import me.angeschossen.betterfarming.api.player.FarmPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a farm is being created.
 */
public class FarmPlaceEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final @NotNull FarmPlayer farmPlayer;
    private final @NotNull Farm farm;
    private boolean cancelled;

    /**
     * Create instance
     *
     * @param farmPlayer the player that places the farm block
     * @param farm       the farm that is being created
     */
    public FarmPlaceEvent(@NotNull FarmPlayer farmPlayer, @NotNull Farm farm) {
        this.farm = farm;
        this.farmPlayer = farmPlayer;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    /**
     * Get the farm.
     *
     * @return farm the is being created
     */
    @NotNull
    public Farm getFarm() {
        return farm;
    }

    /**
     * Get the player that placed the farm block.
     *
     * @return player that creates the farm
     */
    @NotNull
    public FarmPlayer getFarmPlayer() {
        return farmPlayer;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }
}
