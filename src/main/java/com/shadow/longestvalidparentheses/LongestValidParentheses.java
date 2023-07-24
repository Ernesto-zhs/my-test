package com.shadow.longestvalidparentheses;

/**
 * 最长有效括号
 *
 * @author austin
 * @since 2023-07-21
 */
class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        if (!s.contains("()")) {
            return 0;
        }
        int result = 0;


        return 0;
    }

    public static void main(String[] args) {
        String s = "(()";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }
}