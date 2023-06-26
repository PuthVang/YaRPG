package net.prosavage.yarpg.listeners;

import net.prosavage.yarpg.api.entities.YPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitEventListener implements Listener {

    @EventHandler
    public void playerQuitEventListener(PlayerQuitEvent event){
        Player player = event.getPlayer();
        YPlayer yPlayer = new YPlayer(player);

        if (yPlayer.isCombatTagged()) {
            yPlayer.setCombatLogged(true);
            yPlayer.setCombatTagged(false);
        }
    }

}
