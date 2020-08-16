package net.prosavage.yarpg.utilities.managers;

import net.prosavage.yarpg.YaRPG;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {

    YaRPG plugin;

    File configFile;
    File messageFile;

    File weaponFolder;
    File armorFolder;

    public FileManager(YaRPG plugin, boolean generate){
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), "config.yml");
        this.messageFile = new File(plugin.getDataFolder(), File.separator + "messages.yml");
        this.weaponFolder = new File(plugin.getDataFolder(), File.separator + "weapons");
        this.armorFolder = new File(plugin.getDataFolder(), File.separator + "armors");
        if (generate) generateFiles();
    }

    public void generateFiles(){
        if (!this.configFile.exists()) {
            this.plugin.saveDefaultConfig();
            this.plugin.saveResource("messages.yml", false);
        }
    }

    public File getWeaponFolder() {
        return weaponFolder;
    }

    public File getArmorFolder() {
        return armorFolder;
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

}
