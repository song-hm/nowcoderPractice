package com.shm.toOffer;

/**
 * 字符串	正则表达式匹配
 * 题目描述
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {
    public static void main(String[] args) {
//        System.out.println(match(new char[]{'a','a','a'}, "ab*ac*a".toCharArray()));
        System.out.println(match_2("aa".toCharArray(), "a*aaa".toCharArray()));
    }

    public static boolean match(char[] str, char[] pattern) {

//        String s = str.toString();
//        String s1 = pattern.toString();//数组地址
//        System.out.println(s1);
//        return s.matches(s1);


//        return new String(str).matches(new String(pattern));


        if (str.length<1&&pattern.length<1){
            return true;
        }
        int i=0,j=0;
        for (;i<str.length&&j<pattern.length;){
            if (str[i]==pattern[j]||pattern[j]=='.'){
                i++;
                j++;
            }else {
                int key = i;
                j++;
                if (j==pattern.length){
                    break;
                }
               if (pattern[j]=='*'){
                   while (str[i]==pattern[j-1]||pattern[j-1]=='.'){
                       i++;
                       if (i==str.length){
                           break;
                       }
                   }
                   j++;
                   if (j==pattern.length){
                       break;
                   }
                   int temp = i;
                   while(pattern[j]==str[temp-1]){
                       j++;
                       if (j==pattern.length){
                           break;
                       }
                       temp--;
                       if (temp<1){
                           break;
                       }
                       if (temp>key){
                           return false;
                       }
                   }
                   i++;
               }else {
                   return false;
               }
            }
        }
        if (i<str.length){
            return false;
        }
        if (j+2<pattern.length) {
            return false;
        }else {
            if (j+2==pattern.length){
                if(pattern[j+1]!='*')
                    return false;
            }else if(j+1==pattern.length){
                if(pattern[j]!='*')
                    return false;
            }
        }
        return true;
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 做对题目首先要读清题意：在本题中，匹配是指字符串的所有字符匹配整个模式。
     *
     * 模式串中可能存在'.*'，它是贪婪匹配，在使整个表达式能得到匹配的前提下匹配尽可能多的字符。例如字符串"abcdeded"与模式"a.*d"匹配。
     *
     * 按下一个字符是否是'*'分情况讨论，这个不难，但是要考虑全面有点难度。
     *
     * c/c++一个函数递归就搞定，而java写要两个函数，因为你不能向c/c++一样直接用str+1,或用str+1传参。
     *
     * @param str
     * @param pattern
     * @return
     */
    public static boolean match_2(char[] str, char[] pattern) {
        return matchStr(str,0,pattern,0);
    }

    public static boolean matchStr(char[] str,int i,char[] pattern,int j){
        // 边界
        // 字符串和模式串都为空
        if (i==str.length&&j==pattern.length){
            return true;
        }else if (j==pattern.length){
            // 模式串为空
            return false;
        }

        // 模式串下一个字符是'*'
        boolean next = (j+1<pattern.length&&pattern[j+1]=='*');
        if (next){
            // 要保证i<str.length，否则越界
            if (i<str.length&&(pattern[j]=='.'||str[i]==pattern[j])){
                return matchStr(str,i,pattern,j+2) || matchStr(str,i+1,pattern,j);
            }else {
                return matchStr(str,i,pattern,j+2);
            }
        }else{
            if (i< str.length&&(pattern[j]=='.'||str[i]==pattern[j])){
                return matchStr(str,i+1,pattern,j+1);
            }else {
                return false;
            }
        }
    }
}
