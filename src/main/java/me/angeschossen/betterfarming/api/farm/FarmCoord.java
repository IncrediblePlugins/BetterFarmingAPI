package me.angeschossen.betterfarming.api.farm;

import org.jetbrains.annotations.NotNull;

/**
 * Represents chunk coordinate of a farm.
 */
public class FarmCoord {

    public final int x, z;

    public FarmCoord(int x, int z) {
        this.x = x;
        this.z = z;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + x;
        hash = hash * 31 + z;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof FarmCoord)) {
            return false;
        }

        FarmCoord farmCoord = (FarmCoord) object;
        return farmCoord.x == x && farmCoord.z == z;
    }
}
