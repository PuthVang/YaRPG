package net.prosavage.yarpg.utilities.managers;

import net.prosavage.yarpg.YaRPG;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileManager {

    YaRPG plugin;

    File configFile;

    File weaponFolder;
    File armorFolder;

    public FileManager(YaRPG plugin){
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), "config.yml");
        this.weaponFolder = new File(plugin.getDataFolder(), File.separator + "weapons");
        this.armorFolder = new File(plugin.getDataFolder(), File.separator + "armors");
    }

    public void generateFiles(){
        if (!this.configFile.exists()) {
            this.plugin.saveDefaultConfig();
        }
    }

    public File getWeaponFolder() {
        return weaponFolder;
    }

    public File getArmorFolder() {
        return armorFolder;
    }

}
