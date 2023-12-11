package me.angeschossen.betterfarming.api.enums;

import com.github.angeschossen.pluginframework.api.roles.settings.SettingType;
import org.jetbrains.annotations.NotNull;

/**
 * Limits what players can do in a farm. These flags only control physical actions.
 * Management actions are controlled by {@link ManagementFlag}.
 */
public enum ActionFlag implements com.github.angeschossen.pluginframework.api.roles.settings.RoleSetting {
    /**
     * Breaking blocks, that aren't harvestable by the farm.
     */
    BLOCK_BREAK(false, false),
    /**
     * Placing blocks, that aren't harvestable by the farm.
     */
    BLOCK_PLACE(false, false),
    /**
     * Essentially breaking blocks that are harvestable by the farm.
     */
    HARVEST(true, true),
    /**
     * Essentially placing blocks that are harvestable by the farm.
     */
    PLANT(true, true),
    /**
     * Interacting with blocks, such as doors etc., in the farm.
     */
    INTERACT(true, true);

    public final boolean applyPublic;
    public final boolean region;

    ActionFlag(boolean applyPublic, boolean region) {
        this.applyPublic = applyPublic;
        this.region = region;
    }

    /**
     * Get the flag id.
     * @return always returns 0 since action flags don't have an id
     */
    @Override
    public int getId() {
        return 0;
    }

    /**
     * Get the bypass permission
     * @return never null
     */
    @Override
    public String getBypassPermission() {
        return "betterfarming.bypass." + getName();
    }

    /**
     * Get the name of this flag.
     * @return same as {@link #toString()}
     */
    @Override
    public String getName() {
        return toString();
    }

    /**
     * Get the type of this flag.
     * @return type of this flag
     */
    @Override
    public SettingType getType() {
        return SettingType.ACTION;
    }

    /**
     * Get the permission required to toggle this flag.
     * This is not used in BetterFarming, since role flags can't be adjusted by players.
     * They can only be adjusted in the config.
     * @return permission required to toggle flag
     */
    @Override
    public String getTogglePermission() {
        return "betterfarming.role.setting." + getName();
    }

    /**
     * Get path to the message, used if a denial message is sent to the player for this flag
     * @return message path
     */
    @Override
    public String getMessageKey() {
        return "no-access." + getName();
    }
}
