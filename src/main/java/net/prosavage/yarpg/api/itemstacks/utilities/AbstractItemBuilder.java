package net.prosavage.yarpg.api.itemstacks.utilities;

import net.prosavage.yarpg.utilities.Color;
import net.prosavage.yarpg.utilities.INumber;
import net.prosavage.yarpg.utilities.keys.YNamespacedKeys;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractItemBuilder {

    private final Color color = new Color();
    private final INumber iNumber = new INumber();

    public ItemStack itemStack;
    public ItemMeta meta;
    public PersistentDataContainer persistentDataContainer;

    public String fileRarity;
    public String fileName;

    public AbstractItemBuilder(String stringMaterial){
        Material material = Material.matchMaterial(stringMaterial);
        if (material != null) {
            this.itemStack = new ItemStack(material);
            this.meta = this.itemStack.hasItemMeta() ? this.itemStack.getItemMeta() : Bukkit.getItemFactory().getItemMeta(this.itemStack.getType());
            this.persistentDataContainer = meta.getPersistentDataContainer();
        }
    }

    public AbstractItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.meta = this.itemStack.hasItemMeta() ? this.itemStack.getItemMeta() : Bukkit.getItemFactory().getItemMeta(this.itemStack.getType());
        this.persistentDataContainer = meta.getPersistentDataContainer();
    }

    public AbstractItemBuilder(Material type) {
        this.itemStack = new ItemStack(type);
        this.meta = this.itemStack.hasItemMeta() ? this.itemStack.getItemMeta() : Bukkit.getItemFactory().getItemMeta(this.itemStack.getType());
        this.persistentDataContainer = meta.getPersistentDataContainer();
    }

    public AbstractItemBuilder(String rarity, String name){
        this.fileRarity = rarity;
        this.fileName = name;
    }

    public int getItemInventorySlot(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_INVENTORY_SLOT, PersistentDataType.INTEGER, -1);
    }

    public AbstractItemBuilder setItemInventorySlot(Integer slotNumber){
        persistentDataContainer.set(YNamespacedKeys.ITEM_INVENTORY_SLOT, PersistentDataType.INTEGER, slotNumber);
        return this;
    }

    public AbstractItemBuilder deleteItemInventorySlot(){
        persistentDataContainer.remove(YNamespacedKeys.ITEM_INVENTORY_SLOT);
        return this;
    }

    public AbstractItemBuilder setName(String name){
        this.meta.setDisplayName(name);
        return this;
    }

    public AbstractItemBuilder setLore(String lore){
        List<String> listLore = new ArrayList<>();
        Arrays.asList(lore.split("\\|\\|")).forEach(forEachLore -> listLore.add(color.ify(forEachLore)));
        this.meta.setLore(listLore);
        return this;
    }

    public AbstractItemBuilder setLore(List<String> listLore){
        this.meta.setLore(listLore);
        return this;
    }

    public AbstractItemBuilder setCustomModelData(int i){
        this.meta.setCustomModelData(i);
        return this;
    }

    public AbstractItemBuilder setUnbreakable(){
        this.meta.setUnbreakable(true);
        return this;
    }

    @NotNull
    public ItemStack build() {
        this.itemStack.setItemMeta(meta);
        return itemStack;
    }

}
