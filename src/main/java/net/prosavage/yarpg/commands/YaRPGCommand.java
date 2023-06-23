package net.prosavage.yarpg.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.api.files.ArmorFiles;
import net.prosavage.yarpg.api.files.WeaponFiles;
import net.prosavage.yarpg.api.itemstacks.Armor;
import net.prosavage.yarpg.api.itemstacks.Weapon;
import net.prosavage.yarpg.utilities.INumber;
import net.prosavage.yarpg.utilities.MessageUtilities;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Arrays;

@CommandAlias("YaRPG")
@CommandPermission("yarpg")
public class YaRPGCommand extends BaseCommand {

    @Default
    @CommandCompletion("reload|edit|give|info|debug")
    @CommandPermission("yarpg.help")
    public void onDefault(Player sender) {
        new MessageUtilities(sender, "messages.help").send();
    }

    @Subcommand("reload")
    @CommandPermission("yarpg.reload")
    public void onReload(Player sender){
        YaRPG.getInstance().reload();
        new MessageUtilities(sender, "messages.reload").send();
    }

    @Subcommand("give")
    @CommandCompletion("weapon|armor")
    @CommandPermission("yarpg.give")
    public void onGive(Player sender) {
        new MessageUtilities(sender, "messages.give").send();
    }

    @Subcommand("edit")
    @CommandCompletion("weapon|armor")
    @CommandPermission("yarpg.edit")
    public void onEdit(Player sender) {
        new MessageUtilities(sender, "messages.edit").send();
    }

    @Subcommand("edit weapon")
    @CommandCompletion("@weaponRarity @weaponNames @weaponTypes")
    @Syntax("<rarity> <name> <type> <value>")
    @CommandPermission("yarpg.edit.weapon")
    public void onEditWeapon(Player sender, String folderName, String fileName, @Optional String type, @Optional String value){
        WeaponFiles weaponFiles = new WeaponFiles(folderName, fileName);
        if (value != null) {
            if (INumber.isParsableAsInt(value)) {
                int intValue = Integer.parseInt(value);
                if (type.equals("minimum_level")) weaponFiles.setMinimumLevel(intValue);
                if (type.equals("maximum_level")) weaponFiles.setMaximumLevel(intValue);
                if (type.equals("required_strength")) weaponFiles.setRequiredStrength(intValue);
                if (type.equals("required_intelligence")) weaponFiles.setRequiredIntelligence(intValue);
                if (type.equals("required_consitution")) weaponFiles.setRequiredConsitution(intValue);
                if (type.equals("required_dexterity")) weaponFiles.setRequiredDexterity(intValue);
                if (type.equals("required_charisma")) weaponFiles.setRequiredCharisma(intValue);
                if (type.equals("required_wisdom")) weaponFiles.setRequiredWisdom(intValue);
                if (type.equals("required_luck")) weaponFiles.setRequiredLuck(intValue);
                if (type.equals("strength")) weaponFiles.setStrength(intValue);
                if (type.equals("intelligence")) weaponFiles.setIntelligence(intValue);
                if (type.equals("constitution")) weaponFiles.setConstitution(intValue);
                if (type.equals("dexterity")) weaponFiles.setDexterity(intValue);
                if (type.equals("charisma")) weaponFiles.setCharisma(intValue);
                if (type.equals("wisdom")) weaponFiles.setWisdom(intValue);
                if (type.equals("luck")) weaponFiles.setLuck(intValue);
                if (type.equals("minimum_gem")) weaponFiles.setMinimumGem(intValue);
                if (type.equals("maximum_gem")) weaponFiles.setMaximumGem(intValue);
                if (type.equals("minimum_scroll")) weaponFiles.setMinimumScroll(intValue);
                if (type.equals("maximum_scroll")) weaponFiles.setMaximumScroll(intValue);
                if (type.equals("minimum_gems")) weaponFiles.setMinimumGem(intValue);

            } else if (INumber.isParsableAsDouble(value)) {
                double doubleValue = Double.parseDouble(value);
                if (type.equals("melee_minimum_damage")) weaponFiles.setMeleeMinimumDamage(doubleValue);
                if (type.equals("melee_maximum_damage")) weaponFiles.setMeleeMaximumDamage(doubleValue);
                if (type.equals("ranged_minimum_damage")) weaponFiles.setRangedMinimumDamage(doubleValue);
                if (type.equals("ranged_maximum_damage")) weaponFiles.setRangedMaximumDamage(doubleValue);
                if (type.equals("attack_cooldown")) weaponFiles.setAttackCooldown(doubleValue);
            } else {
                if (type.equals("rarity")) weaponFiles.setRarity(value);
                if (type.equals("name")) weaponFiles.setName(value);
                if (type.equals("actual_material")){
                    if (Material.getMaterial(value) == null){
                        sender.sendTitle("Invalid material, try again.", "", 20, 20, 20);
                    }else{
                        weaponFiles.setActualMaterial(value);
                    }
                }
                if (type.equals("cosmetic_material")) weaponFiles.setCosmeticMaterial(value);
                if (type.equals("description")) weaponFiles.setDescription(Arrays.asList(value.split("\\|\\|")));
            }
            weaponFiles.save();
        }
    }

    @Subcommand("edit armor")
    @CommandCompletion("@armorRarity @armorNames @armorTypes")
    @Syntax("<rarity> <name> <type> <value>")
    @CommandPermission("yarpg.edit.armor")
    public void onEditArmor(Player sender, String folderName, String fileName, @Optional String type, @Optional String value){
        ArmorFiles armorFiles = new ArmorFiles(folderName, fileName);
        if (value != null) {
            if (INumber.isParsableAsInt(value)) {
                int intValue = Integer.parseInt(value);
                if (type.equals("minimum_level")) armorFiles.setMinimumLevel(intValue);
                if (type.equals("maximum_level")) armorFiles.setMaximumLevel(intValue);
                if (type.equals("required_strength")) armorFiles.setRequiredStrength(intValue);
                if (type.equals("required_intelligence")) armorFiles.setRequiredIntelligence(intValue);
                if (type.equals("required_consitution")) armorFiles.setRequiredConsitution(intValue);
                if (type.equals("required_dexterity")) armorFiles.setRequiredDexterity(intValue);
                if (type.equals("required_charisma")) armorFiles.setRequiredCharisma(intValue);
                if (type.equals("required_wisdom")) armorFiles.setRequiredWisdom(intValue);
                if (type.equals("required_luck")) armorFiles.setRequiredLuck(intValue);
                if (type.equals("strength")) armorFiles.setStrength(intValue);
                if (type.equals("intelligence")) armorFiles.setIntelligence(intValue);
                if (type.equals("constitution")) armorFiles.setConstitution(intValue);
                if (type.equals("dexterity")) armorFiles.setDexterity(intValue);
                if (type.equals("charisma")) armorFiles.setCharisma(intValue);
                if (type.equals("wisdom")) armorFiles.setWisdom(intValue);
                if (type.equals("luck")) armorFiles.setLuck(intValue);
                if (type.equals("minimum_gem")) armorFiles.setMinimumGem(intValue);
                if (type.equals("maximum_gem")) armorFiles.setMaximumGem(intValue);
                if (type.equals("minimum_scroll")) armorFiles.setMinimumScroll(intValue);
                if (type.equals("maximum_scroll")) armorFiles.setMaximumScroll(intValue);
            }else if (INumber.isParsableAsDouble(value)) {
                double doubleValue = Double.parseDouble(value);
                if (type.equals("minimum_protection")) armorFiles.setMinimumProtection(doubleValue);
                if (type.equals("maximum_protection")) armorFiles.setMaximumProtection(doubleValue);
                if (type.equals("minimum_health")) armorFiles.setMinimumHealth(doubleValue);
                if (type.equals("maximum_health")) armorFiles.setMaximumHealth(doubleValue);
                if (type.equals("minimum_regeneration")) armorFiles.setMinimumRegeneration(doubleValue);
                if (type.equals("maximum_regeneration")) armorFiles.setMaximumRegeneration(doubleValue);
            } else {
                if (type.equals("rarity")) armorFiles.setRarity(value);
                if (type.equals("name")) armorFiles.setName(value);
                if (type.equals("actual_material")) {
                    if (Material.getMaterial(value) == null) {
                        sender.sendTitle("Invalid material, try again.", "", 20, 20, 20);
                    } else {
                        armorFiles.setActualMaterial(value);
                    }
                }
                if (type.equals("cosmetic_material")) armorFiles.setCosmeticMaterial(value);
                if (type.equals("description")) armorFiles.setDescription(Arrays.asList(value.split("\\|\\|")));
            }
            armorFiles.save();
        }
    }

    @Subcommand("give weapon")
    @CommandCompletion("@weaponRarity @weaponNames")
    @CommandPermission("yarpg.give.weapon")
    public void onGiveWeapon(Player sender, @Optional String rarity, @Optional String name) {
        Weapon weapon = new Weapon(rarity, name);
        if (weapon.isValidFile()) {
            sender.getInventory().addItem(weapon.build());
        }
    }

    @Subcommand("give armor")
    @CommandCompletion("@armorRarity @armorNames")
    @CommandPermission("yarpg.give.armor")
    public void onGiveArmor(Player sender, String rarity, String name) {
        Armor armor = new Armor(rarity, name);
        if (armor.isValidFile()) {
            sender.getInventory().addItem(armor.build());
        }
    }

    @Subcommand("info|stat|stats")
    @CommandPermission("yarpg.info")
    public void onInfo(Player sender) {
        new MessageUtilities(sender, "messages.info").send();
    }

}
