package me.angeschossen.betterfarming.api;

import me.angeschossen.betterfarming.api.handler.APIHandler;
import me.angeschossen.betterfarming.api.farm.Farm;
import me.angeschossen.betterfarming.api.player.FarmPlayer;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface BetterFarmingAPI {

    /**
     * Get instance of the API. Can be called after UpgradeableSpawners finished loading.
     * This can be called before the plugin is fully enabled though.
     *
     * @return instance of the API
     * @throws IllegalStateException if called, before the plugin is loaded
     */
    @NotNull
    static BetterFarmingAPI getInstance() {
        try {
            return APIHandler.getInstance().getAPI();
        } catch (NullPointerException ex) {
            throw new IllegalStateException("UpgradeableSpawners isn't loaded yet.");
        }
    }

    /**
     * Get a farm from given coordinates. This can be any block in the farm's radius.
     *
     * @param world the loaded world
     * @param x     block x
     * @param y     block y
     * @param z     block z
     * @return null, if the coordinate does not belong to a farm or the world isn't loaded.
     */
    @Nullable
    Farm getFarm(@NotNull World world, int x, int y, int z);

    /**
     * Get a player by its UUID
     * @param uuid player's UUID
     * @return null, if no player with that UUID is online
     */
    @Nullable FarmPlayer getFarmPlayer(@NotNull UUID uuid);
}
