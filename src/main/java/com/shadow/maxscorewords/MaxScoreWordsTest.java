package com.shadow.maxscorewords;

import java.util.ArrayList;
import java.util.List;

public class MaxScoreWordsTest {

    public static void main(String[] args) {
        String[] words = {"dog", "cat", "dad", "good"};
        char[] letters = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] scores = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        MaxScoreWords maxScoreWords = new MaxScoreWords();
        int i = maxScoreWords.maxScoreWords(words, letters, scores);
        System.out.println(i);
//        print(words);
    }


    private static void print(String[] words) {
        int length = words.length;
        // dog , dog cat ,dog dad , dog good, dog cat dad, dog cat good , dog dad good, dog cat dad good
        // cat , cat dad, cat good, cat dad good
        // dad, dad good
        // good
        // 2的4次方 -1
        // dog , dog cat ,dog dad , dog cat dad
        // cat , cat dad
        // dad
        // 2的3次方 -1
        // 2的n次方-1
        // 长度为1
        // 长度为2
        // 长度为3
        // 长度为4
        // 长度为n

        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        getArr(words, result, temp, 0);
        System.out.println(result);

        List<List<String>> arr = getArr(words, new ArrayList<>(), 0);
        System.out.println(arr);

        List<List<String>> result1 = new ArrayList<>();
        getArr(words, result1);
        System.out.println(result1);
    }

    /**
     * 中序遍历法
     */
    private static void getArr(String[] words, List<List<String>> result, List<String> temp, int level) {
        if (level == words.length) {
            result.add(temp);
        } else {
            getArr(words, result, new ArrayList<>(temp), level + 1);
            temp.add(words[level]);
            getArr(words, result, new ArrayList<>(temp), level + 1);
        }
    }

    /**
     * 本质递归法
     */
    private static List<List<String>> getArr(String[] words, List<List<String>> result, int index) {
        if (index == words.length) {
            result.add(new ArrayList<>());
        } else {
            List<List<String>> arr = new ArrayList<>(getArr(words, result, index + 1));
            for (List<String> eList : arr) {
                List<String> temp = new ArrayList<>(eList);
                temp.add(words[index]);
                result.add(temp);
            }
        }
        return result;
    }

    /**
     * 二进制组合遍历
     */
    private static void getArr(String[] words, List<List<String>> result) {
        //子集的数量
        int n = 1 << words.length;
        for (int i = 0; i < n; i++) {
            List<String> temp = new ArrayList<>();
            int j = i;
            int index = words.length - 1;
            //循环前检测j是否是000
            while (j > 0) {
                if ((j & 1) == 1) {
                    temp.add(words[index]);
                }
                j = j >> 1;
                index--;
            }
            result.add(temp);
        }
    }


}
