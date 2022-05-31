package com.ourrai;

import java.util.Comparator;

public class StringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        try {
            return Integer.compare(Integer.parseInt(s1) - Integer.parseInt(s2), 0);
        }catch (NumberFormatException e) {
            return s1.compareTo(s2);
        }
    }
}
