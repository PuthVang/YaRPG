package net.prosavage.yarpg.utilities.managers;

import co.aikar.commands.PaperCommandManager;
import com.google.common.collect.ImmutableList;
import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.utilities.YFileUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class CompletionManager {

    private static PaperCommandManager manager;
    private static FileManager fileManager;

    public CompletionManager(){
    }

    public static void loadAll(){
        manager = YaRPG.getInstance().getManager();
        fileManager = YaRPG.getInstance().getFileManager();

        manager.getCommandCompletions().registerCompletion("weaponRarity", c ->
                YFileUtil.getFoldersWithUnderlinesInsteadOfSpaces(fileManager.getWeaponFolder()));

        manager.getCommandCompletions().registerCompletion("weaponNames", c -> {
            CommandSender sender = c.getSender();
            if (sender instanceof Player) {
                String contextValue = c.getContextValue(String.class);
                if (contextValue != null) {
                    return YFileUtil.getFilesWithUnderlinesInsteadOfSpaces(new File(fileManager.getWeaponFolder() + File.separator + contextValue));
                }
            }
            return null;
        });

        manager.getCommandCompletions().registerCompletion("weaponTypes", c -> ImmutableList.of("minimum_level", "maximum_level", "required_strength", "required_intelligence", "required_consitution", "required_dexterity", "required_charisma", "required_wisdom", "required_luck", "strength", "intelligence", "constitution", "dexterity", "charisma", "wisdom", "luck", "minimum_gem", "maximum_gem", "minimum_scroll", "maximum_scroll", "minimum_gems", "melee_minimum_damage", "melee_maximum_damage", "ranged_minimum_damage", "ranged_maximum_damage", "attack_cooldown", "rarity", "name", "cosmetic_material", "description"));

        manager.getCommandCompletions().registerCompletion("armorRarity", c ->
                YFileUtil.getFoldersWithUnderlinesInsteadOfSpaces(fileManager.getArmorFolder()));

        manager.getCommandCompletions().registerCompletion("armorNames", c -> {
            CommandSender sender = c.getSender();
            if (sender instanceof Player) {
                String contextValue = c.getContextValue(String.class);
                if (contextValue != null) {
                    return YFileUtil.getFilesWithUnderlinesInsteadOfSpaces(new File(fileManager.getArmorFolder() + File.separator + contextValue));
                }
            }
            return null;
        });

        manager.getCommandCompletions().registerCompletion("armorTypes", c -> ImmutableList.of("minimum_level", "maximum_level", "required_strength", "required_intelligence", "required_consitution", "required_dexterity", "required_charisma", "required_wisdom", "required_luck", "strength", "intelligence", "constitution", "dexterity", "charisma", "wisdom", "luck", "minimum_gem", "maximum_gem", "minimum_scroll", "maximum_scroll", "minimum_protection", "maximum_protection", "minimum_health", "maximum_health", "minimum_regeneration", "maximum_regeneration", "name", "rarity", "actual_material", "cosmetic_material", "description"));

    }
}
