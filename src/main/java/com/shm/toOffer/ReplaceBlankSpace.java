package com.shm.toOffer;

/**
 * 替换空格
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceBlankSpace {

    /**
     * 1. 调用自带函数
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str){
        return str.toString().replace(" ", "%20");
    }

    /**
     * 2. 用新的数组存
     * 1. 分析：
     * 当遇到 " "，就追加 "%20"，否则遇到什么追加什么
     * @param str
     * @return
     */
    public String replaceSpace_2(StringBuffer str){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c == ' '){
                sb.append("%20");
            } else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
