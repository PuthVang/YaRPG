package net.prosavage.yarpg.utilities.managers;

import com.tchristofferson.configupdater.ConfigUpdater;
import net.prosavage.yarpg.YaRPG;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileManager {

    YaRPG plugin;

    File configFile;
    File messageFile;

    File weaponFolder;
    File armorFolder;

    public FileManager(YaRPG plugin, boolean generate){
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), "config.yml");
        this.messageFile = new File(plugin.getDataFolder(), "messages.yml");
        this.weaponFolder = new File(plugin.getDataFolder(), "weapons");
        this.armorFolder = new File(plugin.getDataFolder(), "armors");
        if (generate) generateFiles();
    }

    public File getWeaponFolder() {
        return this.weaponFolder;
    }

    public File getArmorFolder() {
        return this.armorFolder;
    }

    public File getConfigFile() {
        return this.configFile;
    }

    public File getMessageFile() {
        return this.messageFile;
    }

    public FileConfiguration getMessageConfiguration(){
        YamlConfiguration messageConfiguration = new YamlConfiguration();
        try {
            messageConfiguration.load(this.messageFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return messageConfiguration;
    }

    public void generateFiles(){
        if (!this.configFile.exists()) {
            this.plugin.saveDefaultConfig();
        } if (!this.messageFile.exists()) {
            this.plugin.saveResource("messages.yml", false);
        }
    }

    public FileManager update(){
        boolean enabled = plugin.getConfig().getBoolean("file_auto_update.enabled");
        if (!enabled) return this;

        List<String> files = plugin.getConfig().getStringList("file_auto_update.files");
        if (files.size() == 0) return this;

        for (String s : files){
            if (s.equals("config") || s.equals("config.yml")) plugin.saveDefaultConfig();
            updateFile(s, ".yml");
            if (s.equals("config") || s.equals("config.yml")) plugin.reloadConfig();
        }
        return this;
    }

    public void updateFile(String file, String extension){
        if (file.endsWith(extension)) extension = "";
        try {
            ConfigUpdater.update(plugin, file + extension, new File(plugin.getDataFolder(), file + extension), (List<String>) null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
