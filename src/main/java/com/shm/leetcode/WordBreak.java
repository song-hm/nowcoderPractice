package com.shm.leetcode;
/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 链接：https://leetcode-cn.com/problems/word-break
 */

import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int i;
        boolean flag = false;
        for (i = 0; i < n;) {
            int k = i;
            flag = false;
            char c = s.charAt(i);
            for (String s1 : wordDict) {
                if (s1.charAt(0) == c){
                    int length = s1.length();
                    String s2 = s.substring(i, i+length);
                    if (s1.equals(s2)){
                        i = i+length;
                        flag = true;
                        break;
                    }
                }
            }
            if(i==k){
                return false;
            }
        }
        return flag;
    }

    /**
     * 方法一：动态规划
     * 思路和算法
     *
     * 我们定义 \textit{dp}[i]dp[i] 表示字符串 ss 前 ii 个字符组成的字符串 s[0..i-1]s[0..i−1] 是否能被空格拆分成若干个字典中出现的单词。从前往后计算考虑转移方程，每次转移的时候我们需要枚举包含位置 i-1i−1 的最后一个单词，看它是否出现在字典中以及除去这部分的字符串是否合法即可。公式化来说，我们需要枚举 s[0..i-1]s[0..i−1] 中的分割点 jj ，看 s[0..j-1]s[0..j−1] 组成的字符串 s_1s
     * 1
     * ​
     *  （默认 j = 0j=0 时 s_1s
     * 1
     * ​
     *   为空串）和 s[j..i-1]s[j..i−1] 组成的字符串 s_2s
     * 2
     * ​
     *   是否都合法，如果两个字符串均合法，那么按照定义 s_1s
     * 1
     * ​
     *   和 s_2s
     * 2
     * ​
     *   拼接成的字符串也同样合法。由于计算到 \textit{dp}[i]dp[i] 时我们已经计算出了 \textit{dp}[0..i-1]dp[0..i−1] 的值，因此字符串 s_1s
     * 1
     * ​
     *   是否合法可以直接由 dp[j]dp[j] 得知，剩下的我们只需要看 s_2s
     * 2
     * ​
     *   是否合法即可，因此我们可以得出如下转移方程：
     *
     * \textit{dp}[i]=\textit{dp}[j]\ \&\&\ \textit{check}(s[j..i-1])
     * dp[i]=dp[j] && check(s[j..i−1])
     *
     * 其中 \textit{check}(s[j..i-1])check(s[j..i−1]) 表示子串 s[j..i-1]s[j..i−1] 是否出现在字典中。
     *
     * 链接：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode-solution/
     *
     * 复杂度分析
     *
     * 时间复杂度：O(n^2)O(n
     * 2
     *  ) ，其中 nn 为字符串 ss 的长度。我们一共有 O(n)O(n) 个状态需要计算，每次计算需要枚举 O(n)O(n) 个分割点，哈希表判断一个字符串是否出现在给定的字符串列表需要 O(1)O(1) 的时间，因此总时间复杂度为 O(n^2)O(n
     * 2
     *  )。
     *
     * 空间复杂度：O(n)O(n) ，其中 nn 为字符串 ss 的长度。我们需要 O(n)O(n) 的空间存放 \textit{dp}dp 值以及哈希表亦需要 O(n)O(n) 的空间复杂度，因此总空间复杂度为 O(n)O(n)。
     *
     * 链接：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode-solution/
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak_2(String s, List<String> wordDict) {
        HashSet<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]&&wordDictSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * 2，动态规划，
     * dp[i]表示的是字符串s中的前i个字符能出现在字典dict中，递推公式
     * dp[i]=dp[k]&&s.substring(k, i).equals(str)（str是枚举字典中的字符串）
     * 比如dp["leetcode".length()]=dp["leet".length()]&&"code".equals("这个是字典中的字符串")
     *
     * 链接：https://leetcode-cn.com/problems/word-break/solution/javaban-ben-de-2chong-xie-fa-by-sdwwld/
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak_3(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                String s1= wordDict.get(j);
                int length = s1.length();
                if (length<=i&&dp[i-length]&&wordDict.contains(s.substring(i-length,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }

}
