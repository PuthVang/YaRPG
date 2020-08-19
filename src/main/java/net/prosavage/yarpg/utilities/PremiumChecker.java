package net.prosavage.yarpg.utilities;

import com.google.common.base.Charsets;
import net.prosavage.yarpg.YaRPG;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class PremiumChecker {

    // This may or may not work, has only been tested with 250 offline player data.

    PremiumChecker(){}

    private static boolean isPremium(){
        List<OfflinePlayer> offlinePlayerList = Arrays.asList(Bukkit.getOfflinePlayers());
        int offlineSize = offlinePlayerList.size();
        if (offlineSize == 0) return true;

        Collections.shuffle(offlinePlayerList);

        // 2400 or more offline player data file will reach 25 (max) here cause of Math.ceil().
        int trueAmount = (int) Math.ceil(((double) offlineSize / (offlineSize + 100)) * 25);

        // 10000 or more offline player data file will reach 100 (max) here cause of Math.ceil().
        offlinePlayerList = offlinePlayerList.subList(0, (int) Math.ceil(((double) offlineSize / (offlineSize + 100)) * 100));
        int amount = 0;

        for (OfflinePlayer offlinePlayer : offlinePlayerList){
            String name = offlinePlayer.getName();
            UUID offlineUUUID = UUID.nameUUIDFromBytes(("OfflinePlayer:"+name).getBytes(Charsets.UTF_8));
            if (offlinePlayer.getUniqueId().equals(offlineUUUID)){
                amount++;
                if (amount >= trueAmount) return false;
            }
        }
        return true;
    }

    public static void announceIfFalse(){
        if (!isPremium()){
            YaRPG.getInstance().log("");
            YaRPG.getInstance().log("&cLooks like you are in offline mode.");
            YaRPG.getInstance().log("&cThe author won't support you.");
        }
    }

}
