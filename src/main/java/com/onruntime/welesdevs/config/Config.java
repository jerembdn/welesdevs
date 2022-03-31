package com.onruntime.welesdevs.config;

import com.onruntime.welesdevs.Welesdevs;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Config extends FileConfiguration {
    private File file;

    public Config(File file, FileConfiguration fileConfig) {
        super(fileConfig);
        this.file = file;

        save();
    }

    public Config(FileConfiguration fileConfig) {
        super(fileConfig);
    }

    public void save() {
        if(file != null) {
            try {
                this.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Config generateConfig(String name) throws IOException, InvalidConfigurationException {
        JavaPlugin plugin = Welesdevs.getInstance();

        String fileName = String.format("%s.yml", name);
        File file = new File(plugin.getDataFolder(), fileName);
        if(!file.exists()) {
            file.getParentFile().mkdirs();
            plugin.saveResource(fileName, false);
        }

        FileConfiguration fileConfig = new YamlConfiguration();
        fileConfig.load(file);

        return new Config(file, fileConfig);
    }

    @Override
    public String saveToString() {
        return "";
    }

    @Override
    public void loadFromString(String contents) throws InvalidConfigurationException {}
}
