package me.angeschossen.betterfarming.api.enums;

import com.github.angeschossen.pluginframework.api.roles.settings.ManagementSetting;
import com.github.angeschossen.pluginframework.api.roles.settings.SettingType;
import org.jetbrains.annotations.NotNull;

/**
 * Flags used to check if a player can do specific management actions, such as upgrading the farm.
 */
public enum ManagementFlag implements ManagementSetting {
    /**
     * Upgrade levels
     */
    UPGRADE(true),
    /**
     * Set role players that have a role with a lower priority than their own role.
     */
    PLAYER_SETROLE(false),
    /**
     * Trust players
     */
    PLAYER_TRUST(false),
    /**
     * Untrust players that have a role with a lower priority than their own role.
     */
    PLAYER_UNTRUST(false),
    /**
     * Delete the farm
     */
    DELETE(false),
    /**
     * Toggle flags ({@link FarmFlag})
     */
    CONFIGURE(false);

    public final boolean region;

    ManagementFlag(boolean region) {
        this.region = region;
    }

    /**
     * Get the flag id.
     * @return always returns 0 since management flags don't have an id
     */
    @Override
    public int getId() {
        return 0;
    }

    /**
     * Get the bypass permission
     * @return never null
     */
    @NotNull
    @Override
    public String getBypassPermission() {
        return "betterfarming.bypass." + getName();
    }

    /**
     * Get the name of this flag.
     * @return same as {@link #toString()}
     */
    @NotNull
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
        return SettingType.MANAGEMENT;
    }

    /**
     * Get the permission required to toggle this flag.
     * This is not used in BetterFarming, since role flags can't be adjusted by players.
     * They can only be adjusted in the config.
     * @return permission required to toggle flag
     */
    @NotNull
    @Override
    public String getTogglePermission() {
        return "betterfarming.role.setting." + getName();
    }

    /**
     * Get path to the message, used if a denial message is sent to the player for this flag
     * @return message path
     */
    @NotNull
    @Override
    public String getMessageKey() {
        return "no-access." + getName();
    }
}
