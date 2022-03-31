package com.onruntime.welesdevs.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        String joinMessage = String.format("§8[§a+§8]§r %s§r §7a rejoint le serveur !", player.getDisplayName());
        event.setJoinMessage(joinMessage);
    }
}
