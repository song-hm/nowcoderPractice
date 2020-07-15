package com.shm.kujiale;

import javafx.util.Pair;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x=0,y=0;
        HashMap<Date,Pair<Integer,Integer>> map = new HashMap<>();
        HashSet<Pair<Integer,Integer>> set = new HashSet<>();
        while (sc.hasNextLine()){
            String str = sc.nextLine();
            String[] split = str.split(" ");
            if (!split[0].equals("init")&&!split[0].equals("sell")&&!split[0].equals("print")&&!split[0].equals("listorder")){
                System.out.println("命令有误");
            }
            if (split[0].equals("init")){
                x=Integer.valueOf(split[1]);
                y=Integer.valueOf(split[2]);
            }
            if (split[0].equals("sell")){
                if (Integer.valueOf(split[1])<1||Integer.valueOf(split[2])<1||Integer.valueOf(split[1])>=x ||Integer.valueOf(split[1])>=y){
                    System.out.println("你选择的座位的座位不存在");
                }else {
                    Pair p = new Pair(Integer.valueOf(split[1])-1, Integer.valueOf(split[2])-1);
                    if (set.contains(p)){
                        System.out.println("当前座位已售出");
                    }else {
                        Date date = new Date();
                        set.add(p);
                        map.put(date,p);
                    }
                }
            }
            if (str.equals("print")){
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
            if (str.equals("listorder")){
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
