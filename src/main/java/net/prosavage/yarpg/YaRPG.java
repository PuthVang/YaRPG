package net.prosavage.yarpg;

import co.aikar.commands.PaperCommandManager;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.prosavage.yarpg.utilities.Color;
import net.prosavage.yarpg.utilities.YFileUtil;
import net.prosavage.yarpg.utilities.managers.CommandManager;
import net.prosavage.yarpg.utilities.managers.CompletionManager;
import net.prosavage.yarpg.utilities.managers.FileManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class YaRPG extends JavaPlugin {

    private static YaRPG instance;

    public YaRPG() {
        instance = this;
    }

    public static YaRPG getInstance() {
        return instance;
    }

    FileManager fileManager;
    PaperCommandManager manager;
    BukkitAudiences result;

    @Override
    public void onEnable() {
        fileManager = new FileManager(this, true).update();
        manager = new PaperCommandManager(this);
        result = BukkitAudiences.create(this);
        CompletionManager.loadAll();
        CommandManager.loadAll();

        log("&eTotal (YAML) weapon(s) loaded: &7" + YFileUtil.getFolderFileCount(fileManager.getWeaponFolder()));
        log("&eTotal (YAML) armor(s) loaded: &7" + YFileUtil.getFolderFileCount(fileManager.getArmorFolder()));
        log("");
    }

    @Override
    public void onDisable() {

    }

    public void log(Object message){
        getLogger().info(Color.ify(String.valueOf(message)));
    }

    public FileManager getFileManager() {
        return this.fileManager;
    }

    public PaperCommandManager getManager() {
        return manager;
    }

    public BukkitAudiences getResult() {
        return result;
    }

    public void reload(){
        this.fileManager.update();
    }

}
