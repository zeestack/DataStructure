package com.zahid;

import java.util.HashMap;
import java.util.Map;

public class ChracterFinder {


    public char findNonRepeatedChar(String str) {
        Map<Character, Integer> map = new HashMap<>();

        var chars = str.toCharArray();
        for (Character ch : chars) {
            int count = map.containsKey(ch) ? map.get(ch) + 1 : 1;
            map.put(ch, count);
        }

        for (var ch : chars)
            if (map.get(ch) == 1)
                return ch;

        return Character.MIN_VALUE;
    }

}
