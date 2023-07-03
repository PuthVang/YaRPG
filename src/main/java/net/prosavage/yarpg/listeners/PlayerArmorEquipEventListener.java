package net.prosavage.yarpg.listeners;

import com.jeff_media.armorequipevent.ArmorEquipEvent;
import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.api.entities.YPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerArmorEquipEventListener implements Listener {

    @EventHandler
    public void armorEquipEventListener(ArmorEquipEvent event) {

        new BukkitRunnable() {

            @Override
            public void run() {

                Player player = event.getPlayer();
                YPlayer yPlayer = new YPlayer(player);
                yPlayer.calculateArmorAttributesAndApply();

            }
        }.runTaskLater(YaRPG.getInstance(), 1L);
    }

}
