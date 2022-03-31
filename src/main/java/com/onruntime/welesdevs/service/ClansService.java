package com.onruntime.welesdevs.service;

import com.onruntime.welesdevs.config.Config;
import com.onruntime.welesdevs.entity.Clan;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;

import java.io.IOException;
import java.util.ArrayList;

public class ClansService {
    private final Config config;
    private final ArrayList<Clan> clans;

    public ClansService() throws IOException, InvalidConfigurationException {
        this.config = Config.generateConfig("clans");
        this.clans = new ArrayList<>();

        ConfigurationSection section = config.getConfigurationSection("clans");
        config.save();
        assert section != null;
        System.out.println(section.getKeys(false));
        section.getKeys(false).forEach((String key) -> {
            String clanName = config.getString(String.format("%s$1.%s$2.name", section.getName(), key));
            System.out.println(clanName);

            Clan clan = new Clan(clanName, new ArrayList<>());
            clans.add(clan);
        });

        System.out.println(clans);
    }

    public ArrayList<Clan> getClans() {
        return clans;
    }
}
