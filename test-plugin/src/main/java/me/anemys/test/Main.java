package me.anemys.test;

import me.anemys.test.examples.ChatClear;
import me.anemys.test.examples.Feed;
import me.anemys.test.examples.Hat;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        RegisterSystems registerSystems = new RegisterSystems();
        //new RegisterSystems().... smaller using >:/
        registerSystems.register(
                this,
                new ChatClear(),
                new Feed(),
                new Hat()
        );

    }
}
