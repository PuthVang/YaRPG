package net.prosavage.yarpg.utilities;

import org.apache.commons.lang.WordUtils;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class DefaultUtilities {

    public DefaultUtilities(){}

    public static String getDefaultMaterial(ItemStack itemStack){
        String key = String.valueOf(itemStack.getType().getKey()).replace("minecraft:", "");
        String[] split = key.split("_");
        List<String> words = new ArrayList<>();
        for (String s : split){
            s = WordUtils.capitalize(s);
            words.add(s);
        }
        return words.get(0);
    }

    public static String getDefaultName(ItemStack itemStack){
        String key = String.valueOf(itemStack.getType().getKey()).replace("minecraft:", "");
        String[] split = key.split("_");
        List<String> words = new ArrayList<>();
        for (String s : split){
            s = WordUtils.capitalize(s);
            words.add(s);
        }
        return String.join(" ", words);
    }

    public static String getDefaultEntityName(Entity entity){
        String[] key = String.valueOf(entity.getType().getKey()).split("_");
        List<String> words = new ArrayList<>();
        for (String s : key){
            s = WordUtils.capitalize(s);
            words.add(s);
        }
        return String.join(" ", words);
    }

}
