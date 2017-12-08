package org.siberteam.tumasov.sorters;

import java.util.Comparator;

public class SortByReversingWord implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        o1 = new StringBuilder(o1).reverse().toString();
        o2 = new StringBuilder(o2).reverse().toString();

        return o1.compareTo(o2);
    }
}