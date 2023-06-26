package net.prosavage.yarpg.listeners;

import net.prosavage.yarpg.api.entities.YPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamageEventListener implements Listener {

    @EventHandler
    public void playerDamageEventListener(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        Entity damager = event.getDamager();

        if (entity instanceof Player player) {
            YPlayer yPlayer = new YPlayer(player);
            yPlayer.setCombatTagged(true);
        } else if (damager instanceof Player player) {
            YPlayer yPlayer = new YPlayer(player);
            yPlayer.setCombatTagged(true);
        }
    }

    @EventHandler
    public void playerTakesDamageEventListener(EntityDamageEvent event) {
        Entity entity = event.getEntity();

        if (entity instanceof Player player) {
            YPlayer yPlayer = new YPlayer(player);
            yPlayer.setCombatTagged(true);
        }
    }

}
