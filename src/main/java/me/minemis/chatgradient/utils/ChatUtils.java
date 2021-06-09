package me.minemis.chatgradient.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;

import java.awt.*;
import java.util.ArrayList;

public class ChatUtils {

    public static String gradient(String s, Color... colors){

        char[] chars = s.toCharArray();

        ArrayList<String> strings = new ArrayList<>();

        int divisions = colors.length - 1;

        for (int index = 0; index < colors.length; index++){
            for (char c : chars) {

            }
        }
    }

    private static String gradientTwoColors(String s, Color color, Color color2) {

        char[] chars = s.toCharArray();
        int length = s.length();

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

        StringBuilder result = new StringBuilder();

        int index = 0;

        for (Character c : chars) {
            result.append(ChatColor.of(new Color(
                    r - index * redDivider,
                    g - index * greenDivider,
                    b - index * blueDivider
            ))).append(c.toString());

            index ++;
        }

        Bukkit.getLogger().info("");
        return result.toString();
    }

    private static int getDivider(int color1Strength, int color2Strength, int length) {
        return (color1Strength - color2Strength) / (length - 1);
    }

}
