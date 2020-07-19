package com.shm.kujiale;

import javafx.util.Pair;
import java.util.*;

/**
 * 电影院售票
 * 此程序能够监听命令行输入，可以输入三类命令：
 * 1: init 5 10
 * 2: sell 4 6
 * 3: print
 * 第一条命令创建一个5排一排10座的影厅。
 * 第二条命令售出4排6座的票。
 * 第三条命令输出当前影厅的座位情况，'X'表示售出，'O'表示未售。
 * 按顺序执行上面三条命令后输出如下：
 * OOOOOOOOOO
 * OOOOOOOOOO
 * OOOOOOOOOO
 * OOOOOXOOOO
 * OOOOOOOOOO
 *
 * Hint: 请注意输入时的各种异常输入以及边界条件。
 *
 * bones：
 * 支持另外一种命令：
 * listorder
 * 按时间顺序输出售票记录，格式如下：
 * 2016-11-04 12:29:01 row 4 column 6
 * 2016-11-04 12:29:02 row 5 column 6
 */
public class Main0 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x=0,y=0;
        HashMap<Date,Pair<Integer,Integer>> map = new HashMap<>();
        HashSet<Pair<Integer,Integer>> set = new HashSet<>();
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            String[] split = str.split(" ");
            if (!"init".equals(split[0])&&!"sell".equals(split[0])&&!"print".equals(split[0])&&!"listorder".equals(split[0])){
                System.out.println("命令有误");
            }
            if ("init".equals(split[0])){
                x=Integer.parseInt(split[1]);
                y=Integer.parseInt(split[2]);
            }
            if ("sell".equals(split[0])){
                if (Integer.parseInt(split[1])<1||Integer.parseInt(split[2])<1||Integer.parseInt(split[1])>=x ||Integer.parseInt(split[1])>=y){
                    System.out.println("你选择的座位不存在");
                }else {
                    Pair p = new Pair(Integer.parseInt(split[1])-1, Integer.parseInt(split[2])-1);
                    if (set.contains(p)){
                        System.out.println("当前座位已售出");
                    }else {
                        Date date = new Date();
                        set.add(p);
                        map.put(date,p);
                    }
                }
            }
            if ("print".equals(str)){
                for (int i = 0; i < x; i++) {
                    for (int j = 0; j < y; j++) {
                        for (Pair<Integer, Integer> p : set) {
                            if (p.getKey()==i&&p.getValue()==j){
                                System.out.print("X");
                            }else {
                                System.out.print("O");
                            }
                        }
                    }
                    System.out.println();
                }
            }
            if ("listorder".equals(str)){
                Set<Date> dates = map.keySet();
                ArrayList list = new ArrayList();
                for (Date date : dates) {
                    list.add(date);
                }
                Collections.sort(list);
                for (Object o : list) {
                    System.out.println(new Date(o.toString()).toLocaleString()+" row "+map.get(o).getKey()+" column "+map.get(o).getValue());
                }
            }
        }
    }
}
