package net.prosavage.yarpg.listeners;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.api.entities.YPlayer;
import net.prosavage.yarpg.utilities.Color;
import net.prosavage.yarpg.utilities.Placeholders;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinEventListener implements Listener {

    @EventHandler
    public void onPlayerJoinListener(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.setHealthScale(20);
        player.setHealthScaled(true);

        YPlayer yPlayer = new YPlayer(player);
        yPlayer.setDefaultData();

        if (yPlayer.hasCombatLogged()) {
            String combatLoggedMessage = Color.ify(YaRPG.getInstance().getConfig().getString("combat_tag.logged.message"));
            player.sendMessage(combatLoggedMessage);
            yPlayer.setCombatLogged(false);
        }

        int actionBarDuration = YaRPG.getInstance().getConfig().getInt("actionbar.duration");
        int regenerationDuration = YaRPG.getInstance().getConfig().getInt("regeneration.duration");

        new BukkitRunnable() {
            @Override
            public void run() {
                String string = YaRPG.getInstance().getConfig().getString("actionbar.message");
                String actionBar = Color.ify(new Placeholders(player, "player", string).parse());

                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(actionBar));
            }

        }.runTaskTimer(YaRPG.getInstance(), 1L, actionBarDuration);

        new BukkitRunnable() {
            @Override
            public void run() {
                double regeneration = yPlayer.getRegeneration();
                double health = yPlayer.getHealth();
                double maximumHealth = yPlayer.getMaximumHealth();

                if (!yPlayer.isCombatTagged()) {
                    if (health + regeneration < maximumHealth) yPlayer.setHealth(yPlayer.getHealth() + yPlayer.getRegeneration());
                    else yPlayer.setHealth(yPlayer.getMaximumHealth());
                }
            }

        }.runTaskTimer(YaRPG.getInstance(), 1L, regenerationDuration);

    }

}
