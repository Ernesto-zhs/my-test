package com.shadow.maxscorewords;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MaxScoreWords {

    public int maxScoreWords(String[] words, char[] letters, int[] scores) {
        // 单词组合情况
        List<List<String>> groupList = getGroupList(new ArrayList<>(Arrays.asList(words)), new ArrayList<>(), 0);
        // 组合情况分数相加
        return getVal(groupList, letters, scores);
    }

    /**
     * 本质递归法
     */
    private static List<List<String>> getGroupList(List<String> keyList, List<List<String>> result, int index) {
        if (index == keyList.size()) {
            result.add(new ArrayList<>());
        } else {
            List<List<String>> arr = new ArrayList<>(getGroupList(keyList, result, index + 1));
            for (List<String> eList : arr) {
                List<String> temp = new ArrayList<>(eList);
                temp.add(keyList.get(index));
                result.add(temp);
            }
        }
        return result;
    }

    private static int getVal(List<List<String>> groupList, char[] letters, int[] scores) {
        Map<Character, Integer> countMap = getLetterCountMap(letters);
        Map<Character, Integer> scoreMap = getLetterScoreMap(letters, scores);
        int val = 0;
        for (List<String> list : groupList) {
            val = Math.max(val, getSum(countMap, scoreMap, list));
        }
        return val;
    }

    /**
     * 求和
     *
     * @param countMap 数量集合
     * @param scoreMap 分数集合
     * @param element  元素集合
     */
    private static int getSum(Map<Character, Integer> countMap, Map<Character, Integer> scoreMap, List<String> element) {
        int sum = 0;
        Map<Character, Integer> letterCountMap = new HashMap<>(countMap);
        Map<Character, Integer> letterScoreMap = new HashMap<>(scoreMap);
        for (String s : element) {
            char[] charArray = s.toCharArray();
            boolean flag = checkFlag(letterCountMap, charArray);
            if (flag) {
                for (char c : charArray) {
                    sum += letterScoreMap.get(c);
                }
            }
        }
        return sum;
    }

    /**
     * 检查字符串是否可以求和
     *
     * @param letterCountMap 字母次数
     * @param letterScoreMap 字母分数
     * @param charArray      字母数组
     */
    private static boolean checkFlag(Map<Character, Integer> letterCountMap, char[] charArray) {
        boolean flag = true;
        for (char c : charArray) {
            BiFunction<Character, Integer, Integer> function = (k, v) -> v - 1 > 0 ? v - 1 : letterCountMap.remove(c);
            Integer count = letterCountMap.computeIfPresent(c, function);
            if (Objects.isNull(count)) {
                flag = false;
            }
        }
        return flag;
    }

    /**
     * 字母出现次数
     *
     * @param letters 获取字母出现次数
     */
    private static Map<Character, Integer> getLetterCountMap(char[] letters) {
        Map<Character, Integer> letterCountMap = new HashMap<>();
        for (char letter : letters) {
            BiFunction<Character, Integer, Integer> function = (k, v) -> Objects.isNull(v) ? 1 : v + 1;
            letterCountMap.compute(letter, function);
        }
        return letterCountMap;
    }

    /**
     * 字母分数
     *
     * @param letters 字母表
     * @param scores  分数表
     */
    private static Map<Character, Integer> getLetterScoreMap(char[] letters, int[] scores) {
        Map<Character, Integer> map = new HashMap<>();
        for (char letter : letters) {
            Function<Character, Integer> function = k -> scores[letter - 97];
            map.computeIfAbsent(letter, function);
        }
        return map;
    }

}
