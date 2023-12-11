package me.angeschossen.betterfarming.api.events;

import me.angeschossen.betterfarming.api.farm.Farm;
import me.angeschossen.betterfarming.api.player.FarmPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called when a farm is being deleted.
 */
public class FarmBreakEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final @Nullable FarmPlayer farmPlayer;
    private final @NotNull Farm farm;
    private final @NotNull Reason reason;
    private boolean cancelled;

    /**
     * Create instance
     *
     * @param farmPlayer player that is deleting the farm. null, if the farm is being removed by the plugin
     * @param farm       the farm that is being deleted
     * @param reason     reason for removal
     */
    public FarmBreakEvent(@Nullable FarmPlayer farmPlayer, @NotNull Farm farm, @NotNull Reason reason) {
        this.farm = farm;
        this.farmPlayer = farmPlayer;
        this.reason = reason;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    /**
     * Get the farm that is being deleted.
     *
     * @return farm that is about to be deleted
     */
    @NotNull
    public Farm getFarm() {
        return farm;
    }

    /**
     * Get the reason for the deletion.
     *
     * @return never null
     */
    @NotNull
    public Reason getReason() {
        return reason;
    }

    /**
     * Get the player that removed the farm.
     *
     * @return null, if destroyed because of natural reasons such as tnt explosions etc.
     */
    @Nullable
    public FarmPlayer getFarmPlayer() {
        return farmPlayer;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    /**
     * Cancel the deletion.
     *
     * @param cancelled true if you wish to cancel this event
     * @throws IllegalStateException deletions with the reason {@link Reason#ADMIN} can't be cancelled
     */
    @Override
    public void setCancelled(boolean cancelled) throws IllegalStateException {
        if (reason == Reason.ADMIN) {
            throw new IllegalStateException("Can't cancel event with reason = " + Reason.ADMIN.toString());
        }

        this.cancelled = cancelled;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

    /**
     * Different reasons for the removal of a farm.
     */
    public enum Reason {
        /**
         * The farm is forcefully removed by a server admin.
         */
        ADMIN,
        /**
         * Farm breaks because of a block or entity explosion.
         * This will only happen if explosion protection is turned off in the config.
         */
        EXPLOSION,
        /**
         * The player is manually deleting the farm.
         */
        PLAYER,
        /**
         * The land in which the farm stands, just got unclaimed and the server only allows farms to be placed
         * inside claimed land.
         */
        LAND_UNCLAIM,
        /**
         * The farm center block no longer exists. Can happen if BetterFarming is temporarily uninstalled and players
         * break the farm block.
         */
        INVALID,
        /**
         * The farm owner got untrusted, from the land in which the farm stands and the server only allows farms to be placed
         * in lands that trust the farm owner.
         */
        LAND_UNTRUST
    }
}
