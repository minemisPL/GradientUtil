package me.minemis.chatgradient.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;

import java.awt.*;

public class ChatUtils {

    public static String gradient(String content, Color... colors){
        StringBuilder result = new StringBuilder();

        double divisions = colors.length - 1.0D;
        double divider = content.length() / divisions;

        int first = 0;

        for (int index = 0; index < divisions; index++){
            int second = (int) (divider * (index + 1));

            String substring = content.substring(first, second);
            first = second;

            result.append(gradientTwoColors(substring, colors[index], colors[index + 1]));
        }

        return result.toString();
    }

    private static String gradientTwoColors(String content, Color color, Color color2) {

        char[] chars = content.toCharArray();
        int length = content.length();
        StringBuilder result = new StringBuilder();

        if (length == 1) {
            result.append(ChatColor.of(color)).append(content);
            return result.toString();
        }

        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        System.out.println(r + " " + g + " " + b);

        int r2 = color2.getRed();
        int g2 = color2.getGreen();
        int b2 = color2.getBlue();

        System.out.println(r2 + " " + g2 + " " + b2);

        int redDivider = getDivider(r, r2, length);
        int greenDivider = getDivider(g, g2, length);
        int blueDivider = getDivider(b, b2, length);

        System.out.println(redDivider + " " + greenDivider + " " + blueDivider);

        int index = 0;

        for (char c : chars) {
            result.append(ChatColor.of(new Color(
                    r - index * redDivider,
                    g - index * greenDivider,
                    b - index * blueDivider
            ))).append(c);

            index ++;
        }

        Bukkit.getLogger().info("");
        return result.toString();
    }

    private static int getDivider(int color1Strength, int color2Strength, int length) {
        return (color1Strength - color2Strength) / (length - 1);
    }

}
