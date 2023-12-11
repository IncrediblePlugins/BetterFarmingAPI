package me.angeschossen.betterfarming.api.handler;

import me.angeschossen.betterfarming.api.BetterFarmingAPI;
import com.github.angeschossen.pluginframework.api.configuration.Configuration;
import com.github.angeschossen.pluginframework.api.configuration.gui.GUIConfiguration;
import com.github.angeschossen.pluginframework.api.configuration.messages.Messages;
import com.github.angeschossen.pluginframework.api.utils.StringUtils;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * This class is not intended for direct usage and might change at any time.
 */
public class APIHandler {

    private static APIHandler instance;
    private final @NotNull Plugin plugin;
    private final @NotNull BetterFarmingAPI api;


    private APIHandler(@NotNull Plugin plugin,
                       @NotNull BetterFarmingAPI api) {
        this.api = api;
        this.plugin = plugin;
    }

    public @NotNull BetterFarmingAPI getAPI() {
        return api;
    }

    public @NotNull Plugin getPlugin() {
        return plugin;
    }

    public static APIHandler getInstance() {
        return instance;
    }

    public static void init(@NotNull Plugin plugin,
                            @NotNull BetterFarmingAPI api) {
        Objects.requireNonNull(api);

        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }

        instance = new APIHandler(plugin, api);
    }
}
