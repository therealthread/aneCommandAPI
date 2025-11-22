package me.anemys.test.examples;

import me.anemys.test.utils.Sender;
import me.anemys.test.IServerSystem;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;

public class Hat implements IServerSystem {

    @Override
    public <S extends CommandSender> void getCommand(S sender, String[] args) {
        if (senderIsPlayer(sender)) {

            Player p = (Player) sender;
            PlayerInventory inventory = p.getInventory();
            ItemStack hand = inventory.getItemInMainHand();
            ItemStack helmet = inventory.getHelmet();

            if (hand.getType() != Material.AIR) {

                inventory.setItemInMainHand(helmet);
                inventory.setHelmet(hand);

            } else {
                Sender.send(p, "First, hold an item in your hand!");
            }


        } else {
            Sender.send("Only in-game command!");
        }

    }

    @Override
    public String commandName() {
        return "hat";
    }

    @Override
    public String permission() {
        return "test.hat";
    }

    @Override
    public String[] aliases() {
        return new String[]{"use"};
    }

    @Override
    public String description() {
        return "Hat chat command";
    }

    @Override
    public String getErrorMessageArg() {
        return "/hat";
    }

    @Override
    public List<String> getErrorMessageArgs() {
        return new ArrayList<>();
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
