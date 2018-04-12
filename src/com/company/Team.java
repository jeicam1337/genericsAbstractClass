package com.company;

public abstract class Team {
    private String name;
    private int matches;
    private int points;

    public Team(String name) {
        this.name = name;
        this.matches = 0;
        this.points = 0;
    }

    void addMatch() {
        this.matches++;
    }

    void addPoints(int howManyPoints) {
        this.points += howManyPoints;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return name + "    " +
                " matches: " + matches +
                " points: " + points;
    }
}
