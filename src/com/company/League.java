package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League<T extends Team> {

    private String name;
    private List<T> teamList;

    public League(String name) {
        this.name = name;
        this.teamList = new ArrayList<>();
    }

    void addTeam(T team) {
        teamList.add(team);
    }

    void printTable() {
        System.out.println(name);
        Collections.sort(teamList, new TableComparator());
        for (int i = 0; i < teamList.size(); i++) {
            System.out.println(i + 1 + " " + teamList.get(i));
        }
    }

    void addMatch(T homeTeam, T awayTeam, int homeGoals, int awayGoals) {
        homeTeam.addMatch();
        awayTeam.addMatch();
        if (homeGoals > awayGoals) {
            homeTeam.addPoints(3);
        } else if (homeGoals < awayGoals) {
            awayTeam.addPoints(3);
        } else {
            homeTeam.addPoints(1);
            awayTeam.addPoints(1);
        }
    }

}

