package com.shm.leetcode;

/**
 * 面试题 16.18. 模式匹配
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 *
 * 示例 1：
 *
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 * 示例 2：
 *
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 * 示例 3：
 *
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 * 示例 4：
 *
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 * 提示：
 *
 * 0 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pattern-matching-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class PatternMatching {
    /**
     * 方法一：枚举
     * 思路与算法
     *
     * 我们设 \textit{pattern}pattern 的长度为 \ell_pℓ
     * p
     * ​
     *  ，\textit{value}value 的长度为 \ell_vℓ
     * v
     * ​
     *  。根据题目描述，我们需要给字母 aa 和 bb 分配不同的字符串值（可以为空字符串），使得将 \textit{pattern}pattern 中的字母替换成对应的字符串后，结果与 \textit{value}value 相同。
     *
     * 在分配字符串之前，我们不妨先分配 aa 和 bb 对应字符串的长度。如果确定了长度，那么我们只要将 \textit{value}value 按照 \textit{pattern}pattern 中出现字母的顺序，划分成 \ell_pℓ
     * p
     * ​
     *   个子串，并判断其中 aa 对应的子串是否相同，以及 bb 对应的子串是否相同即可。具体地，假设 \textit{pattern}pattern 中出现了 c_ac
     * a
     * ​
     *   个 aa 以及 \ell_p - c_aℓ
     * p
     * ​
     *  −c
     * a
     * ​
     *   个 bb，并且 aa 和 bb 对应字符串的长度分别为 \ell_aℓ
     * a
     * ​
     *   和 \ell_bℓ
     * b
     * ​
     *  ，那么必须要满足：
     *
     * c_a * \ell_a + (\ell_p - c_a) * \ell_b = \ell_v
     * c
     * a
     * ​
     *  ∗ℓ
     * a
     * ​
     *  +(ℓ
     * p
     * ​
     *  −c
     * a
     * ​
     *  )∗ℓ
     * b
     * ​
     *  =ℓ
     * v
     * ​
     *
     *
     * 其中 c_ac
     * a
     * ​
     *   是已知的常量，\ell_aℓ
     * a
     * ​
     *   和 \ell_bℓ
     * b
     * ​
     *   是未知数。这是一个二元一次方程，可能无解、有唯一解或者无数解。然而我们需要的仅仅是自然数解，也就是 \ell_aℓ
     * a
     * ​
     *   和 \ell_bℓ
     * b
     * ​
     *   都大于等于 00 的解，因此我们可以直接枚举 \ell_aℓ
     * a
     * ​
     *   的值，它必须是 [0, \frac{\ell_v}{c_a}][0,
     * c
     * a
     * ​
     *
     * ℓ
     * v
     * ​
     *
     * ​
     *  ] 之间的自然数，否则 \ell_bℓ
     * b
     * ​
     *   就不会大于等于 00 了。在枚举 \ell_aℓ
     * a
     * ​
     *   之后，我们将其带入等式并解出 \ell_bℓ
     * b
     * ​
     *  。如果 \ell_bℓ
     * b
     * ​
     *   是整数，我们就枚举了一组 aa 和 bb 的可能长度。
     *
     * 在枚举了长度之后，我们就可以根据 \textit{pattern}pattern 来将 \textit{value}value 划分成 \ell_pℓ
     * p
     * ​
     *   个子串。具体地，我们遍历 \textit{pattern}pattern，并用一个指针 \textit{pos}pos 来帮助我们进行划分。当我们遍历到一个 aa 时，我们取出从 \textit{pos}pos 开始，长度为 \ell_aℓ
     * a
     * ​
     *   的子串。如果这是我们第一次遇到字母 aa，我们就得到了 aa 应该对应的子串；否则，我们将取出的子串与 aa 应该对应的子串进行比较，如果不相同，说明模式匹配失败。
     *
     * 同理，当我们遍历到一个 bb 时，我们取出从 \textit{pos}pos 开始，长度为 \ell_bℓ
     * b
     * ​
     *   的子串，根据是否第一次遇到字母 bb 来进行比较。在比较结束后，我们将 \textit{pos}pos 向后移动，进行下一个字母的匹配。
     *
     * 在遍历完成之后，如果匹配没有失败，我们还需要判断一下 aa 和 bb 是否对应了不同的子串。只有它们对应的子串不同时，才是一种满足题目要求的模式匹配。
     *
     * 细节
     *
     * 上面的算法看上去不是很复杂：我们只需要用一重循环枚举 \ell_aℓ
     * a
     * ​
     *  ，计算出 \ell_bℓ
     * b
     * ​
     *  ，再用一重循环遍历 \textit{pattern}pattern 以及移动 \textit{pos}pos 即可。但就像我们在「前言」部分所说的，本题有非常多的细节需要考虑。
     *
     * 我们回到二元一次方程：
     *
     * c_a * \ell_a + (\ell_p - c_a) * \ell_b = \ell_v
     * c
     * a
     * ​
     *  ∗ℓ
     * a
     * ​
     *  +(ℓ
     * p
     * ​
     *  −c
     * a
     * ​
     *  )∗ℓ
     * b
     * ​
     *  =ℓ
     * v
     * ​
     *
     *
     * 如果我们枚举 \ell_aℓ
     * a
     * ​
     *  ，那么必须要求 c_a \neq 0c
     * a
     * ​
     *
     * 
     * ​
     *  =0，因为在 c_a = 0c
     * a
     * ​
     *  =0 的情况下，原方程如果有解，那么一定有无数解（因为 \ell_aℓ
     * a
     * ​
     *   可以取任意值）。因此如果 c_a = 0c
     * a
     * ​
     *  =0，我们就必须枚举 \ell_bℓ
     * b
     * ​
     *  。这无疑增加了编码的复杂度，因为需要根据 c_ac
     * a
     * ​
     *   的值选择对 \ell_aℓ
     * a
     * ​
     *   或 \ell_bℓ
     * b
     * ​
     *   进行枚举，失去了统一性。并且，如果 \ell_p - c_aℓ
     * p
     * ​
     *  −c
     * a
     * ​
     *   也为 00，那么我们连 \ell_bℓ
     * b
     * ​
     *   都无法枚举。
     *
     * 因此，我们必须梳理一下判断的逻辑：
     *
     * 如果 \textit{pattern}pattern 为空，那么只有在 \textit{value}value 也为空时，它们才能匹配；
     *
     * 如果 \textit{value}value 为空，那么如果 \textit{pattern}pattern 也为空，就和第一条的情况相同；如果 \textit{pattern}pattern 中只出现了一种字母，我们可以令该字母为空，另一没有出现的字母为任意非空串，就可以正确匹配；如果 \textit{pattern}pattern 中出现了两种字母，那么就无法正确匹配，因为这两种字母都必须为空串，而题目描述中规定它们不能表示相同的字符串；
     *
     * 如果 \textit{pattern}pattern 和 \textit{value}value 均非空，那么我们需要枚举 \textit{pattern}pattern 中出现的那个字母（如果两个字母均出现，可以枚举任意一个）对应的长度，使用上面提到的算法进行判断。
     *
     * 对于上面的第三条，我们可以根据「对称性」减少代码的编写的复杂度：我们还是固定枚举 \ell_aℓ
     * a
     * ​
     *  ，但如果 c_a < \ell_p - c_ac
     * a
     * ​
     *  <ℓ
     * p
     * ​
     *  −c
     * a
     * ​
     *  ，即 aa 出现的次数少于 bb 出现的次数，那么我们就将 \textit{pattern}pattern 中所有的 aa 替换成 bb，bb 替换成 aa。这样做就保证了 aa 出现了至少一次（c_a > 0c
     * a
     * ​
     *  >0），枚举 \ell_aℓ
     * a
     * ​
     *   就不会有任何问题，同时不会影响答案的正确性。
     *
     * 这样一来，我们就可以优化判断的逻辑：
     *
     * 我们首先保证 \textit{pattern}pattern 中 aa 出现的次数不少于 bb 出现的次数。如果不满足，我们就将 aa 和 bb 互相替换；
     *
     * 如果 \textit{value}value 为空，那么要求 \textit{pattern}pattern 也为空（\ell_p = 0ℓ
     * p
     * ​
     *  =0）或者只出现了字母 aa（\ell_p - c_a = 0ℓ
     * p
     * ​
     *  −c
     * a
     * ​
     *  =0），这两种情况均等同于 \ell_p - c_a = 0ℓ
     * p
     * ​
     *  −c
     * a
     * ​
     *  =0。在其余情况下，都无法匹配成功；
     *
     * 如果 \textit{pattern}pattern 为空且 \textit{value}value 不为空，那么无法匹配成功；
     *
     * 如果 \textit{pattern}pattern 和 \textit{value}value 均非空，我们就可以枚举 \ell_aℓ
     * a
     * ​
     *   并使用上面提到的算法进行判断。
     *
     * 链接：https://leetcode-cn.com/problems/pattern-matching-lcci/solution/mo-shi-pi-pei-by-leetcode-solution/
     * @param pattern
     * @param value
     * @return
     */
    public boolean patternMatching(String pattern, String value) {
        int count_a = 0,count_b = 0;
        for (char c : pattern.toCharArray()) {
            if (c == 'a'){
                count_a++;
            }else {
                count_b++;
            }
        }
        if (count_a < count_b){
            int temp = count_a;
            count_a = count_b;
            count_b = temp;
            char[] array = pattern.toCharArray();
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i]=='a'?'b':'a';
            }
            pattern = new String(array);
        }
        if (value.length() == 0){
            return count_b==0;
        }
        if (pattern.length() == 0){
            return false;
        }
        for (int len_a = 0; len_a*count_a <= value.length(); len_a++) {
            int rest = value.length() - len_a*count_a;
            if (count_b == 0 && rest == 0 || (count_b != 0 && rest % count_b == 0)){
                int len_b = (count_b == 0?0:rest/count_b);
                int pos = 0;
                boolean correct = true;
                String value_a = "",value_b = "";

                for (char c : pattern.toCharArray()) {
                    if (c == 'a'){
                        String sub = value.substring(pos,pos+len_a);
                        if (value_a.length() == 0){
                            value_a = sub;
                        }else if (!value_a.equals(sub)){
                            correct = false;
                            break;
                        }
                        pos+=len_a;
                    }else {
                        String sub = value.substring(pos,pos+len_b);
                        if (value_b.length() == 0){
                            value_b = sub;
                        }else if (!value_b.equals(sub)){
                            correct = false;
                            break;
                        }
                        pos+=len_b;
                    }
                }
                if (correct && !value_a.equals(value_b)){
                    return true;
                }
            }
        }
        return false;
    }
}
