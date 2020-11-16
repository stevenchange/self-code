package com.self.code.leetcode;

import java.util.Arrays;

/**
 * @Author: gaobo07
 * @Date: 2020/9/14 3:43 下午
 */
public class MinimumOperations {

    // * dp[0][i]代表以leaves[i]结尾的r...r的最少修改次数
    // * dp[1][i]代表以leaves[i]结尾的r...ry...y的最少修改次数
    // * dp[2][i]代表以leaves[i]结尾的r...ry...yr...r的最少修改次数
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        int[][] dp = new int[3][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, (int) 1e6);
        }
        //rrryyyrryyyrr
        dp[0][0] = leaves.charAt(0) == 'r' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + (leaves.charAt(i) == 'y' ? 1 : 0);
            System.out.println("dp 0 "+i+"  : "+dp[0][i]);
            dp[1][i] = Math.min(dp[0][i-1], dp[1][i-1]) + (leaves.charAt(i) == 'r' ? 1 : 0);
            System.out.println("dp 1 "+i+"  : "+dp[1][i]);
            dp[2][i] = Math.min(dp[1][i-1], dp[2][i-1]) + (leaves.charAt(i) == 'y' ? 1 : 0);
            System.out.println("dp 2 "+i+"  : "+dp[2][i]);
        }
        return dp[2][n - 1];
    }

    /**
     * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
     * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于
     * 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
     *
     * 输入：leaves = "rrryyyrryyyrr"
     * 输出：2
     * 解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
     *
     * @param args
     */
    public static void main(String[] args) {
        String leaves = "rrryyyrryyyrr";
//        int[][] dp = new int[3][leaves.length()];
//        //初始状态,保证第一个字符必须为r
//        dp[0][0] = leaves.charAt(0) == 'r' ? 0 : 1;
//        //因为第一个字符已经保证是r了，所以只要设置成一个比较大的值就可以了
//        dp[1][0] = (int)1e6;
//        dp[2][0] = (int)1e6;
//        for (int i = 1; i < leaves.length(); i++) {
//            char c = leaves.charAt(i);
//            //dp[0][i]只要统计在下标i之前y的个数即可（即把所有的y都替换成r）
//            dp[0][i] = dp[0][i - 1] + (c == 'y' ? 1 : 0);
//            System.out.println("dp 0 "+i+"  : "+dp[0][i]);
//            //dp[1][i]可能由r...r转过来，也有可能由r...ry...y转过来，如果当前字符为r则需要替换为y
//            dp[1][i] = Math.min(dp[1][i - 1], dp[1][i - 1]) + (c == 'r' ? 1 : 0);
//            System.out.println("dp 1 "+i+"  : "+dp[1][i]);
//            //dp[2][i]可能由r...ry...y转过来，也有可能由r...ry...yr...r转过来，如果当前字符为y则需要替换为r
//            dp[2][i] = Math.min(dp[2][i - 1], dp[2][i - 1]) + (c == 'y' ? 1 : 0);
//            System.out.println("dp 2 "+i+"  : "+dp[2][i]);
//        }
//
//        System.out.println(dp[2][leaves.length() - 1]);

        MinimumOperations operations = new MinimumOperations();

        System.out.println("result:"+operations.minimumOperations(leaves));
    }

}
