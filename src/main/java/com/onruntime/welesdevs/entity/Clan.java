package com.onruntime.welesdevs.entity;

import org.bukkit.OfflinePlayer;

import java.util.ArrayList;

public class Clan {
    private String name;
    private ArrayList<OfflinePlayer> members;

    public Clan(String name, ArrayList<OfflinePlayer> members) {
        this.name = name;
        this.members = members;
    }
}
