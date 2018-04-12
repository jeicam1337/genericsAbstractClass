package com.company;

import java.util.Comparator;

public class TableComparator<T extends Team> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (o1.getPoints() > o2.getPoints()) {
            return -1;
        }
        else if (o1.getPoints() < o2.getPoints()) {
            return 1;
        }
        return 0;
    }
}
