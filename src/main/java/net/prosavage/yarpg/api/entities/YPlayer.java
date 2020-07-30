package net.prosavage.yarpg.api.entities;

import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.utilities.Equation;
import net.prosavage.yarpg.utilities.NumberFormat;
import net.prosavage.yarpg.utilities.Placeholders;
import net.prosavage.yarpg.utilities.keys.YNamespacedKeys;
import net.prosavage.yarpg.utilities.tagtypes.BooleanTagType;
import org.bukkit.EntityEffect;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class YPlayer {

    Equation equation = new Equation();

    Player player;
    PersistentDataContainer persistentDataContainer;
    NumberFormat numberFormat = new NumberFormat();

    public YPlayer(Player player){
        this.player = player;
        this.persistentDataContainer = this.player.getPersistentDataContainer();
    }

    public YPlayer(Player player, int level, double experience, double maximumExperience){
        this.player = player;
        this.persistentDataContainer = this.player.getPersistentDataContainer();
        persistentDataContainer.set(YNamespacedKeys.PLAYER_LEVEL, PersistentDataType.INTEGER, level);
        persistentDataContainer.set(YNamespacedKeys.PLAYER_EXPERIENCE, PersistentDataType.DOUBLE, experience);
        persistentDataContainer.set(YNamespacedKeys.PLAYER_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE, maximumExperience);
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getCharacterNumber() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_CHARACTER_NUMBER, PersistentDataType.INTEGER, 1);
    }

    public String getPlayerClass() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_CLASS, PersistentDataType.STRING, "Unspecialized");
    }

    public int getLevel() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_LEVEL, PersistentDataType.INTEGER, 1);
    }

    public double getExperience() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_EXPERIENCE, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMaximumExperience() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE, 0.0);
    }

    public double getHealth(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_HEALTH, PersistentDataType.DOUBLE, 0.01);
    }

    public double getMaximumHealth(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_MAXIMUM_HEALTH, PersistentDataType.DOUBLE, 0.0);
    }

    public double getBaseHealth(){
        return equation.parseDouble(YaRPG.getInstance().getConfig().getString("formulas.player.base_health"));
    }

    public double getRegeneration(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_REGENERATION, PersistentDataType.DOUBLE, 0.0);
    }

    public double getProtection(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_PROTECTION, PersistentDataType.DOUBLE, 0.0);
    }

    public int getAttributePoints(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_ATTRIBUTE_POINTS, PersistentDataType.INTEGER, 0);
    }

    public int getStrength(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_ATTRIBUTE_STRENGTH, PersistentDataType.INTEGER, 0);
    }

    public int getIntelligence(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_ATTRIBUTE_INTELLIGENCE, PersistentDataType.INTEGER, 0);
    }

    public int getConstitution(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_ATTRIBUTE_CONSTITUTION, PersistentDataType.INTEGER, 0);
    }

    public int getDexterity(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_ATTRIBUTE_DEXTERITY, PersistentDataType.INTEGER, 0);
    }

    public int getCharisma(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_ATTRIBUTE_CHARISMA, PersistentDataType.INTEGER, 0);
    }

    public int getWisdom(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_ATTRIBUTE_WISDOM, PersistentDataType.INTEGER, 0);
    }

    public int getLuck(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_ATTRIBUTE_LUCK, PersistentDataType.INTEGER, 0);
    }

    public long getCombatTagTime(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_COMBAT_TAG_TIME, PersistentDataType.LONG, (long) 0);
    }

    public boolean isCombatTagged(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_COMBAT_TAGGED, new BooleanTagType(), false);
    }

    public boolean hasCombatLogged(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.PLAYER_LOGGED_OUT_IN_COMBAT, new BooleanTagType(), false);
    }

    public boolean hasData(){
        return this.persistentDataContainer.has(YNamespacedKeys.PLAYER_CHARACTER_NUMBER, PersistentDataType.INTEGER)
                && this.persistentDataContainer.has(YNamespacedKeys.PLAYER_CLASS, PersistentDataType.STRING)
                && this.persistentDataContainer.has(YNamespacedKeys.PLAYER_LEVEL, PersistentDataType.INTEGER)
                && this.persistentDataContainer.has(YNamespacedKeys.PLAYER_EXPERIENCE, PersistentDataType.DOUBLE)
                && this.persistentDataContainer.has(YNamespacedKeys.PLAYER_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE)
                && this.persistentDataContainer.has(YNamespacedKeys.PLAYER_HEALTH, PersistentDataType.DOUBLE)
                && this.persistentDataContainer.has(YNamespacedKeys.PLAYER_MAXIMUM_HEALTH, PersistentDataType.DOUBLE);
    }

    public YPlayer setCharacterNumber(int characterNumber) {
        persistentDataContainer.set(YNamespacedKeys.PLAYER_CHARACTER_NUMBER, PersistentDataType.INTEGER, characterNumber);
        return this;
    }

    public YPlayer setPlayerClass(String playerClass) {
        persistentDataContainer.set(YNamespacedKeys.PLAYER_CLASS, PersistentDataType.STRING, playerClass);
        return this;
    }

    public YPlayer setLevel(int level) {
        persistentDataContainer.set(YNamespacedKeys.PLAYER_LEVEL, PersistentDataType.INTEGER, level);
        return this;
    }

    public YPlayer setExperience(double experience) {
        persistentDataContainer.set(YNamespacedKeys.PLAYER_EXPERIENCE, PersistentDataType.DOUBLE, experience);
        return this;
    }

    public YPlayer setMaximumExperience(double maximumExperience) {
        if (maximumExperience == 0.0) {
            double result = equation.parseDouble(new Placeholders(player, "player", YaRPG.getInstance().getConfig().getString("formulas.player.maximum_experience")).parse());
            this.persistentDataContainer.set(YNamespacedKeys.PLAYER_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE, result);
        }else{
            this.persistentDataContainer.set(YNamespacedKeys.PLAYER_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE, maximumExperience);
        }
        return this;
    }

    public YPlayer setHealth(double health){
        if (health > getMaximumHealth()) health = getMaximumHealth();
        this.persistentDataContainer.set(YNamespacedKeys.PLAYER_HEALTH, PersistentDataType.DOUBLE, health);
        updateHealth();
        return this;
    }

    public YPlayer setMaximumHealth(double maximumHealth){
        this.persistentDataContainer.set(YNamespacedKeys.PLAYER_MAXIMUM_HEALTH, PersistentDataType.DOUBLE, maximumHealth);
        updateHealth();
        return this;
    }

    public YPlayer setRegeneration(double regeneration){
        this.persistentDataContainer.set(YNamespacedKeys.PLAYER_REGENERATION, PersistentDataType.DOUBLE, regeneration);
        return this;
    }

    public YPlayer setProtection(double protection){
        this.persistentDataContainer.set(YNamespacedKeys.PLAYER_PROTECTION, PersistentDataType.DOUBLE, protection);
        return this;
    }

    public YPlayer setAttributePoints(int attributePoints){
        this.persistentDataContainer.set(YNamespacedKeys.PLAYER_ATTRIBUTE_POINTS, PersistentDataType.INTEGER, attributePoints);
        return this;
    }

    public YPlayer setStrength(int strength){
        this.persistentDataContainer.set(YNamespacedKeys.PLAYER_ATTRIBUTE_STRENGTH, PersistentDataType.INTEGER, strength);
        return this;
    }

    public YPlayer setIntelligence(int intelligence){
        this.persistentDataContainer.set(YNamespacedKeys.PLAYER_ATTRIBUTE_INTELLIGENCE, PersistentDataType.INTEGER, intelligence);
        return this;
    }

    public YPlayer setConstitution(int constitution){
        this.persistentDataContainer.set(YNamespacedKeys.PLAYER_ATTRIBUTE_CONSTITUTION, PersistentDataType.INTEGER, constitution);
        return this;
    }

    public YPlayer setDexterity(int dexterity){
        this.persistentDataContainer.set(YNamespacedKeys.PLAYER_ATTRIBUTE_DEXTERITY, PersistentDataType.INTEGER, dexterity);
        return this;
    }

    public YPlayer setCharisma(int charisma){
        this.persistentDataContainer.set(YNamespacedKeys.PLAYER_ATTRIBUTE_CHARISMA, PersistentDataType.INTEGER, charisma);
        return this;
    }

    public YPlayer setWisdom(int wisdom){
        this.persistentDataContainer.set(YNamespacedKeys.PLAYER_ATTRIBUTE_WISDOM, PersistentDataType.INTEGER, wisdom);
        return this;
    }

    public YPlayer setLuck(int luck){
        this.persistentDataContainer.set(YNamespacedKeys.PLAYER_ATTRIBUTE_LUCK, PersistentDataType.INTEGER, luck);
        return this;
    }

    public YPlayer setCombatTagged(boolean tagged){
        this.persistentDataContainer.set(YNamespacedKeys.PLAYER_COMBAT_TAGGED, new BooleanTagType(), tagged);
        return this;
    }

    public YPlayer setCombatTagTime(long combatTagTime){
        this.persistentDataContainer.set(YNamespacedKeys.PLAYER_COMBAT_TAG_TIME, PersistentDataType.LONG, combatTagTime);
        return this;
    }

    public YPlayer setCombatLogged(boolean logged){
        this.persistentDataContainer.set(YNamespacedKeys.PLAYER_LOGGED_OUT_IN_COMBAT, new BooleanTagType(), logged);
        return this;
    }

    public YPlayer removeCombatTag(){
        this.persistentDataContainer.remove(YNamespacedKeys.PLAYER_LOGGED_OUT_IN_COMBAT);
        this.persistentDataContainer.remove(YNamespacedKeys.PLAYER_COMBAT_TAGGED);
        this.persistentDataContainer.remove(YNamespacedKeys.PLAYER_COMBAT_TAG_TIME);
        return this;
    }

    public void setDefault(){
        setCharacterNumber(1);
        setPlayerClass("Unspecialized");
        setLevel(1);
        setExperience(0.0);
        setMaximumExperience(0.0);
        setMaximumHealth(getBaseHealth());
        setHealth(getMaximumHealth());
    }

    public void takeDamage(double damage){
        double newHealth = (getHealth()) - damage;
        this.player.damage(0.0);
        this.player.playEffect(EntityEffect.HURT);
        setHealth(newHealth);
        if (newHealth <= 0){
            this.player.setHealth(0.0);
        }
    }

    public void updateHealth(){
        double health = getHealth();
        double maxHealth = getMaximumHealth();
        if (health > maxHealth){
            health = maxHealth;
        }
        if (health < 0){
            health = 0.1;
        }
        this.player.setHealth(Math.abs(health / maxHealth) * 20);
    }

}