package com.tenjava.entries.koesie10.t2.commands;

import com.tenjava.entries.koesie10.t2.TenJava;

public abstract class AbstractSubCommand implements SubCommand {
    protected TenJava plugin;

    public AbstractSubCommand(TenJava plugin) {
        this.plugin = plugin;
    }
}
