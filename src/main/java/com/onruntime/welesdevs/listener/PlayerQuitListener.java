package com.onruntime.welesdevs.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        String quitMessage = String.format("§8[§c-§8]§r %s§r §7a quitté le serveur !", player.getDisplayName());
        event.setQuitMessage(quitMessage);
    }
}
