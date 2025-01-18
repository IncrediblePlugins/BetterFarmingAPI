package me.angeschossen.betterfarming.api.role;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class ActionFlag extends com.github.angeschossen.pluginframework.api.flags.roles.ActionFlag {
    private final boolean applyPublic, applyRegion;
    public ActionFlag(@NotNull Plugin plugin, @NotNull String name, boolean applyPublic, boolean applyRegion) {
        super(plugin, name);

        this.applyPublic = applyPublic;
        this.applyRegion = applyRegion;
    }

    public boolean isApplyPublic() {
        return applyPublic;
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
