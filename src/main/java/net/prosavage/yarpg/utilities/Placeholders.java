package net.prosavage.yarpg.utilities;

import net.prosavage.yarpg.api.entities.YPlayer;
import org.apache.commons.lang.text.StrSubstitutor;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Placeholders {

    private DecimalFormat doubleFormat = new NumberFormat().getDoubleFormat();
    Color color = new Color();

    Player player;
    Mob entity;
    String variablePrefix;
    String messageReplaced;
    StrSubstitutor strSubstitutor;

    public Placeholders(Player player, String variablePrefix, String messageReplaced){
        this.player = player;
        this.variablePrefix = variablePrefix != null ? variablePrefix : "PLAYER";
        this.messageReplaced = messageReplaced;

        Map<String, String> values = new HashMap<>();

        YPlayer yPlayer = new YPlayer(player);
        int level = yPlayer.getLevel();
        double exp = yPlayer.getExperience();
        double maximumExp = yPlayer.getMaximumExperience();
        String health = doubleFormat.format(yPlayer.getHealth());
        String maximumHealth = doubleFormat.format(yPlayer.getMaximumHealth());
        String regeneration = doubleFormat.format(yPlayer.getRegeneration());
        String protection = doubleFormat.format(yPlayer.getProtection());
        String attribute = String.valueOf(yPlayer.getAttributePoints());
        String strength = String.valueOf(yPlayer.getStrength());
        String intelligence = String.valueOf(yPlayer.getIntelligence());
        String constitution = String.valueOf(yPlayer.getConstitution());
        String dexterity = String.valueOf(yPlayer.getDexterity());
        String charisma = String.valueOf(yPlayer.getCharisma());
        String wisdom = String.valueOf(yPlayer.getWisdom());
        String luck = String.valueOf(yPlayer.getLuck());

        values.put(variablePrefix + "_level", String.valueOf(level));
        values.put(variablePrefix + "_experience", String.valueOf(exp));
        values.put(variablePrefix + "_maximum_experience", String.valueOf(maximumExp));
        values.put(variablePrefix + "_health", health);
        values.put(variablePrefix + "_maximum_health", maximumHealth);
        values.put(variablePrefix + "_regeneration", regeneration);
        values.put(variablePrefix + "_protection", protection);
        values.put(variablePrefix + "_name", player.getName());
        values.put(variablePrefix + "_attribute_points", attribute);
        values.put(variablePrefix + "_strength_points", strength);
        values.put(variablePrefix + "_intelligence_points", intelligence);
        values.put(variablePrefix + "_constitution_points", constitution);
        values.put(variablePrefix + "_dexterity_points", dexterity);
        values.put(variablePrefix + "_charisma_points", charisma);
        values.put(variablePrefix + "_wisdom_points", wisdom);
        values.put(variablePrefix + "_luck_points", luck);
        values.put(variablePrefix + "_str", strength);
        values.put(variablePrefix + "_int", intelligence);
        values.put(variablePrefix + "_con", constitution);
        values.put(variablePrefix + "_dex", dexterity);
        values.put(variablePrefix + "_cha", charisma);
        values.put(variablePrefix + "_wis", wisdom);
        values.put(variablePrefix + "_luk", luck);

        this.strSubstitutor = new StrSubstitutor(values);
        this.strSubstitutor.setVariablePrefix("{");
        this.strSubstitutor.setVariableSuffix("}");
    }

    public String parse(){
        this.messageReplaced = this.strSubstitutor.replace(this.messageReplaced);
        return color.ify(this.messageReplaced);
    }

}
