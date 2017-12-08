package org.siberteam.tumasov.sorters;

import java.util.Comparator;

public class SortByHashCode implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.hashCode(), o2.hashCode());
    }
}