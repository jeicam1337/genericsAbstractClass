package com.company;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class League<T extends Team> {

    private final static int POINTS_FOR_WIN = 3;
    private final static int POINTS_FOR_DRAW = 1;
    private String name;
    private List<T> teamList;
    private final static TableComparator TABLE_COMPARATOR = new TableComparator();

    public League(@NotNull String name) {
        this.name = name;
        this.teamList = new ArrayList<>();
    }

    void addTeam(@NotNull T team) {
        Objects.requireNonNull(team, "a team cannot be null");
        teamList.add(team);
        Collections.sort(teamList, TABLE_COMPARATOR);
    }

    void printTable() {
        System.out.println(name);
        for (int i = 0; i < teamList.size(); i++) {
            System.out.println(i + 1 + " " + teamList.get(i));
        }
    }

    void addMatch(@NotNull T homeTeam, @NotNull T awayTeam, int homeGoals, int awayGoals) {

        Match<T> match = new Match<>(homeTeam, awayTeam, homeGoals, awayGoals);

        homeTeam.incrementMatches();
        awayTeam.incrementMatches();

        if (homeTeam.equals(match.getWinner())) {
            homeTeam.addPoints(POINTS_FOR_WIN);
        } else if (awayTeam.equals(match.getWinner())) {
            awayTeam.addPoints(POINTS_FOR_WIN);
        } else {
            homeTeam.addPoints(POINTS_FOR_DRAW);
            awayTeam.addPoints(POINTS_FOR_DRAW);
        }
        Collections.sort(teamList, TABLE_COMPARATOR);
    }

    class Match<T extends Team> {

        private T homeTeam;
        private T awayTeam;
        private int homeGoals;
        private int awayGoals;

        public Match(@NotNull T homeTeam, @NotNull T awayTeam, int homeGoals, int awayGoals) {

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
    }
}

