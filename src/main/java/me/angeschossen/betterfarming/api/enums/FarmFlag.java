package me.angeschossen.betterfarming.api.enums;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Flags to change usage of farms.
 */
public enum FarmFlag {
    /**
     * Lets everyone harvest and plant.
     * This doesn't allow them to level the farm etc.
     */
    PUBLIC(0),
    /**
     * Automatically replant broken crops or saplings.
     */
    AUTO_REPLANT(1);

    private static final Map<Integer, FarmFlag> map = new HashMap<>();

    static {
        for (FarmFlag flag : values()) {
            map.put(flag.id, flag);
        }
    }

    public final int id;

    FarmFlag(int id) {
        this.id = id;
    }

    /**
     * Get a flag by its id.
     * @param id the numerical id
     * @return null, if no flag with this id exists
     */
    @Nullable
    public static FarmFlag getById(int id) {
        return map.getOrDefault(id, null);
    }
}
