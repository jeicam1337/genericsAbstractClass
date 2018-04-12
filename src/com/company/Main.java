package com.company;

public class Main {

    public static void main(String[] args) {

        League<FootballTeam> ekstraklasa = new League("Ekstraklasa");
        FootballTeam wisla = new FootballTeam("Wisla");
        ekstraklasa.addTeam(wisla);
        FootballTeam legia = new FootballTeam("Legia");
        ekstraklasa.addTeam(legia);
        FootballTeam lech = new FootballTeam("Lech");
        ekstraklasa.addTeam(lech);

        ekstraklasa.addMatch(wisla, lech, 0, 3);
        ekstraklasa.addMatch(lech, legia, 1, 2);
        ekstraklasa.addMatch(legia, wisla, 0, 2);
        ekstraklasa.addMatch(lech, wisla, 1, 1);
        ekstraklasa.addMatch(legia, lech, 0, 3);
        ekstraklasa.addMatch(wisla, legia, 0, 1);

        ekstraklasa.printTable();
    }
}
