package net.prosavage.yarpg.api.entities.utilities;

import net.prosavage.yarpg.utilities.DefaultUtilities;
import net.prosavage.yarpg.utilities.keys.YNamespacedKeys;
import org.bukkit.EntityEffect;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public abstract class AbstractEntity {

    public LivingEntity entity;
    public PersistentDataContainer persistentDataContainer;
    public EntityEquipment entityEquipment;

    public AbstractEntity(){}

    public AbstractEntity(LivingEntity entity){
        this.entity = entity;
        this.persistentDataContainer = entity.getPersistentDataContainer();
        this.entityEquipment = entity.getEquipment();
    }

    public String getName() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_NAME, PersistentDataType.STRING, DefaultUtilities.getDefaultEntityName(this.entity));
    }

    public int getLevel() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_LEVEL, PersistentDataType.INTEGER, 1);
    }

    public double getExperience() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_EXPERIENCE, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMinimumExperience() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MINIMUM_EXPERIENCE, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMaximumExperience() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE, 0.0);
    }

    public double getHealth(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_HEALTH, PersistentDataType.DOUBLE, 0.01);
    }

    public double getMinimumHealth(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MINIMUM_HEALTH, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMaximumHealth(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MAXIMUM_HEALTH, PersistentDataType.DOUBLE, 0.0);
    }

    public double getRegeneration(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_REGENERATION, PersistentDataType.DOUBLE, 0.0);
    }

    public double getProtection(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_PROTECTION, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMinimumProtection(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MINIMUM_PROTECTION, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMaximumProtection(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MAXIMUM_PROTECTION, PersistentDataType.DOUBLE, 0.0);
    }

    public double getDamage(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_DAMAGE, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMinimumDamage(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MINIMUM_DAMAGE, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMaximumDamage(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_MAXIMUM_DAMAGE, PersistentDataType.DOUBLE, 0.0);
    }

    public int getAttributePoints(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_ATTRIBUTE_POINTS, PersistentDataType.INTEGER, 0);
    }

    public int getStrength(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_ATTRIBUTE_STRENGTH, PersistentDataType.INTEGER, 0);
    }

    public int getIntelligence(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_ATTRIBUTE_INTELLIGENCE, PersistentDataType.INTEGER, 0);
    }

    public int getConstitution(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_ATTRIBUTE_CONSTITUTION, PersistentDataType.INTEGER, 0);
    }

    public int getDexterity(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_ATTRIBUTE_DEXTERITY, PersistentDataType.INTEGER, 0);
    }

    public int getCharisma(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_ATTRIBUTE_CHARISMA, PersistentDataType.INTEGER, 0);
    }

    public int getWisdom(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_ATTRIBUTE_WISDOM, PersistentDataType.INTEGER, 0);
    }

    public int getLuck(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_ATTRIBUTE_LUCK, PersistentDataType.INTEGER, 0);
    }

    public AbstractEntity setName(String name) {
        persistentDataContainer.set(YNamespacedKeys.ENTITY_NAME, PersistentDataType.STRING, name);
        return this;
    }

    public AbstractEntity setLevel(int level) {
        persistentDataContainer.set(YNamespacedKeys.ENTITY_LEVEL, PersistentDataType.INTEGER, level);
        return this;
    }

    public AbstractEntity setExperience(double experience) {
        persistentDataContainer.set(YNamespacedKeys.ENTITY_EXPERIENCE, PersistentDataType.DOUBLE, experience);
        return this;
    }

    public AbstractEntity setMaximumExperience(double maximumExperience) {
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_MAXIMUM_EXPERIENCE, PersistentDataType.DOUBLE, maximumExperience);
        return this;
    }

    public AbstractEntity setHealth(double health){
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_HEALTH, PersistentDataType.DOUBLE, health);
        return this;
    }

    public AbstractEntity setMaximumHealth(double maximumHealth){
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_MAXIMUM_HEALTH, PersistentDataType.DOUBLE, maximumHealth);
        return this;
    }

    public AbstractEntity setRegeneration(double regeneration){
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_REGENERATION, PersistentDataType.DOUBLE, regeneration);
        return this;
    }

    public AbstractEntity setProtection(double protection){
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_PROTECTION, PersistentDataType.DOUBLE, protection);
        return this;
    }

    public AbstractEntity setAttributePoints(int attributePoints){
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_ATTRIBUTE_POINTS, PersistentDataType.INTEGER, attributePoints);
        return this;
    }

    public AbstractEntity setStrength(int strength){
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_ATTRIBUTE_STRENGTH, PersistentDataType.INTEGER, strength);
        return this;
    }

    public AbstractEntity setIntelligence(int intelligence){
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_ATTRIBUTE_INTELLIGENCE, PersistentDataType.INTEGER, intelligence);
        return this;
    }

    public AbstractEntity setConstitution(int constitution){
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_ATTRIBUTE_CONSTITUTION, PersistentDataType.INTEGER, constitution);
        return this;
    }

    public AbstractEntity setDexterity(int dexterity){
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_ATTRIBUTE_DEXTERITY, PersistentDataType.INTEGER, dexterity);
        return this;
    }

    public AbstractEntity setCharisma(int charisma){
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_ATTRIBUTE_CHARISMA, PersistentDataType.INTEGER, charisma);
        return this;
    }

    public AbstractEntity setWisdom(int wisdom){
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_ATTRIBUTE_WISDOM, PersistentDataType.INTEGER, wisdom);
        return this;
    }

    public AbstractEntity setLuck(int luck){
        this.persistentDataContainer.set(YNamespacedKeys.ENTITY_ATTRIBUTE_LUCK, PersistentDataType.INTEGER, luck);
        return this;
    }

    public void takeDamage(double damage){
        double newHealth = (getHealth()) - damage;
        entity.damage(0.0);
        entity.playEffect(EntityEffect.HURT);
        setHealth(newHealth);
        if (newHealth <= 0){
            entity.setHealth(0.0);
        }
    }

    public void updateHealth(){
        double health = getHealth();
        double maxHealth = getMaximumHealth();
        if (health > maxHealth) {
            health = maxHealth;
        }
        if (health < 0) {
            health = 0.1;
        }
        entity.setHealth(Math.abs(health / maxHealth) * 20);
    }

}
