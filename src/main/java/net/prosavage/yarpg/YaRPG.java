package net.prosavage.yarpg;

import co.aikar.commands.PaperCommandManager;
import net.prosavage.yarpg.utilities.Color;
import net.prosavage.yarpg.utilities.YFileUtil;
import net.prosavage.yarpg.utilities.managers.CommandManager;
import net.prosavage.yarpg.utilities.managers.CompletionManager;
import net.prosavage.yarpg.utilities.managers.FileManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class YaRPG extends JavaPlugin {

    private static YaRPG instance;

    public YaRPG() {
        instance = this;
    }

    public static YaRPG getInstance() {
        return instance;
    }

    YFileUtil yFileUtil = new YFileUtil();
    Color color = new Color();
    FileManager fileManager;
    PaperCommandManager manager;

    @Override
    public void onEnable() {
        fileManager = new FileManager(this);
        fileManager.generateFiles();
        manager = new PaperCommandManager(this);
        new CompletionManager();
        new CommandManager().loadAll();
        log("&eTotal (YAML) weapon(s) loaded: &7" + yFileUtil.getFolderFileCount(fileManager.getWeaponFolder()));
        log("&eTotal (YAML) armor(s) loaded: &7" + yFileUtil.getFolderFileCount(fileManager.getArmorFolder()));
        log("");
        System.out.println(getVersionDouble());
    }

    @Override
    public void onDisable() {

    }

    public void log(Object message){
        getLogger().info(color.ify(String.valueOf(message)));
    }

    public FileManager getFileManager() {
        return this.fileManager;
    }

    public PaperCommandManager getManager() {
        return manager;
    }

    public double getVersionDouble(){
        String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3].substring(1);
        if (version.contains("1_16_")) {
            return 1.16;
        }else if (version.equals("1_15_")) {
            return 1.15;
        }else if (version.equals("1_14_")) {
            return 1.14;
        }
        return 1.13;
    }

}
