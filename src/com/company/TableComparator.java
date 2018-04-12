package com.company;

import java.util.Comparator;

public class TableComparator<T extends Team> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {

        if (o1 == null && o2 != null)
            return -1;
        if (o1 != null && o2 == null)
            return 1;

        return o2.getPoints() - o1.getPoints();
    }
}
