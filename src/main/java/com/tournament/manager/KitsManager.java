package com.tournament.manager;

import com.tournament.obj.impl.Kit;

import java.util.HashMap;
import java.util.Set;

public class KitsManager {

    private final HashMap<String,Kit> kits;

    public KitsManager() {
        this.kits = new HashMap<>();
    }
    public void addKit(Kit kit, String arena){
        kits.put(arena, kit);
    }

    public void removeKit(String arena){
        kits.remove(arena);
    }

    public Kit getKit(String name){
        return kits.get(name);
    }


}
