package com.shadow.lengthoflongestsubstring;

/**
 * 无重复字符的最长子串
 *
 * @author austin
 * @since 2023-07-24
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int length = 0;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[j] == charArray[i]) {
                    length = Math.max(j - i, length);
                    break;
                } else {
                    length = Math.max(j - i + 1, length);
                }
            }
        }
        return length;
    }

}