package net.prosavage.yarpg.api.files;

import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.utilities.YFileUtil;
import net.prosavage.yarpg.utilities.managers.FileManager;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ArmorFiles {

    FileManager fileManager = YaRPG.getInstance().getFileManager();
    YFileUtil yFileUtil = new YFileUtil();

    private String name;
    private String extension = "";
    private String rarity;
    private final List<File> rarityFolders;
    private File armorFile;
    private YamlConfiguration armorConfiguration;

    public ArmorFiles(String rarity, String name){
        this.rarity = rarity;
        this.name = name.replaceAll("_", " ");
        this.rarityFolders = yFileUtil.getFolders(fileManager.getArmorFolder());
        if (!name.endsWith(".yml")) extension = ".yml";
        this.armorFile = new File(fileManager.getArmorFolder() + File.separator + this.rarity + File.separator + this.name + this.extension);
        this.armorConfiguration = YamlConfiguration.loadConfiguration(this.armorFile);
    }

    public ArmorFiles(String rarity){
        this.rarity = rarity;
        this.rarityFolders = yFileUtil.getFolders(fileManager.getArmorFolder());
    }

    public ArmorFiles setName(String name) {
        if (!name.endsWith(".yml")) extension = ".yml";
        String path = fileManager.getArmorFolder() + File.separator + this.rarity + File.separator + name + extension;
        boolean rename = getArmorFile().renameTo(new File(path));
        if (rename){
            this.name = name.replaceAll("_", " ");
            this.armorFile = new File(path);
            this.armorConfiguration = YamlConfiguration.loadConfiguration(this.armorFile);
            try {
                armorConfiguration.save(this.armorFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public ArmorFiles setRarity(String rarity) {
        String path = fileManager.getArmorFolder() + File.separator + rarity + File.separator + this.name + extension;
        File oldFolderFile = new File(fileManager.getArmorFolder() + File.separator + this.rarity);
        File newFolderFile = new File(fileManager.getArmorFolder() + File.separator + rarity);
        boolean oldFolder = newFolderFile.mkdirs();
        boolean rename = getArmorFile().renameTo(new File(path));
        if (oldFolderFile.listFiles().length == 0){
            boolean deletedFile = oldFolderFile.delete();
        }
        if (rename) {
            this.rarity = rarity;
            this.armorFile = new File(path);
            this.armorConfiguration = YamlConfiguration.loadConfiguration(this.armorFile);
            try {
                armorConfiguration.save(this.armorFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public ArmorFiles setActualMaterial(String actualMaterial) {
        this.getArmorConfiguration().set("item_actual_material", actualMaterial);
        return this;
    }

    public ArmorFiles setCosmeticMaterial(String cosmeticMaterial) {
        this.getArmorConfiguration().set("item_cosmetic_material", cosmeticMaterial);
        return this;
    }

    public ArmorFiles setDescription(List<String> description) {
        this.getArmorConfiguration().set("item_description", description);
        return this;
    }

    public ArmorFiles setMinimumLevel(int minimumLevel) {
        this.getArmorConfiguration().set("item_minimum_level", minimumLevel);
        return this;
    }

    public ArmorFiles setMaximumLevel(int maximumLevel) {
        this.getArmorConfiguration().set("item_maximum_level", maximumLevel);
        return this;
    }

    public ArmorFiles setRequiredStrength(int strength) {
        this.getArmorConfiguration().set("item_required_strength", strength);
        return this;
    }

    public ArmorFiles setRequiredIntelligence(int intelligence) {
        this.getArmorConfiguration().set("item_required_intelligence", intelligence);
        return this;
    }

    public ArmorFiles setRequiredConsitution(int consitution) {
        this.getArmorConfiguration().set("item_required_constitution", consitution);
        return this;
    }

    public ArmorFiles setRequiredDexterity(int dexterity) {
        this.getArmorConfiguration().set("item_required_dexterity", dexterity);
        return this;
    }

    public ArmorFiles setRequiredCharisma(int charisma) {
        this.getArmorConfiguration().set("item_required_charisma", charisma);
        return this;
    }

    public ArmorFiles setRequiredWisdom(int wisdom) {
        this.getArmorConfiguration().set("item_required_wisdom", wisdom);
        return this;
    }

    public ArmorFiles setRequiredLuck(int luck) {
        this.getArmorConfiguration().set("item_required_luck", luck);
        return this;
    }

    public ArmorFiles setMinimumHealth(double minimumHealth) {
        this.getArmorConfiguration().set("item_minimum_health", minimumHealth);
        return this;
    }

    public ArmorFiles setMaximumHealth(double maximumHealth) {
        this.getArmorConfiguration().set("item_maximum_health", maximumHealth);
        return this;
    }

    public ArmorFiles setMinimumRegeneration(double minimumRegeneration) {
        this.getArmorConfiguration().set("item_minimum_regeneration", minimumRegeneration);
        return this;
    }

    public ArmorFiles setMaximumRegeneration(double maximumRegeneration) {
        this.getArmorConfiguration().set("item_maximum_regeneration", maximumRegeneration);
        return this;
    }

    public ArmorFiles setMinimumProtection(double minimumProtection) {
        this.getArmorConfiguration().set("item_minimum_protection", minimumProtection);
        return this;
    }

    public ArmorFiles setMaximumProtection(double maximumProtection) {
        this.getArmorConfiguration().set("item_maximum_protection", maximumProtection);
        return this;
    }

    public ArmorFiles setStrength(int strength) {
        this.getArmorConfiguration().set("item_strength", strength);
        return this;
    }

    public ArmorFiles setIntelligence(int intelligence) {
        this.getArmorConfiguration().set("item_intelligence", intelligence);
        return this;
    }

    public ArmorFiles setConstitution(int constitution) {
        this.getArmorConfiguration().set("item_constitution", constitution);
        return this;
    }

    public ArmorFiles setDexterity(int dexterity) {
        this.getArmorConfiguration().set("item_dexterity", dexterity);
        return this;
    }

    public ArmorFiles setCharisma(int charisma) {
        this.getArmorConfiguration().set("item_charisma", charisma);
        return this;
    }

    public ArmorFiles setWisdom(int wisdom) {
        this.getArmorConfiguration().set("item_wisdom", wisdom);
        return this;
    }

    public ArmorFiles setLuck(int luck) {
        this.getArmorConfiguration().set("item_luck", luck);
        return this;
    }

    public ArmorFiles setMinimumGem(int minimumGem) {
        this.getArmorConfiguration().set("item_minimum_gem", minimumGem);
        return this;
    }

    public ArmorFiles setMaximumGem(int maximumGem) {
        this.getArmorConfiguration().set("item_maximum_gem", maximumGem);
        return this;
    }

    public ArmorFiles setMinimumScroll(int minimumScroll) {
        this.getArmorConfiguration().set("item_minimum_scroll", minimumScroll);
        return this;
    }

    public ArmorFiles setMaximumScroll(int maximumScroll) {
        this.getArmorConfiguration().set("item_maximum_scroll", maximumScroll);
        return this;
    }

    public void setArmorFile(File armorFile) {
        this.armorFile = armorFile;
    }

    public void setArmorConfiguration(YamlConfiguration armorConfiguration) {
        this.armorConfiguration = armorConfiguration;
    }

    public String getName() {
        return this.name;
    }

    public String getRarity() {
        return this.rarity;
    }

    public String getActualMaterial() {
        return this.getArmorConfiguration().getString("item_actual_material");
    }

    public String getCosmeticMaterial() {
        return this.getArmorConfiguration().getString("item_cosmetic_material");
    }

    public List<String> getDescription() {
        return this.getArmorConfiguration().getStringList("item_description");
    }

    public int getMinimumLevel() {
        return this.getArmorConfiguration().getInt("item_minimum_level");
    }

    public int getMaximumLevel() {
        return this.getArmorConfiguration().getInt("item_maximum_level");
    }

    public int getRequiredStrength() {
        return this.getArmorConfiguration().getInt("item_required_strength");
    }

    public int getRequiredIntelligence() {
        return this.getArmorConfiguration().getInt("item_required_intelligence");
    }

    public int getRequiredConsitution() {
        return this.getArmorConfiguration().getInt("item_required_constitution");
    }

    public int getRequiredDexterity() {
        return this.getArmorConfiguration().getInt("item_required_dexterity");
    }

    public int getRequiredCharisma() {
        return this.getArmorConfiguration().getInt("item_required_charisma");
    }

    public int getRequiredWisdom() {
        return this.getArmorConfiguration().getInt("item_required_wisdom");
    }

    public int getRequiredLuck() {
        return this.getArmorConfiguration().getInt("item_required_luck");
    }

    public double getMinimumHealth() {
        return this.getArmorConfiguration().getDouble("item_minimum_health");
    }

    public double getMaximumHealth() {
        return this.getArmorConfiguration().getDouble("item_maximum_health");
    }

    public double getMinimumRegeneration() {
        return this.getArmorConfiguration().getDouble("item_minimum_regeneration");
    }

    public double getMaximumRegeneration() {
        return this.getArmorConfiguration().getDouble("item_maximum_regeneration");
    }

    public double getMinimumProtection() {
        return this.getArmorConfiguration().getDouble("item_minimum_protection");
    }

    public double getMaximumProtection() {
        return this.getArmorConfiguration().getDouble("item_maximum_protection");
    }

    public int getStrength() {
        return this.getArmorConfiguration().getInt("item_strength");
    }

    public int getIntelligence() {
        return this.getArmorConfiguration().getInt("item_intelligence");
    }

    public int getConstitution() {
        return this.getArmorConfiguration().getInt("item_constitution");
    }

    public int getDexterity() {
        return this.getArmorConfiguration().getInt("item_dexterity");
    }

    public int getCharisma() {
        return this.getArmorConfiguration().getInt("item_charisma");
    }

    public int getWisdom() {
        return this.getArmorConfiguration().getInt("item_wisdom");
    }

    public int getLuck() {
        return this.getArmorConfiguration().getInt("item_luck");
    }

    public int getMinimumGem() {
        return this.getArmorConfiguration().getInt("item_minimum_gem");
    }

    public int getMaximumGem() {
        return this.getArmorConfiguration().getInt("item_maximum_gem");
    }

    public int getMinimumScroll() {
        return this.getArmorConfiguration().getInt("item_minimum_scroll");
    }

    public int getMaximumScroll() {
        return this.getArmorConfiguration().getInt("item_maximum_scroll");
    }

    public List<File> getRarityFolders() {
        return this.rarityFolders;
    }

    public int getRarityFoldersAmount(){
        return this.rarityFolders.size();
    }

    public File getArmorFile() {
        return this.armorFile;
    }

    public int getArmorFilesAmount(){
        return yFileUtil.getFilesCount(this.armorFile);
    }

    private YamlConfiguration getArmorConfiguration() {
        return armorConfiguration;
    }

    public void save(){
        if (this.name != null) {
            try {
                getArmorConfiguration().save(this.armorFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void getExample(){
        setActualMaterial("LEATHER_HELMET");
        setCosmeticMaterial("Example");
        setDescription(Arrays.asList("Where's the rest of the armor set?", "They seem to be somewhere..."));
        setMinimumLevel(1);
        setMaximumLevel(100);
        setMinimumHealth(1.25829035);
        setMaximumHealth(2.6829032);
        setMinimumRegeneration(0.235890235);
        setMaximumRegeneration(2.2358902);
        setMinimumProtection(1.025671);
        setMaximumProtection(2.2325862);
        setMinimumGem(1);
        setMaximumGem(2);
        setMinimumScroll(1);
        setMaximumScroll(2);
        save();
    }

    public boolean exist(){
        return getArmorFile().exists();
    }

}
