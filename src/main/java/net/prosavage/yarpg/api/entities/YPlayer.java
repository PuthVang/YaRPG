package net.prosavage.yarpg.api.entities;

import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.api.entities.utilities.AbstractEntity;
import net.prosavage.yarpg.utilities.Equation;
import net.prosavage.yarpg.utilities.Placeholders;
import net.prosavage.yarpg.utilities.keys.YNamespacedKeys;
import net.prosavage.yarpg.utilities.tagtypes.BooleanTagType;
import org.bukkit.entity.Player;
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
        String defaultClass = YaRPG.getInstance().getConfig().getString("player.default_class");
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_CLASS, PersistentDataType.STRING, defaultClass);
    }

    public double getBaseHealth(){
        return new Equation(YaRPG.getInstance().getConfig().getString("formulas.player.base_health")).getDouble();
    }

    public long getCombatTagTime(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_COMBAT_TAG_TIME, PersistentDataType.LONG, (long) 0);
    }

    public boolean isCombatTagged(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_COMBAT_TAGGED, new BooleanTagType(), false);
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
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_COMBAT_TAGGED, new BooleanTagType(), tagged);
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
        setExperience(getExperience());
        setMaximumExperience(getMaximumExperience());
        setHealth(getHealth());
        setMaximumHealth(getMaximumHealth());
    }

}