package me.anemys.test.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.title.Title;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.time.Duration;

@SuppressWarnings("unused")
public class Sender {

    private static final LegacyComponentSerializer LEGACY_SECTION = LegacyComponentSerializer.legacySection();

    private static Component processToComponent(String msg) {
        return LEGACY_SECTION.deserialize(msg);
    }

    public static <T extends Player> void send(T p, String msg) {
        Component component = processToComponent(msg);
        p.sendMessage(component);
    }

    public static <T extends CommandSender> void send(T sender, String msg) {
        Component component = processToComponent(msg);
        sender.sendMessage(component);
    }

    public static void send(String msg) {
        Component component = processToComponent(msg);
        Bukkit.getConsoleSender().sendMessage(component);
    }

    public static <T extends Player> void sendTitle(T p, String titleText, String subtitleText, long fadeIn, long stay, long fadeOut) throws IllegalArgumentException {
        try {
            Component title = processToComponent(titleText);
            Component subtitle = processToComponent(subtitleText);

            Duration fadeInDuration = Duration.ofMillis(fadeIn * 50);
            Duration stayDuration = Duration.ofMillis(stay * 50);
            Duration fadeOutDuration = Duration.ofMillis(fadeOut * 50);

            Title.Times times = Title.Times.times(fadeInDuration, stayDuration, fadeOutDuration);
            Title titleObj = Title.title(title, subtitle, times);

            p.showTitle(titleObj);

        } catch (Exception e) {
            e.printStackTrace();

            try {
                Component simpleTitle = processToComponent(titleText);
                p.showTitle(Title.title(simpleTitle, Component.empty()));
            } catch (Exception fallbackError) {
                fallbackError.printStackTrace();
            }
        }
    }

    public static <T extends Player> void sendTitleSeconds(T p, String titleText, String subtitleText, double fadeInSec, double staySec, double fadeOutSec) {
        long fadeInTicks = Math.round(fadeInSec);
        long stayTicks = Math.round(staySec);
        long fadeOutTicks = Math.round(fadeOutSec);

        sendTitle(p, titleText, subtitleText, fadeInTicks, stayTicks, fadeOutTicks);
    }

    public static <T extends Player> void sendActionBar(T p, String msg) {
        try {
            Component component = processToComponent(msg);
            p.sendActionBar(component);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}