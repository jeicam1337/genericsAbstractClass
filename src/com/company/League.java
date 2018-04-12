package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League<T extends Team> {

    private final static int pointsForWin = 3;
    private final static int pointsForDraw = 1;
    private String name;
    private List<T> teamList;
    private TableComparator comp = new TableComparator();

    public League(String name) {
        this.name = name;
        this.teamList = new ArrayList<>();
    }

    void addTeam(T team) {
        teamList.add(team);
        Collections.sort(teamList, comp);
    }


    void printTable() {
        System.out.println(name);
        for (int i = 0; i < teamList.size(); i++) {
            System.out.println(i + 1 + " " + teamList.get(i));
        }
    }

    void addMatch(T homeTeam, T awayTeam, int homeGoals, int awayGoals) {

        Match<T> match = new Match<>(homeTeam, awayTeam, homeGoals, awayGoals);

        homeTeam.incrementMatches();
        awayTeam.incrementMatches();

        if (homeTeam.equals(match.getWinner())) {
            homeTeam.pointsToAdd(pointsForWin);
        } else if (awayTeam.equals(match.getWinner())) {
            awayTeam.pointsToAdd(pointsForWin);
        } else {
            homeTeam.pointsToAdd(pointsForDraw);
            awayTeam.pointsToAdd(pointsForDraw);
        }
        Collections.sort(teamList, comp);
    }

    class Match<T extends Team> {

        private T homeTeam;
        private T awayTeam;
        private int homeGoals;
        private int awayGoals;

        public Match(T homeTeam, T awayTeam, int homeGoals, int awayGoals) {
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
            this.homeGoals = homeGoals;
            this.awayGoals = awayGoals;
        }

        T getWinner() {
            if (homeGoals > awayGoals) {
                return homeTeam;
            } else if (homeGoals < awayGoals) {
                return awayTeam;
            } else {
                return null;
            }
        }

        public int getHomeGoals() {
            return homeGoals;
        }

        public int getAwayGoals() {
            return awayGoals;
        }


    }

}

