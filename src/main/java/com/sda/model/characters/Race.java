package com.sda.model.characters;

public enum Race {
    HUMAN(100), GHOUL(80), MUTANT(120);
    private int raceHitPoints;

    Race(int raceHitPoints) {
        this.raceHitPoints = raceHitPoints;
    }

    public int getRaceHitPoints() {
        return raceHitPoints;
    }
}
