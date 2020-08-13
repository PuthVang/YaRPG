package net.prosavage.yarpg.api.entities;

import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.api.entities.utilities.AbstractEntity;
import net.prosavage.yarpg.utilities.Equation;
import net.prosavage.yarpg.utilities.keys.YNamespacedKeys;
import net.prosavage.yarpg.utilities.tagtypes.StringArrayTagType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YEntity extends AbstractEntity {

    public YEntity(){}

    public YEntity(LivingEntity entity) {
        super(entity);
    }

    public double getBaseHealth(){
        return new Equation(YaRPG.getInstance().getConfig().getString("formulas.entity.base_health")).getDouble();
    }

    public ItemStack getHeldItem() {
        return entityEquipment.getItemInMainHand();
    }

    public ItemStack getHelmet() {
        return entityEquipment.getHelmet();
    }

    public ItemStack getChestplate() {
        return entityEquipment.getChestplate();
    }

    public ItemStack getLeggings() {
        return entityEquipment.getLeggings();
    }

    public ItemStack getBoots() {
        return entityEquipment.getBoots();
    }

    public String[] getPluginDrops(){
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_YARPG_DROPS, new StringArrayTagType(), new String[]{});
    }

    public String[] getPluginDropChance() {
        return persistentDataContainer.getOrDefault(YNamespacedKeys.ENTITY_YARPG_DROPS_CHANCES, new StringArrayTagType(), new String[]{});
    }

    public YEntity setHeldItem(ItemStack heldItem) {
        entityEquipment.setItemInMainHand(heldItem);
        return this;
    }

    public YEntity setHelmet(ItemStack helmet) {
        entityEquipment.setHelmet(helmet);
        return this;
    }

    public YEntity setChestplate(ItemStack chestplate) {
        entityEquipment.setChestplate(chestplate);
        return this;
    }

    public YEntity setLeggings(ItemStack leggings) {
        entityEquipment.setLeggings(leggings);
        return this;
    }

    public YEntity setBoots(ItemStack boots) {
        entityEquipment.setBoots(boots);
        return this;
    }

    public YEntity addPluginDrops(String rarity, String fileName, double dropChance){
        List<String> dropList = new ArrayList<>(Arrays.asList(getPluginDrops()));
        dropList.add(rarity + ";" + fileName);
        List<String> chanceList = new ArrayList<>(Arrays.asList(getPluginDropChance()));
        chanceList.add(String.valueOf(dropChance));
        persistentDataContainer.set(YNamespacedKeys.ENTITY_YARPG_DROPS, new StringArrayTagType(), dropList.toArray(new String[0]));
        persistentDataContainer.set(YNamespacedKeys.ENTITY_YARPG_DROPS_CHANCES, new StringArrayTagType(), chanceList.toArray(new String[0]));
        return this;
    }

}
