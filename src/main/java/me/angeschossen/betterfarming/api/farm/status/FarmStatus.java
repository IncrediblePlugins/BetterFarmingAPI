package me.angeschossen.betterfarming.api.farm.status;

public enum FarmStatus {
    PAUSED_FUEL_EMPTY("paused.no-fuel", true, false),
    PAUSED_STORAGE_FULL("paused.storage-full", true, false),
    RUNNING("running", true, true), PAUSED("undefined", false, false),
    PAUSED_CHUNK("undefined", false, false),
    PAUSED_MANUALLY("paused.manually", true, false),
    PAUSED_NO_BLOCKS("paused.no-blocks", true, false),
    PAUSED_OWNER_OFFLINE("paused.owner-offline", true, false);

    public final String lang;
    public final boolean holo, upd;

    FarmStatus(String lang, boolean holo, boolean upd) {
        this.lang = lang;
        this.upd = upd;
        this.holo = holo;
    }
}
