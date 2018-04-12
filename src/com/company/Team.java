package com.company;

import java.util.Objects;

public abstract class Team {
    private String name;
    private int matches;
    private int points;

    public Team(String name) {
        this.name = name;
        this.matches = 0;
        this.points = 0;
    }

    void incrementMatches() {
        this.matches++;
    }

    void pointsToAdd(int howManyPoints) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return matches == team.matches &&
                points == team.points &&
                Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, matches, points);
    }
}
