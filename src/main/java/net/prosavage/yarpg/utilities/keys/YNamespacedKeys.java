package net.prosavage.yarpg.utilities.keys;

import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.utilities.tagtypes.BooleanTagType;
import net.prosavage.yarpg.utilities.tagtypes.UUIDTagType;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

public final class YNamespacedKeys {

    private static final YaRPG PLUGIN = YaRPG.getInstance();

    // ARMOR & WEAPONS

    public static final NamespacedKey ITEM_NAME = create("item_name");
    public static final NamespacedKey ITEM_MATERIAL = create("item_material");
    public static final NamespacedKey ITEM_RARITY = create("item_rarity");
    public static final NamespacedKey ITEM_DESCRIPTION = create("item_description_lore");

    public static final NamespacedKey ITEM_LEVEL = create("item_level");
    public static final NamespacedKey ITEM_REQUIRED_STRENGTH = create("item_required_strength");
    public static final NamespacedKey ITEM_REQUIRED_INTELLIGENCE = create("item_required_intelligence");
    public static final NamespacedKey ITEM_REQUIRED_CONSTITUTION = create("item_required_constitution");
    public static final NamespacedKey ITEM_REQUIRED_DEXTERITY = create("item_required_dexterity");
    public static final NamespacedKey ITEM_REQUIRED_CHARISMA = create("item_required_charisma");
    public static final NamespacedKey ITEM_REQUIRED_WISDOM = create("item_required_wisdom");
    public static final NamespacedKey ITEM_REQUIRED_LUCK = create("item_required_luck");

    public static final NamespacedKey ITEM_MELEE_MAXIMUM_DAMAGE = create("item_melee_maximum_damage");
    public static final NamespacedKey ITEM_MELEE_MINIMUM_DAMAGE = create("item_melee_minimum_damage");
    public static final NamespacedKey ITEM_RANGED_MAXIMUM_DAMAGE = create("item_ranged_maximum_damage");
    public static final NamespacedKey ITEM_RANGED_MINIMUM_DAMAGE = create("item_ranged_minimum_damage");
    public static final NamespacedKey ITEM_ATTACK_COOLDOWN = create("item_attack_cooldown");

    public static final NamespacedKey ITEM_MINIMUM_PROTECTION = create("item_minimum_protection");
    public static final NamespacedKey ITEM_MAXIMUM_PROTECTION = create("item_maximum_protection");
    public static final NamespacedKey ITEM_PROTECTION = create("item_protection");
    public static final NamespacedKey ITEM_MINIMUM_HEALTH = create("item_minimum_health");
    public static final NamespacedKey ITEM_MAXIMUM_HEALTH = create("item_maximum_health");
    public static final NamespacedKey ITEM_HEALTH = create("item_health");
    public static final NamespacedKey ITEM_MINIMUM_REGENERATION = create("item_minimum_regen");
    public static final NamespacedKey ITEM_MAXIMUM_REGENERATION = create("item_maximum_regen");
    public static final NamespacedKey ITEM_REGENERATION = create("item_regen");

    public static final NamespacedKey ITEM_STRENGTH = create("item_strength");
    public static final NamespacedKey ITEM_INTELLIGENCE = create("item_intelligence");
    public static final NamespacedKey ITEM_CONSTITUTION = create("item_constitution");
    public static final NamespacedKey ITEM_DEXTERITY = create("item_dexterity");
    public static final NamespacedKey ITEM_CHARISMA = create("item_charisma");
    public static final NamespacedKey ITEM_WISDOM = create("item_wisdom");
    public static final NamespacedKey ITEM_LUCK = create("item_luck");

    public static final NamespacedKey ITEM_GEM = create("item_gem");
    public static final NamespacedKey ITEM_SCROLL = create("item_scroll");

    public static final NamespacedKey ITEM_INVENTORY_SLOT = create("item_inventory_slot");

    public static final NamespacedKey ITEM_IS_SPAWNED_IN = create("item_is_spawned_in");
    public static final NamespacedKey ITEM_CREATOR_PLAYER = create("item_creator_player");

    // PLAYER & ENTITIES

    public static final NamespacedKey ENTITY_CHARACTER_NUMBER = create("entity_character_number");
    public static final NamespacedKey ENTITY_CLASS = create("entity_class");
    public static final NamespacedKey ENTITY_NAME = create("entity_name");
    public static final NamespacedKey ENTITY_LEVEL = create("entity_level");
    public static final NamespacedKey ENTITY_EXPERIENCE = create("entity_experience");
    public static final NamespacedKey ENTITY_MINIMUM_EXPERIENCE = create("entity_minimum_experience");
    public static final NamespacedKey ENTITY_MAXIMUM_EXPERIENCE = create("entity_maximum_experience");
    public static final NamespacedKey ENTITY_HEALTH = create("entity_health");
    public static final NamespacedKey ENTITY_MINIMUM_HEALTH = create("entity_minimum_health");
    public static final NamespacedKey ENTITY_MAXIMUM_HEALTH = create("entity_maximum_health");
    public static final NamespacedKey ENTITY_YARPG_DROPS = create("entity_yarpg_drops");
    public static final NamespacedKey ENTITY_YARPG_DROPS_CHANCES = create("entity_yarpg_drops_chances");

    public static final NamespacedKey ENTITY_PROTECTION = create("entity_protection");
    public static final NamespacedKey ENTITY_MINIMUM_PROTECTION = create("entity_minimum_protection");
    public static final NamespacedKey ENTITY_MAXIMUM_PROTECTION = create("entity_maximum_protection");
    public static final NamespacedKey ENTITY_REGENERATION = create("entity_regeneration");
    public static final NamespacedKey ENTITY_DAMAGE = create("entity_damage");
    public static final NamespacedKey ENTITY_MINIMUM_DAMAGE = create("entity_minimum_damage");
    public static final NamespacedKey ENTITY_MAXIMUM_DAMAGE = create("entity_maximum_damage");

    public static final NamespacedKey ENTITY_COMBAT_TAGGED = create("entity_combat_tagged");
    public static final NamespacedKey ENTITY_COMBAT_TAG_TIME = create("entity_combat_tag_time");
    public static final NamespacedKey ENTITY_LOGGED_OUT_IN_COMBAT = create("entity_logged_out_in_combat");

    public static final NamespacedKey ENTITY_ATTRIBUTE_POINTS = create("entity_attribute_points");
    public static final NamespacedKey ENTITY_ATTRIBUTE_STRENGTH = create("entity_attribute_strength");
    public static final NamespacedKey ENTITY_ATTRIBUTE_INTELLIGENCE = create("entity_attribute_intelligence");
    public static final NamespacedKey ENTITY_ATTRIBUTE_CONSTITUTION = create("entity_attribute_constitution");
    public static final NamespacedKey ENTITY_ATTRIBUTE_DEXTERITY = create("entity_attribute_dexterity");
    public static final NamespacedKey ENTITY_ATTRIBUTE_CHARISMA = create("entity_attribute_charisma");
    public static final NamespacedKey ENTITY_ATTRIBUTE_WISDOM = create("entity_attribute_wisdom");
    public static final NamespacedKey ENTITY_ATTRIBUTE_LUCK = create("entity_attribute_luck");

    public static final NamespacedKey[] ALL_ITEM_NAME_SPACED_KEYS = {

            // This is for items (armors and weapons)
            YNamespacedKeys.ITEM_NAME, YNamespacedKeys.ITEM_MATERIAL, YNamespacedKeys.ITEM_RARITY,
            YNamespacedKeys.ITEM_DESCRIPTION, YNamespacedKeys.ITEM_DESCRIPTION,
            YNamespacedKeys.ITEM_LEVEL, YNamespacedKeys.ITEM_ATTACK_COOLDOWN, YNamespacedKeys.ITEM_MELEE_MINIMUM_DAMAGE,
            YNamespacedKeys.ITEM_MELEE_MAXIMUM_DAMAGE, YNamespacedKeys.ITEM_RANGED_MINIMUM_DAMAGE,
            YNamespacedKeys.ITEM_RANGED_MAXIMUM_DAMAGE, YNamespacedKeys.ITEM_MINIMUM_PROTECTION,
            YNamespacedKeys.ITEM_MAXIMUM_PROTECTION, YNamespacedKeys.ITEM_MAXIMUM_HEALTH,
            YNamespacedKeys.ITEM_MINIMUM_HEALTH, YNamespacedKeys.ITEM_MAXIMUM_REGENERATION,
            YNamespacedKeys.ITEM_MINIMUM_REGENERATION, YNamespacedKeys.ITEM_GEM, YNamespacedKeys.ITEM_SCROLL,
            YNamespacedKeys.ITEM_IS_SPAWNED_IN, YNamespacedKeys.ITEM_CREATOR_PLAYER
    };

    public static final PersistentDataType[] ALL_ITEM_DATA_TYPE = {

            // This is for items (armors and weapons)
            PersistentDataType.STRING, PersistentDataType.STRING, PersistentDataType.STRING,
            PersistentDataType.STRING, PersistentDataType.STRING,
            PersistentDataType.INTEGER, PersistentDataType.DOUBLE, PersistentDataType.DOUBLE,
            PersistentDataType.DOUBLE, PersistentDataType.DOUBLE,
            PersistentDataType.DOUBLE, PersistentDataType.DOUBLE,
            PersistentDataType.DOUBLE, PersistentDataType.DOUBLE,
            PersistentDataType.DOUBLE, PersistentDataType.DOUBLE,
            PersistentDataType.DOUBLE, PersistentDataType.INTEGER, PersistentDataType.INTEGER,
            new BooleanTagType(), new UUIDTagType()
    };

    private YNamespacedKeys() { }

    private static NamespacedKey create(String path) {
        return new NamespacedKey(PLUGIN, "yarpg_" + path);
    }

    public static NamespacedKey[] getAllItemNamespacedKeys() {
        return ALL_ITEM_NAME_SPACED_KEYS;
    }

    public static PersistentDataType[] getAllItemDataType() {
        return ALL_ITEM_DATA_TYPE;
    }

}