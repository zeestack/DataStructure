package com.zahid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Finder {

    public int[] twoSum(int[] input, int targetSum) {
        //a + b = targetSum
        //b = sum - a; or a = targetSum - b;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            var b = targetSum - input[i];
            if (map.containsKey(b))
                return new int[]{map.get(b), i};
            map.put(input[i], i);
        }

        return null;
    }

    public int countPairsWithDiff(int[] input, int k) {
        //a-b = k  --> a & b belongs to array
        //b = k + a --> given the value "a" b should also be in array?

        Set<Integer> set = new HashSet<>();
        for (var number : input) set.add(number);
        int count = 0;
        for (var number : set) {
            var b = number + k;
            if (set.contains(b)) {
                System.out.println("(" + number + "," + b + ")");
                count++;
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

    public int getLongestNonRepeatedStringLength(String str) {

        if (str == null) throw new IllegalArgumentException();

        String subStr = "";
        String longestSubString = "";

        int maxLength = 0;

        for (char ch : str.toCharArray()) {

            var current = String.valueOf(ch);

            if (subStr.contains(current))
                subStr = "";
            
            subStr = subStr.concat(String.valueOf(ch));

            if (maxLength < subStr.length()) {
                longestSubString = subStr;
                maxLength = longestSubString.length();
            }

        }

        System.out.println("Longest Sub-String: " + longestSubString);
        return maxLength;
    }

}
