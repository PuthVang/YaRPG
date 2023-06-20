package net.prosavage.yarpg.api.files;

import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.utilities.YFileUtil;
import net.prosavage.yarpg.utilities.managers.FileManager;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WeaponFiles {

    FileManager fileManager = YaRPG.getInstance().getFileManager();

    private String name;
    private String extension = "";
    private String rarity;
    private final List<File> rarityFolders;
    private File weaponFile;
    private YamlConfiguration weaponConfiguration;

    public WeaponFiles(String rarity, String name){
        this.rarity = rarity;
        this.name = name.replaceAll("_", " ");
        this.rarityFolders = YFileUtil.getFolders(fileManager.getWeaponFolder());
        if (!name.endsWith(".yml")) extension = ".yml";
        this.weaponFile = new File(fileManager.getWeaponFolder() + File.separator + this.rarity + File.separator + this.name + this.extension);
        this.weaponConfiguration = YamlConfiguration.loadConfiguration(this.weaponFile);
    }

    public WeaponFiles(String rarity){
        this.rarity = rarity;
        this.rarityFolders = YFileUtil.getFolders(fileManager.getWeaponFolder());
    }

    public WeaponFiles setName(String name) {
        if (!name.endsWith(".yml")) extension = ".yml";
        String path = fileManager.getWeaponFolder() + File.separator + this.rarity + File.separator + name + this.extension;
        boolean rename = getWeaponFile().renameTo(new File(path));
        if (rename){
            this.name = name.replaceAll("_", " ");
            this.weaponFile = new File(path);
            this.weaponConfiguration = YamlConfiguration.loadConfiguration(this.weaponFile);
            try {
                weaponConfiguration.save(this.weaponFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public WeaponFiles setRarity(String rarity) {
        String path = fileManager.getWeaponFolder() + File.separator + rarity + File.separator + this.name + this.extension;
        File oldFolderFile = new File(fileManager.getWeaponFolder() + File.separator + this.rarity);
        File newFolderFile = new File(fileManager.getWeaponFolder() + File.separator + rarity);
        boolean newFolder = newFolderFile.mkdirs();
        boolean rename = getWeaponFile().renameTo(new File(path));
        if (oldFolderFile.listFiles().length == 0){
            boolean deletedFile = oldFolderFile.delete();
        }
        if (rename) {
            this.rarity = rarity;
            this.weaponFile = new File(path);
            this.weaponConfiguration = YamlConfiguration.loadConfiguration(this.weaponFile);
            try {
                weaponConfiguration.save(this.weaponFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public WeaponFiles setActualMaterial(String actualMaterial) {
        this.getWeaponConfiguration().set("item_actual_material", actualMaterial);
        return this;
    }

    public WeaponFiles setCosmeticMaterial(String cosmeticMaterial) {
        this.getWeaponConfiguration().set("item_cosmetic_material", cosmeticMaterial);
        return this;
    }

    public WeaponFiles setDescription(List<String> description) {
        this.getWeaponConfiguration().set("item_description", description);
        return this;
    }

    public WeaponFiles setMinimumLevel(int minimumLevel) {
        this.getWeaponConfiguration().set("item_minimum_level", minimumLevel);
        return this;
    }

    public WeaponFiles setMaximumLevel(int maximumLevel) {
        this.getWeaponConfiguration().set("item_maximum_level", maximumLevel);
        return this;
    }

    public WeaponFiles setRequiredStrength(int strength) {
        this.getWeaponConfiguration().set("item_required_strength", strength);
        return this;
    }

    public WeaponFiles setRequiredIntelligence(int intelligence) {
        this.getWeaponConfiguration().set("item_required_intelligence", intelligence);
        return this;
    }

    public WeaponFiles setRequiredConsitution(int consitution) {
        this.getWeaponConfiguration().set("item_required_constitution", consitution);
        return this;
    }

    public WeaponFiles setRequiredDexterity(int dexterity) {
        this.getWeaponConfiguration().set("item_required_dexterity", dexterity);
        return this;
    }

    public WeaponFiles setRequiredCharisma(int charisma) {
        this.getWeaponConfiguration().set("item_required_charisma", charisma);
        return this;
    }

    public WeaponFiles setRequiredWisdom(int wisdom) {
        this.getWeaponConfiguration().set("item_required_wisdom", wisdom);
        return this;
    }

    public WeaponFiles setRequiredLuck(int luck) {
        this.getWeaponConfiguration().set("item_required_luck", luck);
        return this;
    }

    public WeaponFiles setMeleeMinimumDamage(double minimumDamage) {
        this.getWeaponConfiguration().set("item_melee_minimum_damage", minimumDamage);
        return this;
    }

    public WeaponFiles setMeleeMaximumDamage(double maximumDamage) {
        this.getWeaponConfiguration().set("item_melee_maximum_damage", maximumDamage);
        return this;
    }

    public WeaponFiles setRangedMinimumDamage(double minimumDamage) {
        this.getWeaponConfiguration().set("item_ranged_minimum_damage", minimumDamage);
        return this;
    }

    public WeaponFiles setRangedMaximumDamage(double maximumDamage) {
        this.getWeaponConfiguration().set("item_ranged_maximum_damage", maximumDamage);
        return this;
    }

    public WeaponFiles setAttackCooldown(double attackCooldown) {
        this.getWeaponConfiguration().set("item_attack_cooldown", attackCooldown);
        return this;
    }

    public WeaponFiles setStrength(int strength) {
        this.getWeaponConfiguration().set("item_strength", strength);
        return this;
    }

    public WeaponFiles setIntelligence(int intelligence) {
        this.getWeaponConfiguration().set("item_intelligence", intelligence);
        return this;
    }

    public WeaponFiles setConstitution(int consitution) {
        this.getWeaponConfiguration().set("item_constitution", consitution);
        return this;
    }

    public WeaponFiles setDexterity(int dexterity) {
        this.getWeaponConfiguration().set("item_dexterity", dexterity);
        return this;
    }

    public WeaponFiles setCharisma(int charisma) {
        this.getWeaponConfiguration().set("item_charisma", charisma);
        return this;
    }

    public WeaponFiles setWisdom(int wisdom) {
        this.getWeaponConfiguration().set("item_wisdom", wisdom);
        return this;
    }

    public WeaponFiles setLuck(int luck) {
        this.getWeaponConfiguration().set("item_luck", luck);
        return this;
    }

    public WeaponFiles setMinimumGem(int minimumGem) {
        this.getWeaponConfiguration().set("item_minimum_gem", minimumGem);
        return this;
    }

    public WeaponFiles setMaximumGem(int maximumGem) {
        this.getWeaponConfiguration().set("item_maximum_gem", maximumGem);
        return this;
    }

    public WeaponFiles setMinimumScroll(int minimumScroll) {
        this.getWeaponConfiguration().set("item_minimum_dcroll", minimumScroll);
        return this;
    }

    public WeaponFiles setMaximumScroll(int maximumScroll) {
        this.getWeaponConfiguration().set("item_maximum_scroll", maximumScroll);
        return this;
    }

    public void setWeaponFile(File weaponFile) {
        this.weaponFile = weaponFile;
    }

    public void setWeaponConfiguration(YamlConfiguration weaponConfiguration) {
        this.weaponConfiguration = weaponConfiguration;
    }

    public String getName() {
        return this.name;
    }

    public String getRarity() {
        return this.rarity != null ? this.rarity : "Uncommon";
    }

    public String getActualMaterial() {
        return this.getWeaponConfiguration().getString("item_actual_material", "WOODEN_SWORD");
    }

    public String getCosmeticMaterial() {
        return this.getWeaponConfiguration().getString("item_cosmetic_material", "WOODEN");
    }

    public List<String> getDescription() {
        List<String> description = this.getWeaponConfiguration().getStringList("item_description");
        if (description.isEmpty()) return Arrays.asList("This is an example item", "a few lines of description", "not so much but enough.");
        return description;
    }

    public int getMinimumLevel() {
        return this.getWeaponConfiguration().getInt("item_minimum_level", 1);
    }

    public int getMaximumLevel() {
        return this.getWeaponConfiguration().getInt("item_maximum_level", 1);
    }

    public int getRequiredStrength() {
        return this.getWeaponConfiguration().getInt("item_required_strength", 0);
    }

    public int getRequiredIntelligence() {
        return this.getWeaponConfiguration().getInt("item_required_intelligence", 0);
    }

    public int getRequiredConstitution() {
        return this.getWeaponConfiguration().getInt("item_required_constitution", 0);
    }

    public int getRequiredDexterity() {
        return this.getWeaponConfiguration().getInt("item_required_dexterity", 0);
    }

    public int getRequiredCharisma() {
        return this.getWeaponConfiguration().getInt("item_required_charisma", 0);
    }

    public int getRequiredWisdom() {
        return this.getWeaponConfiguration().getInt("item_required_wisdom", 0);
    }

    public int getRequiredLuck() {
        return this.getWeaponConfiguration().getInt("item_required_luck", 0);
    }

    public double getMeleeMinimumDamage() {
        return this.getWeaponConfiguration().getDouble("item_melee_minimum_damage", 0);
    }

    public double getMeleeMaximumDamage() {
        return this.getWeaponConfiguration().getDouble("item_melee_maximum_damage", 1);
    }

    public double getRangedMinimumDamage() {
        return this.getWeaponConfiguration().getDouble("item_ranged_minimum_damage", 0);
    }

    public double getRangedMaximumDamage() {
        return this.getWeaponConfiguration().getDouble("item_ranged_maximum_damage", 1);
    }

    public double getAttackCooldown() {
        return this.getWeaponConfiguration().getDouble("item_attack_cooldown", 1);
    }

    public int getStrength() {
        return this.getWeaponConfiguration().getInt("item_strength", 1);
    }

    public int getIntelligence() {
        return this.getWeaponConfiguration().getInt("item_intelligence", 1);
    }

    public int getConstitution() {
        return this.getWeaponConfiguration().getInt("item_constitution", 1);
    }

    public int getDexterity() {
        return this.getWeaponConfiguration().getInt("item_dexterity", 1);
    }

    public int getCharisma() {
        return this.getWeaponConfiguration().getInt("item_charisma", 1);
    }

    public int getWisdom() {
        return this.getWeaponConfiguration().getInt("item_wisdom", 1);
    }

    public int getLuck() {
        return this.getWeaponConfiguration().getInt("item_luck", 1);
    }

    public int getMinimumGem() {
        return this.getWeaponConfiguration().getInt("item_minimum_gem", 0);
    }

    public int getMaximumGem() {
        return this.getWeaponConfiguration().getInt("item_maximum_gem", 1);
    }

    public int getMinimumScroll() {
        return this.getWeaponConfiguration().getInt("item_minimum_scroll", 0);
    }

    public int getMaximumScroll() {
        return this.getWeaponConfiguration().getInt("item_maximum_scroll", 1);
    }

    public List<File> getRarityFolders() {
        return this.rarityFolders;
    }

    public int getRarityFoldersAmount(){
        return this.rarityFolders.size();
    }

    public File getWeaponFile() {
        return this.weaponFile;
    }

    public int getWeaponFilesAmount(){
        return Objects.requireNonNull(this.weaponFile.list()).length;
    }

    private YamlConfiguration getWeaponConfiguration() {
        return weaponConfiguration;
    }

    public void save(){
        if (this.name != null) {
            try {
                getWeaponConfiguration().save(this.weaponFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getExample() {
        setActualMaterial("BOW");
        setCosmeticMaterial("Example");
        setDescription(Arrays.asList("This is an example item", "forged from the depths of", "the plugin...."));
        setMinimumLevel(1);
        setMaximumLevel(100);
        setMeleeMinimumDamage(0.5);
        setMeleeMaximumDamage(1.25);
        setRangedMinimumDamage(0.5);
        setRangedMaximumDamage(1.25);
        setAttackCooldown(1.5);
        setMinimumGem(1);
        setMaximumGem(2);
        setMinimumScroll(1);
        setMaximumScroll(2);
        save();
    }

    public boolean exist(){
        return getWeaponFile().exists();
    }

}
