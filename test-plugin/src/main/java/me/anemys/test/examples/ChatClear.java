package me.anemys.test.examples;

import me.anemys.test.utils.Sender;
import me.anemys.test.IServerSystem;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public class ChatClear implements IServerSystem {

    private static final StringBuilder sb = new StringBuilder();

    static {

        sb.append("\n".repeat(32));
        sb.append("chat cleared!");

    }

    @Override
    public <S extends CommandSender> void getCommand(S sender, String[] args) {
        if (senderIsPlayer(sender)) {

            for (Player players : Bukkit.getOnlinePlayers()) {
                Sender.send(players, sb.toString());
            }

        } else {
            Sender.send("Only in-game command!");
        }

    }

    @Override
    public String commandName() {
        return "clearchat";
    }

    @Override
    public String permission() {
        return "test.chatclear";
    }

    @Override
    public String[] aliases() {
        return new String[]{"cc", "clearc"};
    }

    @Override
    public String description() {
        return "Clear chat command";
    }

    @Override
    public List<String> getErrorMessageArgs() {
        return new ArrayList<>();
    }

    @Override
    public String getErrorMessageArg() {
        return "/cc";
    }

    @Override
    public int getMinArgs() {
        return 0;
    }

    @Override
    public int getMaxArgs() {
        return 0;
    }

    @Override
    public String noPermission() {
        return "You doesn't have permission for this command!";
    }

    @Override
    public <S extends CommandSender> List<String> getCompleter(S sender, String[] args) {
        return null;
    }

}
