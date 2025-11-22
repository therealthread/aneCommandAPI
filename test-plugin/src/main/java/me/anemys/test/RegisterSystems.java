package me.anemys.test;

import me.anemys.commandapi.CommandManager;

import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class RegisterSystems {

    public void register(JavaPlugin plugin, IServerSystem... systems) {

        CommandManager commandManager = new CommandManager(plugin);

        for (IServerSystem system : systems) {

            commandManager.register(system.commandName())
                    .permission(system.permission())
                    .aliases(system.aliases())
                    .description(system.description())
                    .arguments(system.getMinArgs(), system.getMaxArgs(), system.getErrorMessageArgs())
                    .playerExecutor(system::getCommand)
                    .consoleExecutor(system::getCommand)
                    .tabCompleter(system::getCompleter)
                    .noPermissionMessage(system.noPermission())
                    .register();

        }

    }

}
