package org.siberteam.tumasov.sorters;

import java.util.*;

public class SortBySymbolsCount implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}