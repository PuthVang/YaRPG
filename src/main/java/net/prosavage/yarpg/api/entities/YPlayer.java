package net.prosavage.yarpg.api.entities;

import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.api.entities.utilities.AbstractEntity;
import net.prosavage.yarpg.api.itemstacks.Armor;
import net.prosavage.yarpg.utilities.Equation;
import net.prosavage.yarpg.utilities.Placeholders;
import net.prosavage.yarpg.utilities.keys.YNamespacedKeys;
import net.prosavage.yarpg.utilities.tagtypes.BooleanTagType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class YPlayer extends AbstractEntity {

    Player player;

    public YPlayer(Player player){
        super(player);
        this.player = player;
        this.persistentDataContainer = this.player.getPersistentDataContainer();
    }

    public Player getPlayer() {
        return this.player;
    }

    public String getName() {
        return player.getDisplayName().equals("") ? player.getDisplayName() : player.getName();
    }

    public String getPlayerClass() {
        String defaultClass = YaRPG.getInstance().getConfig().getString("player.default_class", "Unspecialized");
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_CLASS, PersistentDataType.STRING, defaultClass);
    }

    public double getBaseHealth() {
        return new Equation(YaRPG.getInstance().getConfig().getString("formulas.player.base_health", "100")).getDouble();
    }

    public double getBaseRegeneration() {
        return new Equation(YaRPG.getInstance().getConfig().getString("formulas.player.base_regeneration", "1")).getDouble();
    }

    public double getBaseProtection() {
        return new Equation(YaRPG.getInstance().getConfig().getString("formulas.player.base_protection", "0")).getDouble();
    }

    public int getBaseStrength() {
        return new Equation(YaRPG.getInstance().getConfig().getString("formulas.player.base_strength", "0")).getInteger();
    }

    public int getBaseIntelligence() {
        return new Equation(YaRPG.getInstance().getConfig().getString("formulas.player.base_intelligence", "0")).getInteger();
    }

    public int getBaseConstitution() {
        return new Equation(YaRPG.getInstance().getConfig().getString("formulas.player.base_constitution", "0")).getInteger();
    }

    public int getBaseDexterity() {
        return new Equation(YaRPG.getInstance().getConfig().getString("formulas.player.base_dexterity", "0")).getInteger();
    }

    public int getBaseCharisma() {
        return new Equation(YaRPG.getInstance().getConfig().getString("formulas.player.base_charisma", "0")).getInteger();
    }

    public int getBaseWisdom() {
        return new Equation(YaRPG.getInstance().getConfig().getString("formulas.player.base_wisdom", "0")).getInteger();
    }

    public int getBaseLuck() {
        return new Equation(YaRPG.getInstance().getConfig().getString("formulas.player.base_luck", "0")).getInteger();
    }

    public long getCombatTagTime(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_COMBAT_TAG_TIME, PersistentDataType.LONG, (long) 0);
    }

    public boolean isCombatTagged(){
        return YaRPG.getInstance().getCombatTagManager().isExpired(this.player);
    }

    public boolean hasCombatLogged(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_LOGGED_OUT_IN_COMBAT, new BooleanTagType(), false);
    }

    public boolean hasData(){
        boolean useCustomHealth = YaRPG.getInstance().getConfig().getBoolean("settings.use_custom_health", false);

        boolean data = this.persistentDataContainer.has(YNamespacedKeys.ENTITY_CLASS, PersistentDataType.STRING)
                && this.persistentDataContainer.has(YNamespacedKeys.ENTITY_LEVEL, PersistentDataType.INTEGER)
                && this.persistentDataContainer.has(YNamespacedKeys.ENTITY_EXPERIENCE, PersistentDataType.DOUBLE)
                && this.persistentDataContainer.has(YNamespacedKeys.ENTITY_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE);
        boolean health = this.persistentDataContainer.has(YNamespacedKeys.ENTITY_HEALTH, PersistentDataType.DOUBLE)
                && this.persistentDataContainer.has(YNamespacedKeys.ENTITY_MAXIMUM_HEALTH, PersistentDataType.DOUBLE);

        return data && (!useCustomHealth || health);
    }

    public YPlayer setPlayerClass(String playerClass) {
        persistentDataContainer.set(YNamespacedKeys.ENTITY_CLASS, PersistentDataType.STRING, playerClass);
        return this;
    }

    public YPlayer setMaximumExperience(double maximumExperience) {
        if (maximumExperience <= 0.0) {
            double result = new Equation(new Placeholders(player, "player", YaRPG.getInstance().getConfig().getString("formulas.player.maximum_experience")).parse()).getDouble();
            this.persistentDataContainer.set(YNamespacedKeys.ENTITY_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE, result);
        }else{
            this.persistentDataContainer.set(YNamespacedKeys.ENTITY_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE, maximumExperience);
        }
        return this;
    }

    public YPlayer setCombatTagged(boolean tagged){
        if (tagged) YaRPG.getInstance().getCombatTagManager().addPlayer(player);
        else YaRPG.getInstance().getCombatTagManager().removePlayer(player);
        return this;
    }

    public YPlayer setCombatTagTime(long combatTagTime){
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_COMBAT_TAG_TIME, PersistentDataType.LONG, combatTagTime);
        return this;
    }

    public YPlayer setCombatLogged(boolean logged){
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_LOGGED_OUT_IN_COMBAT, new BooleanTagType(), logged);
        return this;
    }

    public YPlayer removeCombatTag(){
        this.persistentDataContainer.remove(YNamespacedKeys.ENTITY_LOGGED_OUT_IN_COMBAT);
        this.persistentDataContainer.remove(YNamespacedKeys.ENTITY_COMBAT_TAGGED);
        this.persistentDataContainer.remove(YNamespacedKeys.ENTITY_COMBAT_TAG_TIME);
        return this;
    }

    public void setDefaultData(){
        if (hasData()) {
            return;
        }

        setPlayerClass(getPlayerClass());
        setLevel(getLevel());
        setMaximumExperience(getMaximumExperience());
        setExperience(getExperience());
        setMaximumHealth(getBaseHealth());
        setHealth(getBaseHealth());
    }

    public void calculateArmorAttributesAndApply() {

        ItemStack helmet = player.getInventory().getHelmet() != null ? player.getInventory().getHelmet() : new ItemStack(Material.STONE);
        ItemStack chestplate = player.getInventory().getChestplate() != null ? player.getInventory().getChestplate() : new ItemStack(Material.STONE);
        ItemStack leggings = player.getInventory().getLeggings() != null ? player.getInventory().getLeggings() : new ItemStack(Material.STONE);
        ItemStack boots = player.getInventory().getBoots() != null ? player.getInventory().getBoots() : new ItemStack(Material.STONE);

        Armor helmetArmor = new Armor(helmet);
        Armor chestplateArmor = new Armor(chestplate);
        Armor leggingsArmor = new Armor(leggings);
        Armor bootsArmor = new Armor(boots);

        int health = (int) (helmetArmor.getHealth() + chestplateArmor.getHealth() + leggingsArmor.getHealth() + bootsArmor.getHealth());
        double regeneration = helmetArmor.getRegeneration() + chestplateArmor.getRegeneration() + leggingsArmor.getRegeneration() + bootsArmor.getRegeneration();
        double protection = helmetArmor.getProtection() + chestplateArmor.getProtection() + leggingsArmor.getProtection() + bootsArmor.getProtection();
        int strength = helmetArmor.getStrength() + chestplateArmor.getStrength() + leggingsArmor.getStrength() + bootsArmor.getStrength();
        int intelligence = helmetArmor.getIntelligence() + chestplateArmor.getIntelligence() + leggingsArmor.getIntelligence() + bootsArmor.getIntelligence();
        int constitution = helmetArmor.getConstitution() + chestplateArmor.getConstitution() + leggingsArmor.getConstitution() + bootsArmor.getConstitution();
        int dexterity = helmetArmor.getDexterity() + chestplateArmor.getDexterity() + leggingsArmor.getDexterity() + bootsArmor.getDexterity();
        int charisma = helmetArmor.getCharisma() + chestplateArmor.getCharisma() + leggingsArmor.getCharisma() + bootsArmor.getCharisma();
        int wisdom = helmetArmor.getWisdom() + chestplateArmor.getWisdom() + leggingsArmor.getWisdom() + bootsArmor.getWisdom();
        int luck = helmetArmor.getLuck() + chestplateArmor.getLuck() + leggingsArmor.getLuck() + bootsArmor.getLuck();

        setMaximumHealth(getBaseHealth() + health);
        setRegeneration(getBaseRegeneration() + regeneration);
        setProtection(getBaseProtection() + protection);
        setStrength(getBaseStrength() + strength);
        setIntelligence(getBaseIntelligence() + intelligence);
        setConstitution(getBaseConstitution() + constitution);
        setDexterity(getBaseDexterity() + dexterity);
        setCharisma(getBaseCharisma() + charisma);
        setWisdom(getBaseWisdom() + wisdom);
        setLuck(getBaseLuck() + luck);

    }

}