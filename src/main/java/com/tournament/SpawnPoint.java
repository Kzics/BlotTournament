package com.tournament;

import org.bukkit.Location;

public class SpawnPoint {


    private final Location location;
    public SpawnPoint(Location location){
        this.location = location;
    }

    public Location getLocation(){
        return location;
    }
}
