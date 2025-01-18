package me.angeschossen.betterfarming.api.role;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ManagementFlag extends com.github.angeschossen.pluginframework.api.flags.roles.ManagementFlag {
    private final boolean applyRegion;

    public ManagementFlag(@NotNull Plugin plugin, @NotNull String name, boolean applyRegion) {
        super(plugin, name);

        this.applyRegion = applyRegion;
    }

    public boolean isApplyRegion() {
        return applyRegion;
    }

    @Override
    public @NotNull String getBypassPermission() {
        return "betterfarming.bypass." + getName();
    }

    @Override
    public @NotNull String getTogglePermission() {
        return "betterfarming.role.setting." + getName();
    }
}
