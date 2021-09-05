package com.zahid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Finder {

    private class Pair {
        private int x;
        private int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isEqual(Pair y) {
            return ((this.x == y.x || this.x == y.y) && (this.y == y.y || this.y == y.x));
        }
    }

    public int countPairsWithDiff(int[] input, int k) {

        int count = 0;
        for (var x : input) {
            for (var y : input) {
                if (x - y == k) count++;
            }
        }

        return count;
    }

    public int mostFrequent(int[] input) {
        Map<Integer, Integer> map = new HashMap<>();
        int mostFrequent = 0, maxCount = 0, sumCount = 0;
        for (var number : input) {
            var count = map.containsKey(number) ? map.get(number) + 1 : 1;
            map.put(number, count);
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = number;
            }
            sumCount += count == 1 ? count : 0;
        }
        return sumCount == input.length ? -1 : mostFrequent;
    }

    public char findFirstRepeatedChar(String str) {
        HashSet<Character> set = new HashSet<>();
        var chars = str.toCharArray();

        for (Character ch : chars)
            set.add(ch);

        for (Character ch : chars)
            if (set.contains(ch)) return ch;

        return Character.MIN_VALUE;
    }


    public char findFirstNonRepeatedChar(String str) {
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
