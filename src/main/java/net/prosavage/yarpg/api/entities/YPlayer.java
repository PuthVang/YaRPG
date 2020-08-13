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
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_NAME, PersistentDataType.STRING, player.getName());
    }

    public int getCharacterNumber() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_CHARACTER_NUMBER, PersistentDataType.INTEGER, 1);
    }

    public String getPlayerClass() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_CLASS, PersistentDataType.STRING, "Unspecialized");
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
        return this.persistentDataContainer.has(YNamespacedKeys.ENTITY_CHARACTER_NUMBER, PersistentDataType.INTEGER)
                && this.persistentDataContainer.has(YNamespacedKeys.ENTITY_CLASS, PersistentDataType.STRING)
                && this.persistentDataContainer.has(YNamespacedKeys.ENTITY_LEVEL, PersistentDataType.INTEGER)
                && this.persistentDataContainer.has(YNamespacedKeys.ENTITY_EXPERIENCE, PersistentDataType.DOUBLE)
                && this.persistentDataContainer.has(YNamespacedKeys.ENTITY_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE)
                && this.persistentDataContainer.has(YNamespacedKeys.ENTITY_HEALTH, PersistentDataType.DOUBLE)
                && this.persistentDataContainer.has(YNamespacedKeys.ENTITY_MAXIMUM_HEALTH, PersistentDataType.DOUBLE);
    }

    public YPlayer setCharacterNumber(int characterNumber) {
        persistentDataContainer.set(YNamespacedKeys.ENTITY_CHARACTER_NUMBER, PersistentDataType.INTEGER, characterNumber);
        return this;
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

    public void setDefault(){
        setCharacterNumber(1);
        setPlayerClass("Unspecialized");
        setLevel(1);
        setExperience(0.0);
        setMaximumExperience(-1.0);
        setMaximumHealth(getBaseHealth());
        setHealth(getMaximumHealth());
    }

}