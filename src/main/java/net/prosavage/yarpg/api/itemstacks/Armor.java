package net.prosavage.yarpg.api.itemstacks;

import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.api.files.ArmorFiles;
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
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Armor extends AbstractItemUtil {



    public Armor(String stringMaterial) {
        super(stringMaterial);
        naturalItem = true;
    }

    public Armor(ItemStack itemStack) {
        super(itemStack);
        naturalItem = true;
    }

    public Armor(Material type) {
        super(type);
        naturalItem = true;
    }

    public Armor(String rarity, String name){
        super(rarity, name);
        ArmorFiles armorFiles = new ArmorFiles(fileRarity, fileName);
        if (armorFiles.exist()) {
            validFile = true;
            itemStack = new ItemStack(Material.matchMaterial(armorFiles.getActualMaterial()));
            meta = itemStack.getItemMeta();
            persistentDataContainer = meta.getPersistentDataContainer();
            setName(name.replace(".yml", ""));
            setMaterial(armorFiles.getCosmeticMaterial());
            setRarity(armorFiles.getRarity());
            setDescription(armorFiles.getDescription());
            setLevel(INumber.getInteger(armorFiles.getMinimumLevel(), armorFiles.getMaximumLevel()));
            setRequiredStrength(armorFiles.getRequiredStrength());
            setRequiredIntelligence(armorFiles.getRequiredIntelligence());
            setRequiredConsitution(armorFiles.getRequiredConsitution());
            setRequiredDexterity(armorFiles.getRequiredDexterity());
            setRequiredCharisma(armorFiles.getRequiredCharisma());
            setRequiredWisdom(armorFiles.getRequiredWisdom());
            setRequiredLuck(armorFiles.getRequiredLuck());
            setMaximumHealth(armorFiles.getMaximumHealth());
            setMinimumHealth(armorFiles.getMinimumHealth());
            setMaximumRegeneration(armorFiles.getMaximumRegeneration());
            setMinimumRegeneration(armorFiles.getMinimumRegeneration());
            setMinimumProtection(armorFiles.getMinimumProtection());
            setMaximumProtection(armorFiles.getMaximumProtection());
            setStrength(armorFiles.getStrength());
            setIntelligence(armorFiles.getIntelligence());
            setConstitution(armorFiles.getConstitution());
            setDexterity(armorFiles.getDexterity());
            setCharisma(armorFiles.getCharisma());
            setWisdom(armorFiles.getWisdom());
            setLuck(armorFiles.getLuck());
            setGems(INumber.getInteger(armorFiles.getMinimumGem(), armorFiles.getMaximumGem()));
            setScrolls(INumber.getInteger(armorFiles.getMinimumScroll(), armorFiles.getMaximumGem()));
            setUnbreakable();
        }
    }

    public String getName(){
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
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_REQUIRED_STRENGTH, PersistentDataType.INTEGER, 0);
    }

    public int getRequiredIntelligence() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_REQUIRED_INTELLIGENCE, PersistentDataType.INTEGER, 0);
    }

    public int getRequiredConstitution() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_REQUIRED_CONSTITUTION, PersistentDataType.INTEGER, 0);
    }

    public int getRequiredDexterity() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_REQUIRED_DEXTERITY, PersistentDataType.INTEGER, 0);
    }

    public int getRequiredCharisma() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_REQUIRED_CHARISMA, PersistentDataType.INTEGER, 0);
    }

    public int getRequiredWisdom() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_REQUIRED_WISDOM, PersistentDataType.INTEGER, 0);
    }

    public int getRequiredLuck() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_REQUIRED_LUCK, PersistentDataType.INTEGER, 0);
    }

    public double getHealth(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_HEALTH, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMinimumHealth(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_MINIMUM_HEALTH, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMaximumHealth(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_MAXIMUM_HEALTH, PersistentDataType.DOUBLE, 0.0);
    }

    public double getRegeneration(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_REGENERATION, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMinimumRegeneration(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_MINIMUM_REGENERATION, PersistentDataType.DOUBLE, 0.0);
    }

    public double getProtection(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_PROTECTION, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMaximumProtection(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_MAXIMUM_PROTECTION, PersistentDataType.DOUBLE, 1.0);
    }

    public double getMinimumProtection(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_MINIMUM_PROTECTION, PersistentDataType.DOUBLE, 0.0);
    }

    public double getMaximumRegeneration(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_MAXIMUM_REGENERATION, PersistentDataType.DOUBLE, 1.0);
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

    public boolean getUnbreakable(){
        return this.meta.isUnbreakable();
    }

    public boolean isSpawnedIn(){
        return this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_GEM, new BooleanTagType(), false);
    }

    public OfflinePlayer getItemCreator(){
        UUID uuid = this.persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_CREATOR_PLAYER, new UUIDTagType(), null);
        return Bukkit.getOfflinePlayer(uuid);
    }

    public Armor setName(String name) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_NAME, PersistentDataType.STRING, name);
        return this;
    }

    public Armor setMaterial(String material) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_MATERIAL, PersistentDataType.STRING, material);
        return this;
    }

    public Armor setRarity(String rarity) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_RARITY, PersistentDataType.STRING, rarity);
        return this;
    }


    public Armor setDescription(String string) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_DESCRIPTION, PersistentDataType.STRING, string);
        return this;
    }

    public Armor setDescription(List<String> string) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_DESCRIPTION, PersistentDataType.STRING, String.join("||", string));
        return this;
    }

    public Armor setLevel(int level) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_LEVEL, PersistentDataType.INTEGER, level);
        return this;
    }

    public Armor setRequiredStrength(int strength) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_REQUIRED_STRENGTH, PersistentDataType.INTEGER, strength);
        return this;
    }

    public Armor setRequiredIntelligence(int intelligence) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_REQUIRED_INTELLIGENCE, PersistentDataType.INTEGER, intelligence);
        return this;
    }

    public Armor setRequiredConsitution(int consitution) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_REQUIRED_CONSTITUTION, PersistentDataType.INTEGER, consitution);
        return this;
    }

    public Armor setRequiredDexterity(int dexterity) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_REQUIRED_DEXTERITY, PersistentDataType.INTEGER, dexterity);
        return this;
    }

    public Armor setRequiredCharisma(int charisma) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_REQUIRED_CHARISMA, PersistentDataType.INTEGER, charisma);
        return this;
    }

    public Armor setRequiredWisdom(int wisdom) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_REQUIRED_WISDOM, PersistentDataType.INTEGER, wisdom);
        return this;
    }

    public Armor setRequiredLuck(int luck) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_REQUIRED_LUCK, PersistentDataType.INTEGER, luck);
        return this;
    }

    public Armor setHealth(double health) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_HEALTH, PersistentDataType.DOUBLE, health);
        return this;
    }

    public Armor setMaximumHealth(double maximumHealth) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_MAXIMUM_HEALTH, PersistentDataType.DOUBLE, maximumHealth);
        return this;
    }

    public Armor setMinimumHealth(double minimumHealth) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_MINIMUM_HEALTH, PersistentDataType.DOUBLE, minimumHealth);
        return this;
    }

    public Armor setRegeneration(double regeneration) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_REGENERATION, PersistentDataType.DOUBLE, regeneration);
        return this;
    }

    public Armor setMaximumRegeneration(double maximumRegeneration) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_MAXIMUM_REGENERATION, PersistentDataType.DOUBLE, maximumRegeneration);
        return this;
    }

    public Armor setMinimumRegeneration(double minimumRegeneration) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_MINIMUM_REGENERATION, PersistentDataType.DOUBLE, minimumRegeneration);
        return this;
    }

    public Armor setProtection(double protection) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_PROTECTION, PersistentDataType.DOUBLE, protection);
        return this;
    }

    public Armor setMinimumProtection(double minimumProtection) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_MINIMUM_PROTECTION, PersistentDataType.DOUBLE, minimumProtection);
        return this;
    }

    public Armor setMaximumProtection(double maximumProtection) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_MAXIMUM_PROTECTION, PersistentDataType.DOUBLE, maximumProtection);
        return this;
    }

    public Armor setStrength(int strength) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_STRENGTH, PersistentDataType.INTEGER, strength);
        return this;
    }

    public Armor setIntelligence(int intelligence) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_INTELLIGENCE, PersistentDataType.INTEGER, intelligence);
        return this;
    }

    public Armor setConstitution(int constitution) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_CONSTITUTION, PersistentDataType.INTEGER, constitution);
        return this;
    }

    public Armor setDexterity(int dexterity) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_DEXTERITY, PersistentDataType.INTEGER, dexterity);
        return this;
    }

    public Armor setCharisma(int charisma) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_CHARISMA, PersistentDataType.INTEGER, charisma);
        return this;
    }

    public Armor setWisdom(int wisdom) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_WISDOM, PersistentDataType.INTEGER, wisdom);
        return this;
    }

    public Armor setLuck(int luck) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_LUCK, PersistentDataType.INTEGER, luck);
        return this;
    }

    public Armor setGems(int gems) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_GEM, PersistentDataType.INTEGER, gems);
        return this;
    }

    public Armor setScrolls(int scrolls) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_SCROLL, PersistentDataType.INTEGER, scrolls);
        return this;
    }

    public Armor setItemCreator(Player itemCreator){
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_CREATOR_PLAYER, new UUIDTagType(), itemCreator.getUniqueId());
        return this;
    }

    public Armor setSpawnedIn(boolean spawnedIn) {
        this.persistentDataContainer.set(YNamespacedKeys.ITEM_IS_SPAWNED_IN, new BooleanTagType(), spawnedIn);
        return this;
    }

    public ItemStack build() {
        if (validFile || naturalItem) {
            List<String> itemLore = YaRPG.getInstance().getConfig().getStringList("armor.lore");
            removeUnusedNamespacedKeys();
            meta.setDisplayName(getName());
            setHealth(INumber.getDouble(getMinimumHealth(), getMaximumHealth()));
            setRegeneration(INumber.getDouble(getMinimumRegeneration(), getMaximumRegeneration()));
            setProtection(INumber.getDouble(getMinimumProtection(), getMaximumProtection()));
            itemLore = parseBasicLore(itemLore, getRarity(), getMaterial(), getLevel());
            itemLore = parseGainedStatsLore(itemLore, getHealth(),
                    getRegeneration(), getProtection());
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
            itemStack.setItemMeta(this.meta);
            return itemStack;
        }
        return null;
    }

}
