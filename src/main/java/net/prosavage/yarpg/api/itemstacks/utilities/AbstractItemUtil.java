package net.prosavage.yarpg.api.itemstacks.utilities;

import net.prosavage.yarpg.utilities.Color;
import net.prosavage.yarpg.utilities.NumberFormat;
import net.prosavage.yarpg.utilities.keys.YNamespacedKeys;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractItemUtil extends AbstractItemBuilder {

    Color color = new Color();
    NumberFormat numberFormat = new NumberFormat();

    public boolean naturalItem;
    public boolean validFile;

    public AbstractItemUtil(String stringMaterial){
        super(stringMaterial);
    }

    public AbstractItemUtil(ItemStack itemStack) {
        super(itemStack);
    }

    public AbstractItemUtil(Material type) {
        super(type);
    }

    public AbstractItemUtil(String rarity, String name) {
        super(rarity, name);
    }

    public List<String> parseBasicLore(List<String> lore, String rarity, String material, int level){
        List<String> newLore = new ArrayList<>();
        for (String s : lore) {
            s = s.replace("{item_rarity}", rarity)
                    .replace("{item_type}", material)
                    .replace("{item_required_level}", String.valueOf(level));
            newLore.add(color.ify(s));
        }
        return newLore;
    }

    public List<String> parseGainedStatsLore(List<String> lore, double meleeMinimumDamage, double meleeMaximumDamage,
                                             double rangedMinimumDamage, double rangedMaximumDamage, double attackCooldown){
        List<String> newLore = new ArrayList<>();
        for (String s : lore) {
            if (meleeMinimumDamage >= 0 && meleeMaximumDamage > 0) {
                s = s.replace("{item_melee_minimum_damage}", "" + meleeMinimumDamage).replace("{item_melee_maximum_damage}", "" + meleeMaximumDamage);
            }
            if (rangedMinimumDamage >= 0 && rangedMaximumDamage > 0) {
                s = s.replace("{item_ranged_minimum_damage}", "" + rangedMinimumDamage).replace("{item_ranged_maximum_damage}", "" + rangedMaximumDamage);
            }
            if (attackCooldown > 0){
                s = s.replace("{item_attack_cooldown}", "" + attackCooldown);
            }
            newLore.add(color.ify(s));
        }
        return newLore;
    }

    public List<String> parseGainedStatsLore(List<String> lore, double health, double regeneration, double protection){
        List<String> newLore = new ArrayList<>();
        for (String s : lore) {
            if (health > 0) {
                s = s.replace("{item_health}", "" + numberFormat.getDoubleFormat().format(health));
            }
            if (regeneration > 0) {
                s = s.replace("{item_regeneration}", "" + numberFormat.getDoubleFormat().format(regeneration));
            }
            if (protection > 0) {
                s = s.replace("{item_protection}", "" + numberFormat.getDoubleFormat().format(protection));
            }
            newLore.add(color.ify(s));
        }
        return newLore;
    }


    public List<String> parseAttributes(List<String> lore, int strength, int intelligence, int constitution, int dexterity,
                                        int charisma, int wisdom, int luck) {
        List<String> newLore = new ArrayList<>();
        for (String s : lore) {
            if (strength != 0) s = s.replace("{item_str}", String.valueOf(strength));
            if (intelligence != 0) s = s.replace("{item_int}", String.valueOf(intelligence));
            if (constitution != 0) s = s.replace("{item_con}", String.valueOf(constitution));
            if (dexterity != 0) s = s.replace("{item_dex}", String.valueOf(dexterity));
            if (charisma != 0) s = s.replace("{item_cha}", String.valueOf(charisma));
            if (wisdom != 0) s = s.replace("{item_wis}", String.valueOf(wisdom));
            if (luck != 0) s = s.replace("{item_luk}", String.valueOf(luck));
            newLore.add(color.ify(s));
        }
        return newLore;
    }

    public List<String> parseRequirementLore(List<String> lore, int strength, int intelligence, int constitution, int dexterity, int charisma, int wisdom, int luck){
        List<String> newLore = new ArrayList<>();
        for (String s : lore) {
            if (strength > 0) s = s.replace("{item_required_str}", String.valueOf(strength));
            if (intelligence > 0) s = s.replace("{item_required_int}", String.valueOf(intelligence));
            if (constitution > 0) s = s.replace("{item_required_con}", String.valueOf(constitution));
            if (dexterity > 0) s = s.replace("{item_required_dex}", String.valueOf(dexterity));
            if (charisma > 0) s = s.replace("{item_required_cha}", String.valueOf(charisma));
            if (wisdom > 0) s = s.replace("{item_required_wis}", String.valueOf(wisdom));
            if (luck > 0) s = s.replace("{item_required_luk}", String.valueOf(luck));
            newLore.add(color.ify(s));
        }
        return newLore;
    }

    public List<String> removeUnwantedLore(List<String> lore){
        List<String> newLore = new ArrayList<>();
        for (String s : lore) {
            newLore.add(color.ify(s));
            if (s.contains("{item_") && s.endsWith("}")) {
                newLore.remove(color.ify(s));
            }
        }
        return newLore;
    }

    public List<String> parseGemLore(List<String> lore, int gems) {
        boolean noGems = false;
        if (gems <= 0) {
            noGems = true;
        }
        List<String> newLore = new ArrayList<>();
        for (String s : lore) {
            newLore.add(color.ify(s));
            if (s.contains("{item_gem_sockets}")) {
                newLore.remove(lore.indexOf(s));
                if (!noGems) {
                    for (int i = 0; i < gems; i++) {
                        newLore.add(lore.indexOf(s) + i, color.ify("&7» [ Gem Socket # " + i + " ]"));
                    }
                }else {
                    int index = lore.indexOf(s);
                    newLore.remove(index - 1);
                    newLore.remove(index - 2);
                }
            }
        }
        return newLore;
    }

    public List<String> parseScrollLore(List<String> lore, int scroll) {
        boolean noScroll = false;
        if (scroll <= 0) {
            noScroll = true;
        }
        List<String> newLore = new ArrayList<>();
        for (String s : lore) {
            newLore.add(color.ify(s));
            if (s.contains("{item_scroll_sockets}")) {
                newLore.remove(lore.indexOf(s));
                if (!noScroll) {
                    for (int i = 0; i < scroll; i++) {
                        newLore.add(lore.indexOf(s) + i, color.ify("&7» [ Scroll Socket # " + i + " ]"));
                    }
                }else {
                    int index = lore.indexOf(s);
                    newLore.remove(index - 1);
                    newLore.remove(index - 2);
                }
            }
        }
        return newLore;
    }

    public List<String> parseDescriptionLore(List<String> lore, List<String> description) {
        boolean hasDescription = false;
        if (description != null && !(description.equals(Collections.singletonList("null"))) && !(description.equals(Collections.singletonList("")))) {
            hasDescription = true;
        }
        List<String> newLore = new ArrayList<>();
        for (String s : lore) {
            newLore.add(color.ify(s));
            if (s.contains("{item_description}")) {
                if (hasDescription){
                    newLore.remove(color.ify(s));
                    for (String e : description) {
                        newLore.add(color.ify("&7» &f" + e));
                    }
                }else{
                    newLore.remove(newLore.indexOf(color.ify(s)) - 1);
                    newLore.remove(color.ify(s));
                }
            }
        }
        return newLore;
    }

    public void removeUnusedNamespacedKeys() {
        PersistentDataType[] namespacedKeyDataType = YNamespacedKeys.getAllItemDataType();
        NamespacedKey[] namespacedKeys = YNamespacedKeys.getAllItemNamespacedKeys();
        int i = 0;
        for (NamespacedKey key : namespacedKeys) {
            PersistentDataType a = namespacedKeyDataType[i];
            if (persistentDataContainer.has(key, a)){
                if (persistentDataContainer.get(key, a) == null) {
                    persistentDataContainer.remove(key);
                }
            }
            i = i + 1;
        }
    }

    public boolean isNaturalItem() {
        return naturalItem;
    }

    public boolean isValidFile() {
        return validFile;
    }

}
