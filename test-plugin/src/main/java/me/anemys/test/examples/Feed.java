package me.anemys.test.examples;

import me.anemys.test.utils.Sender;
import me.anemys.test.IServerSystem;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public class Feed implements IServerSystem {

    @Override
    public <S extends CommandSender> void getCommand(S sender, String[] args) {

        if (args == null || args.length == 0) {

            if (senderIsPlayer(sender)) {
                feed((Player) sender);
                Sender.send(sender, "U're not hungry anymore!!!!");

            } else {
                Sender.send(sender, "Please enter a player name!");
            }

        } else {
            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                Sender.send(sender, "No found the player found!");

            } else {
                feed(target);
                Sender.send(sender, "You filled player "+ target.getName() +" 's hunger bar!");
                Sender.send(target, "Your hunger bar is full!");
            }

        }
    }

    @Override
    public String commandName() {
        return "feed";
    }

    @Override
    public String permission() {
        return "test.feed";
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }

    @Override
    public String description() {
        return "Feed Command";
    }

    @Override
    public List<String> getErrorMessageArgs() {
        return new ArrayList<>();
    }

    @Override
    public String getErrorMessageArg() {
        return "/feed (player)";
    }

    @Override
    public String noPermission() {
        return "You doesn't have permission for this command!";
    }

    @Override
    public int getMinArgs() {
        return 0;
    }

    @Override
    public int getMaxArgs() {
        return 1;
    }

    @Override
    public <S extends CommandSender> List<String> getCompleter(S sender, String[] args) {
        List<String> list = new ArrayList<>();

        if (args.length == 1) {

            for (Player p : Bukkit.getOnlinePlayers()) {
                list.add(p.getName());
            }

        }

        return list;

    }

    private void feed(Player p) {

        p.setFoodLevel(20);
        p.setExhaustion(0.0f);

    }

}
