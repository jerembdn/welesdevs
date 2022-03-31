package com.onruntime.welesdevs;

import com.onruntime.welesdevs.service.ClansService;
import com.onruntime.welesdevs.listener.AsyncPlayerChatListener;
import com.onruntime.welesdevs.listener.PlayerJoinListener;
import com.onruntime.welesdevs.listener.PlayerQuitListener;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Welesdevs extends JavaPlugin {
    private static ClansService CLANSSERVICE;
    private static Welesdevs INSTANCE;

    @Override
    public void onLoad() {
        super.onLoad();

        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        super.saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        getServer().getPluginManager().registerEvents(new AsyncPlayerChatListener(), this);

        try {
            CLANSSERVICE = new ClansService();
        } catch (InvalidConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        super.saveDefaultConfig();
    }

    public static ClansService getClansService() {
        return CLANSSERVICE;
    }

    public static Welesdevs getInstance() {
        return INSTANCE;
    }
}
