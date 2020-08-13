package net.prosavage.yarpg.api.itemstacks;

import net.prosavage.yarpg.api.itemstacks.utilities.AbstractItemBuilder;
import net.prosavage.yarpg.utilities.Color;
import net.prosavage.yarpg.utilities.keys.YNamespacedKeys;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemBuilder extends AbstractItemBuilder {

    public ItemBuilder(String stringMaterial) {
        super(stringMaterial);
    }

    public ItemBuilder(ItemStack itemStack) {
        super(itemStack);
    }

    public ItemBuilder(Material type) {
        super(type);
    }

    public int getItemInventorySlot(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ITEM_INVENTORY_SLOT, PersistentDataType.INTEGER, -1);
    }

    public AbstractItemBuilder setItemInventorySlot(Integer slotNumber){
        persistentDataContainer.set(YNamespacedKeys.ITEM_INVENTORY_SLOT, PersistentDataType.INTEGER, slotNumber);
        return this;
    }

    public AbstractItemBuilder setLore(String lore){
        List<String> listLore = new ArrayList<>();
        Arrays.asList(lore.split("\\|\\|")).forEach(forEachLore -> listLore.add(Color.ify(forEachLore)));
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
