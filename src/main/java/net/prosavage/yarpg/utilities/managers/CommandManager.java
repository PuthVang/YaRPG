package net.prosavage.yarpg.utilities.managers;

import net.prosavage.yarpg.YaRPG;
import net.prosavage.yarpg.commands.YaRPGCommand;

public class CommandManager {

    public void loadAll(){
        YaRPG.getInstance().getManager().registerCommand(new YaRPGCommand());
//        YaRPG.getInstance().getCommand("yarpg").setExecutor(new YaRPGCommand());
    }

}
