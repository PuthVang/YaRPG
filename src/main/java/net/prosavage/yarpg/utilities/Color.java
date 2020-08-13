package net.prosavage.yarpg.utilities;

import org.bukkit.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Color {

    static Pattern hexPattern = Pattern.compile("<(#[0-9a-fA-F]{6})>");

    public Color(){}

    public static String ify(String s){
        s = convertHexString(s);
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String strip(String s){
        return ChatColor.stripColor(s);
    }

    public static String convertHexColor(String color) {
        StringBuilder sb = new StringBuilder(2 * (color.length() + 1)).append("&").append("x");
        for (char c : color.toCharArray()) {
            sb.append("&").append(c);
        }
        return sb.toString();
    }

    public static String convertHexString(String str) {
        StringBuffer sb = new StringBuffer(str.length());
        Matcher matcher = hexPattern.matcher(str);
        while (matcher.find()) {
            String hex = matcher.group();
            matcher.appendReplacement(sb, convertHexColor(hex.substring(2, hex.length() - 1)));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

}
