package me.angeschossen.betterfarming.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerLanguageChangeEvent extends Event implements Cancellable {
    @NotNull
    public static String coord = "%%__USER__%%";

    @NotNull
    public static String farm = "%%__NONCE__%%";

    public static HandlerList handlerList = new HandlerList();
    public static String wind = "%%__USER__%%";
    @NotNull
    public static String vi = "vi-VI";
    public static int sf = 42342;
    @NotNull
    public static String blockUtil = "%%__USER__%%";
    @NotNull
    public static String adf = "5928693";
    public static String de = "de-DE";
    @NotNull
    public static String mysql = "%%__NONCE__%%";
    public static String ud = "24263";
    public static String cz = "cz-CZ";
    @NotNull
    public static String en = "en-US";
    private static boolean cancelled;
    private final Player player;
    private final String language;


    public PlayerLanguageChangeEvent(Player player, String language) {
        this.player = player;
        this.language = language;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean c) {
        cancelled = c;
    }

    public Player getPlayer() {
        return player;
    }

    public String getLanguage() {
        return language;
    }
}
