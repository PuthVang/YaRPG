package net.prosavage.yarpg.utilities;

import net.prosavage.yarpg.api.entities.YEntity;
import net.prosavage.yarpg.api.entities.YPlayer;
import org.apache.commons.lang.text.StrSubstitutor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Placeholders {

    private final DecimalFormat doubleFormat = NumberFormat.getDoubleFormat();

    Player player;
    LivingEntity entity;
    String variablePrefix;
    String messageReplaced;
    StrSubstitutor strSubstitutor;

    public Placeholders(Player player, String variablePrefix, String messageReplaced){
        this.player = player;
        this.variablePrefix = variablePrefix != null ? variablePrefix : "player";
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

    public Placeholders(Mob entity, String variablePrefix, String messageReplaced){
        this.entity = entity;
        this.variablePrefix = variablePrefix != null ? variablePrefix : "ENTITY";
        this.messageReplaced = messageReplaced;

        Map<String, String> values = new HashMap<>();

        YEntity yEntity = new YEntity(entity);
        String level = String.valueOf(yEntity.getLevel());
        String name = yEntity.getName();
        String health = doubleFormat.format(yEntity.getHealth());
        String minimumHealth = doubleFormat.format(yEntity.getMinimumHealth());
        String maximumHealth = doubleFormat.format(yEntity.getMaximumHealth());
        String experience = doubleFormat.format(yEntity.getExperience());
        String minimumExperience = doubleFormat.format(yEntity.getMinimumExperience());
        String maximumExperience = doubleFormat.format(yEntity.getMaximumExperience());
        String protection = doubleFormat.format(yEntity.getProtection());
        String minimumProtection = doubleFormat.format(yEntity.getMinimumProtection());
        String maximumProtection = doubleFormat.format(yEntity.getMaximumProtection());
        String damage = doubleFormat.format(yEntity.getDamage());
        String minimumDamage = doubleFormat.format(yEntity.getMinimumDamage());
        String maximumDamage = doubleFormat.format(yEntity.getMaximumDamage());
        String heldItem = yEntity.getHeldItem().toString();
        String helmet = yEntity.getHelmet().toString();
        String chestplate = yEntity.getChestplate().toString();
        String leggings = yEntity.getLeggings().toString();
        String boots = yEntity.getBoots().toString();
        values.put(variablePrefix + "_name", name);
        values.put(variablePrefix + "_level", level);
        values.put(variablePrefix + "_health", health);
        values.put(variablePrefix + "_minimum_health", minimumHealth);
        values.put(variablePrefix + "_maximum_health", maximumHealth);
        values.put(variablePrefix + "_experience", experience);
        values.put(variablePrefix + "_minimum_experience", minimumExperience);
        values.put(variablePrefix + "_maximum_experience", maximumExperience);
        values.put(variablePrefix + "_protection", protection);
        values.put(variablePrefix + "_minimum_protection", minimumProtection);
        values.put(variablePrefix + "_maximum_protection", maximumProtection);
        values.put(variablePrefix + "_damage", damage);
        values.put(variablePrefix + "_minimum_damage", minimumDamage);
        values.put(variablePrefix + "_maximum_damage", maximumDamage);
        values.put(variablePrefix + "_held_item", heldItem);
        values.put(variablePrefix + "_helmet", helmet);
        values.put(variablePrefix + "_chestplate", chestplate);
        values.put(variablePrefix + "_leggings", leggings);
        values.put(variablePrefix + "_boots", boots);

        this.strSubstitutor = new StrSubstitutor(values);
    }

    public String parse(){
        this.messageReplaced = this.strSubstitutor.replace(this.messageReplaced);
        return this.messageReplaced;
    }

}
