package net.prosavage.yarpg.utilities.keys;

import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.utilities.tagtypes.BooleanTagType;
import net.prosavage.yarpg.utilities.tagtypes.UUIDTagType;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

public final class YNamespacedKeys {

    private static final YaRPG PLUGIN = YaRPG.getInstance();

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

    public static final NamespacedKey ENTITY_NAME = create("entity_name");
    public static final NamespacedKey ENTITY_LEVEL = create("entity_level");
    public static final NamespacedKey ENTITY_HEALTH = create("entity_health");
    public static final NamespacedKey ENTITY_MINIMUM_HEALTH = create("entity_minimum_health");
    public static final NamespacedKey ENTITY_MAXIMUM_HEALTH = create("entity_maximum_health");
    public static final NamespacedKey ENTITY_EXPERIENCE = create("entity_experience");
    public static final NamespacedKey ENTITY_MINIMUM_EXPERIENCE = create("entity_minimum_experience");
    public static final NamespacedKey ENTITY_MAXIMUM_EXPERIENCE = create("entity_maximum_experience");
    public static final NamespacedKey ENTITY_DAMAGE = create("entity_damage");
    public static final NamespacedKey ENTITY_MINIMUM_DAMAGE = create("entity_minimum_damage");
    public static final NamespacedKey ENTITY_MAXIMUM_DAMAGE = create("entity_maximum_damage");
    public static final NamespacedKey ENTITY_PROTECTION = create("entity_protection");
    public static final NamespacedKey ENTITY_MINIMUM_PROTECTION = create("entity_minimum_protection");
    public static final NamespacedKey ENTITY_MAXIMUM_PROTECTION = create("entity_maximum_protection");
    public static final NamespacedKey ENTITY_YARPG_DROPS = create("entity_yarpg_drops");
    public static final NamespacedKey ENTITY_YARPG_DROP_CHANCE = create("entity_yarpg_drop_chance");

    public static final NamespacedKey PLAYER_CHARACTER_NUMBER = create("player_character_number");
    public static final NamespacedKey PLAYER_CLASS = create("player_class");
    public static final NamespacedKey PLAYER_LEVEL = create("player_level");
    public static final NamespacedKey PLAYER_EXPERIENCE = create("player_experience");
    public static final NamespacedKey PLAYER_MAXIMUM_EXPERIENCE = create("player_maximum_experience");
    public static final NamespacedKey PLAYER_HEALTH = create("player_health");
    public static final NamespacedKey PLAYER_MAXIMUM_HEALTH = create("player_maximum_health");
    public static final NamespacedKey PLAYER_PROTECTION = create("player_protection");
    public static final NamespacedKey PLAYER_REGENERATION = create("player_regeneration");
    public static final NamespacedKey PLAYER_COMBAT_TAGGED = create("player_combat_tagged");
    public static final NamespacedKey PLAYER_COMBAT_TAG_TIME = create("player_combat_tag_time");
    public static final NamespacedKey PLAYER_LOGGED_OUT_IN_COMBAT = create("player_logged_out_in_combat");
    public static final NamespacedKey PLAYER_ATTRIBUTE_POINTS = create("player_attribute_points");
    public static final NamespacedKey PLAYER_ATTRIBUTE_STRENGTH = create("player_attribute_strength");
    public static final NamespacedKey PLAYER_ATTRIBUTE_INTELLIGENCE = create("player_attribute_intelligence");
    public static final NamespacedKey PLAYER_ATTRIBUTE_CONSTITUTION = create("player_attribute_constitution");
    public static final NamespacedKey PLAYER_ATTRIBUTE_DEXTERITY = create("player_attribute_dexterity");
    public static final NamespacedKey PLAYER_ATTRIBUTE_CHARISMA = create("player_attribute_charisma");
    public static final NamespacedKey PLAYER_ATTRIBUTE_WISDOM = create("player_attribute_wisdom");
    public static final NamespacedKey PLAYER_ATTRIBUTE_LUCK = create("player_attribute_luck");

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