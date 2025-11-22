package me.anemys.test;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public interface IServerSystem {

    <S extends CommandSender> void getCommand(S sender, String[] args);

    <S extends CommandSender> List<String> getCompleter(S sender, String[] args);

    default <S extends CommandSender> boolean senderIsPlayer(S sender) {
        return sender instanceof Player;
    }

    default <S extends CommandSender> Player getPlayer(S sender) {
        return (Player) sender;
    }

    String commandName();

    String permission();

    String[] aliases();

    String description();

    String getErrorMessageArg();

    List<String> getErrorMessageArgs();

    String noPermission();

    int getMinArgs();

    int getMaxArgs();

}
