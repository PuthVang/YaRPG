package net.prosavage.yarpg.api.itemstacks;

import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.api.files.WeaponFiles;
import net.prosavage.yarpg.api.itemstacks.utilities.AbstractItemUtil;
import net.prosavage.yarpg.utilities.Color;
import net.prosavage.yarpg.utilities.DefaultUtilities;
import net.prosavage.yarpg.utilities.INumber;
import net.prosavage.yarpg.utilities.keys.YNamespacedKeys;
import net.prosavage.yarpg.utilities.tagtypes.BooleanTagType;
import net.prosavage.yarpg.utilities.tagtypes.UUIDTagType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Weapon extends AbstractItemUtil {



    private boolean isMelee = false;
    private boolean isRanged = false;

    public Weapon(String stringMaterial) {
        super(stringMaterial);
    }

    public Weapon(ItemStack itemStack) {
        super(itemStack);
    }

    public Weapon(Material type) {
        super(type);
    }

    public Weapon(String rarity, String name) {
        super(rarity, name);
        WeaponFiles weaponFiles = new WeaponFiles(fileRarity, fileName);
        if (weaponFiles.exist()) {
            validFile = true;
            itemStack = new ItemStack(Material.valueOf(weaponFiles.getActualMaterial()));
            meta = itemStack.getItemMeta();
            persistentDataContainer = meta.getPersistentDataContainer();
            setName(name.replace(".yml", ""));
            setMaterial(weaponFiles.getCosmeticMaterial());
            setRarity(weaponFiles.getRarity());
            setDescription(weaponFiles.getDescription());
            setLevel(INumber.getInteger(weaponFiles.getMinimumLevel(), weaponFiles.getMaximumLevel()));
            setRequiredStrength(weaponFiles.getRequiredStrength());
            setRequiredIntelligence(weaponFiles.getRequiredIntelligence());
            setRequiredConstitution(weaponFiles.getRequiredConstitution());
            setRequiredDexterity(weaponFiles.getRequiredDexterity());
            setRequiredCharisma(weaponFiles.getRequiredCharisma());
            setRequiredWisdom(weaponFiles.getRequiredWisdom());
            setRequiredLuck(weaponFiles.getRequiredLuck());
            setStrength(weaponFiles.getStrength());
            setIntelligence(weaponFiles.getIntelligence());
            setConstitution(weaponFiles.getConstitution());
            setDexterity(weaponFiles.getDexterity());
            setCharisma(weaponFiles.getCharisma());
            setWisdom(weaponFiles.getWisdom());
            setLuck(weaponFiles.getLuck());
            setGems(INumber.getInteger(weaponFiles.getMinimumGem(), weaponFiles.getMaximumGem()));
            setScrolls(INumber.getInteger(weaponFiles.getMinimumScroll(), weaponFiles.getMaximumGem()));

            setMeleeMinimumDamage(weaponFiles.getMeleeMinimumDamage());
            setMeleeMaximumDamage(weaponFiles.getMeleeMaximumDamage());
            setRangedMinimumDamage(weaponFiles.getRangedMinimumDamage());
            setRangedMaximumDamage(weaponFiles.getRangedMaximumDamage());
            setAttackCooldown(weaponFiles.getAttackCooldown());

            setName(weaponFiles.getName());
        }
    }

    public String getName() {
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_NAME, PersistentDataType.STRING, DefaultUtilities.getDefaultName(this.itemStack));
    }

    public String getMaterial(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_MATERIAL, PersistentDataType.STRING, DefaultUtilities.getDefaultMaterial(this.itemStack));
    }

    public String getRarity(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_RARITY, PersistentDataType.STRING, "Common");
    }

    public List<String> getDescription(){
        return Arrays.asList(this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_DESCRIPTION, PersistentDataType.STRING, "null").split("\\|\\|"));
    }

    public int getLevel(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_LEVEL, PersistentDataType.INTEGER, 1);
    }

    public int getRequiredStrength() {
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_REQUIRED_STRENGTH, PersistentDataType.INTEGER, 0);
    }

    public int getRequiredIntelligence() {
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_REQUIRED_INTELLIGENCE, PersistentDataType.INTEGER, 0);
    }

    public int getRequiredConstitution() {
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_REQUIRED_CONSTITUTION, PersistentDataType.INTEGER, 0);
    }

    public int getRequiredDexterity() {
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_REQUIRED_DEXTERITY, PersistentDataType.INTEGER, 0);
    }

    public int getRequiredCharisma() {
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_REQUIRED_CHARISMA, PersistentDataType.INTEGER, 0);
    }

    public int getRequiredWisdom() {
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_REQUIRED_WISDOM, PersistentDataType.INTEGER, 0);
    }

    public int getRequiredLuck() {
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_REQUIRED_LUCK, PersistentDataType.INTEGER, 0);
    }

    public double getMeleeMinimumDamage(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_MELEE_MINIMUM_DAMAGE, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMeleeMaximumDamage(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_MELEE_MAXIMUM_DAMAGE, PersistentDataType.DOUBLE, 1.0);
    }

    public double getRangedMinimumDamage(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_RANGED_MINIMUM_DAMAGE, PersistentDataType.DOUBLE, 0.0);
    }

    public double getRangedMaximumDamage(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_RANGED_MAXIMUM_DAMAGE, PersistentDataType.DOUBLE, 1.0);
    }

    public double getAttackCooldown(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_ATTACK_COOLDOWN, PersistentDataType.DOUBLE, 1.0);
    }

    public int getStrength() {
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_STRENGTH, PersistentDataType.INTEGER, 0);
    }

    public int getIntelligence() {
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_INTELLIGENCE, PersistentDataType.INTEGER, 0);
    }

    public int getConstitution() {
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_CONSTITUTION, PersistentDataType.INTEGER, 0);
    }

    public int getDexterity() {
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_DEXTERITY, PersistentDataType.INTEGER, 0);
    }

    public int getCharisma() {
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_CHARISMA, PersistentDataType.INTEGER, 0);
    }

    public int getWisdom() {
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_WISDOM, PersistentDataType.INTEGER, 0);
    }

    public int getLuck() {
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_LUCK, PersistentDataType.INTEGER, 0);
    }

    public int getGems(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_GEM, PersistentDataType.INTEGER, 0);
    }

    public int getScrolls(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_SCROLL, PersistentDataType.INTEGER, 0);
    }

    public boolean isSpawnedIn(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_GEM, new BooleanTagType(), false);
    }

    public OfflinePlayer getItemCreator(){
        UUID uuid = this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_CREATOR_PLAYER, new UUIDTagType(), null);
        return Bukkit.getOfflinePlayer(uuid);
    }

    public Weapon setName(String name) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_NAME, PersistentDataType.STRING, name);
        return this;
    }

    public Weapon setMaterial(String material){
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_MATERIAL, PersistentDataType.STRING, material);
        return this;
    }

    public Weapon setRarity(String rarity){
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_RARITY, PersistentDataType.STRING, rarity);
        return this;
    }

    public Weapon setDescription(List<String> description){
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_DESCRIPTION, PersistentDataType.STRING, String.join("||", description));
        return this;
    }

    public Weapon setDescription(String description){
        this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_DESCRIPTION, PersistentDataType.STRING, description);
        return this;
    }

    public Weapon setLevel(int level){
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_LEVEL, PersistentDataType.INTEGER, level);
        return this;
    }

    public Weapon setRequiredStrength(int requiredStrength) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_REQUIRED_STRENGTH, PersistentDataType.INTEGER, requiredStrength);
        return this;
    }

    public Weapon setRequiredIntelligence(int requiredIntelligence) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_REQUIRED_INTELLIGENCE, PersistentDataType.INTEGER, requiredIntelligence);
        return this;
    }

    public Weapon setRequiredConstitution(int requiredConstitution) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_REQUIRED_CONSTITUTION, PersistentDataType.INTEGER, requiredConstitution);
        return this;
    }

    public Weapon setRequiredDexterity(int requiredDexterity) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_REQUIRED_DEXTERITY, PersistentDataType.INTEGER, requiredDexterity);
        return this;
    }

    public Weapon setRequiredCharisma(int requiredCharisma) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_REQUIRED_CHARISMA, PersistentDataType.INTEGER, requiredCharisma);
        return this;
    }

    public Weapon setRequiredWisdom(int requiredWisdom) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_REQUIRED_WISDOM, PersistentDataType.INTEGER, requiredWisdom);
        return this;
    }

    public Weapon setRequiredLuck(int requiredLuck) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_REQUIRED_LUCK, PersistentDataType.INTEGER, requiredLuck);
        return this;
    }

    public Weapon setMeleeMinimumDamage(double meleeMinimumDamage){
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_MELEE_MINIMUM_DAMAGE, PersistentDataType.DOUBLE, meleeMinimumDamage);
        this.isMelee = true;
        return this;
    }

    public Weapon setMeleeMaximumDamage(double meleeMaximumDamage){
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_MELEE_MAXIMUM_DAMAGE, PersistentDataType.DOUBLE, meleeMaximumDamage);
        this.isMelee = true;
        return this;
    }

    public Weapon setRangedMinimumDamage(double rangedMinimumDamage){
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_RANGED_MINIMUM_DAMAGE, PersistentDataType.DOUBLE, rangedMinimumDamage);
        this.isRanged = true;
        return this;
    }

    public Weapon setRangedMaximumDamage(double rangedMaximumDamage){
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_RANGED_MAXIMUM_DAMAGE, PersistentDataType.DOUBLE, rangedMaximumDamage);
        this.isRanged = true;
        return this;
    }

    public Weapon setAttackCooldown(double attackCooldown){
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_ATTACK_COOLDOWN, PersistentDataType.DOUBLE, attackCooldown);
        return this;
    }

    public Weapon setStrength(int strength) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_STRENGTH, PersistentDataType.INTEGER, strength);
        return this;
    }

    public Weapon setIntelligence(int intelligence) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_INTELLIGENCE, PersistentDataType.INTEGER, intelligence);
        return this;
    }

    public Weapon setConstitution(int constitution) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_CONSTITUTION, PersistentDataType.INTEGER, constitution);
        return this;
    }

    public Weapon setDexterity(int dexterity) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_DEXTERITY, PersistentDataType.INTEGER, dexterity);
        return this;
    }

    public Weapon setCharisma(int charisma) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_CHARISMA, PersistentDataType.INTEGER, charisma);
        return this;
    }

    public Weapon setWisdom(int wisdom) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_WISDOM, PersistentDataType.INTEGER, wisdom);
        return this;
    }

    public Weapon setLuck(int luck) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_LUCK, PersistentDataType.INTEGER, luck);
        return this;
    }

    public Weapon setGems(int gems){
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_GEM, PersistentDataType.INTEGER, gems);
        return this;
    }

    public Weapon setScrolls(int scrolls){
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_SCROLL, PersistentDataType.INTEGER, scrolls);
        return this;
    }

    public Weapon setItemCreator(OfflinePlayer itemCreator){
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_CREATOR_PLAYER, new UUIDTagType(), itemCreator.getUniqueId());
        return this;
    }

    @Override
    public @NotNull ItemStack build() {
        if (validFile || naturalItem) {
            List<String> itemLore = YaRPG.getInstance().getConfig().getStringList("weapon.lore");
            removeUnusedNamespacedKeys();
            itemLore = parseBasicLore(itemLore, getRarity(), getMaterial(), getLevel());
            itemLore = parseGainedStatsLore(itemLore, getMeleeMinimumDamage(), getMeleeMaximumDamage(),
                    getRangedMinimumDamage(), getRangedMaximumDamage(), getAttackCooldown());
            itemLore = parseAttributes(itemLore, getStrength(), getIntelligence(),
                    getConstitution(), getDexterity(), getCharisma(), getWisdom(), getLuck());
            itemLore = parseRequirementLore(itemLore, getRequiredStrength(), getRequiredIntelligence(), getRequiredConstitution(), getRequiredDexterity(), getRequiredCharisma(), getRequiredWisdom(), getRequiredLuck());
            itemLore = parseGemLore(itemLore, getGems());
            itemLore = parseScrollLore(itemLore, getScrolls());
            itemLore = parseDescriptionLore(itemLore, getDescription());
            itemLore = removeUnwantedLore(itemLore);
            setName(Color.ify(getName()));
            setLore(itemLore);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        }
        itemStack.setItemMeta(this.meta);
        return itemStack;
    }
}
