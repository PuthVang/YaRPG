package net.prosavage.yarpg.utilities;

import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.prosavage.yarpg.YaRPG;
import org.bukkit.entity.Player;

import java.util.List;

public class MessageUtilities {

    private final MiniMessage miniMessage = MiniMessage.miniMessage();

    Player player;
    String yamlNode;

    public MessageUtilities(Player player, String yamlNode){
        this.player = player;
        this.yamlNode = yamlNode;
    }

    public void send(){
        BukkitAudiences result = YaRPG.getInstance().getResult();
        List<String> messages = YaRPG.getInstance().getFileManager().getMessageConfiguration().getStringList(yamlNode);
        for (String s : messages) {
            result.player(player).sendMessage(miniMessage.deserialize(s));
        }
    }
}
