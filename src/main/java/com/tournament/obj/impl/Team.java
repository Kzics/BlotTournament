package com.tournament.obj.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Team extends Participant {


    private final String name;
    private final Set<UUID> members;
    public Team(String name){
        this.name = name;
        this.members = new HashSet<>();
    }

    public Set<UUID> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }
}
