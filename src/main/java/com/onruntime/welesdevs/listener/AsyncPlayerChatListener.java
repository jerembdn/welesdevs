package com.onruntime.welesdevs.listener;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        Bukkit.getOnlinePlayers().stream().filter((Player bukkitPlayer) ->
            event.getMessage().contains(bukkitPlayer.getName())
        ).forEach((Player bukkitPlayer) -> {
            event.setMessage(event.getMessage().replaceAll(bukkitPlayer.getName(), String.format("§5§l%s", bukkitPlayer.getDisplayName())));
            bukkitPlayer.playSound(bukkitPlayer.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
        });

        event.setFormat("§r" + player.getDisplayName() + "§r §8»§7 " + event.getMessage().replaceAll("%", "%%"));
    }
}
