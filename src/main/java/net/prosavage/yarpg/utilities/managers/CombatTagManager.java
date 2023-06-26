package net.prosavage.yarpg.utilities.managers;

import co.aikar.commands.lib.expiringmap.ExpiringMap;
import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.utilities.Color;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class CombatTagManager {

    YaRPG plugin;
    ExpiringMap<UUID, Boolean> combatTagMap;

    public CombatTagManager(YaRPG plugin) {
        this.plugin = plugin;

        String combatUntagMessage = Color.ify(plugin.getConfig().getString("combat_tag.untagged.message"));
        int duration = plugin.getConfig().getInt("combat_tag.duration");
        System.out.println(duration);
        this.combatTagMap = ExpiringMap.builder()
                .expiration(duration, TimeUnit.SECONDS)
                .expirationListener((uuid, bool) -> {
                    Player player = Bukkit.getPlayer(UUID.fromString(uuid.toString()));
                    if (player != null) {
                        player.sendMessage(combatUntagMessage);
                    }
                })
                .build();
    }

    public boolean addPlayer(Player player) {
        if (!combatTagMap.containsKey(player.getUniqueId())) {
            String combatTagMessage = Color.ify(plugin.getConfig().getString("combat_tag.tagged.message"));
            player.sendMessage(combatTagMessage);
        }

        combatTagMap.put(player.getUniqueId(), true);
        return combatTagMap.containsKey(player.getUniqueId());
    }

    public boolean removePlayer(Player player){
        combatTagMap.remove(player.getUniqueId());
        return !combatTagMap.containsKey(player.getUniqueId());
    }

    public boolean isExpired(Player player){
        return combatTagMap.containsKey(player.getUniqueId());
    }

}
