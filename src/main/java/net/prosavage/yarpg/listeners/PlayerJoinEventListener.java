package net.prosavage.yarpg.listeners;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.utilities.Color;
import net.prosavage.yarpg.utilities.Placeholders;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinEventListener implements Listener {

    @EventHandler
    public void PlayerJoinListener(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        new BukkitRunnable() {
            @Override
            public void run() {
                String string = YaRPG.getInstance().getConfig().getString("messages.actionbar");
                String actionBar = Color.ify(new Placeholders(player, "player", string).parse());

                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionBar));
            }

        }.runTaskTimer(YaRPG.getInstance(), 1L, 5L);

    }

}
