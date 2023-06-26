package net.prosavage.yarpg.listeners;

import net.prosavage.yarpg.api.entities.YPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class PlayerRegenEventListener implements Listener {

    @EventHandler
    public void playerRegenEvent(EntityRegainHealthEvent event) {
        Entity entity = event.getEntity();
        double amount = event.getAmount();

        if (entity instanceof Player player) {
            YPlayer yPlayer = new YPlayer(player);
            yPlayer.heal(amount);
        }

    }

}
