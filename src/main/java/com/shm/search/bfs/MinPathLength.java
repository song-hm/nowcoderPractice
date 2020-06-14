package com.shm.search.bfs;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**广度优先搜索一层一层遍历，每一层得到的所有新节点，要用队列存储起来以备下一层遍历的时候再遍历。
 * 1. 计算在网格中从原点到特定点的最短路径长度
 * [[1,1,0,1],
 * [1,0,1,0],
 * [1,1,1,1],
 * [1,0,1,1]]
 * 题目描述：1 表示可以经过某个位置，求解从 (0, 0) 位置到 (tr, tc) 位置的最短路径长度。
 */
public class MinPathLength {
    public int minPathLength(int[][] grids, int tr, int tc) {
        final int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        final int m = grids.length,n=grids[0].length;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0,0));
        int pathLength = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            pathLength++;
            while (size-- > 0){
                Pair<Integer,Integer> cur = queue.poll();
                int cr = cur.getKey(),cc = cur.getValue();
                grids[cr][cc] = 0;//标记
                for (int[] ints : direction) {
                    int nr = cr + ints[0], nc = cc + ints[1];
                    if (nr<0 || nr >= m || nc < 0 || nc >= n || grids[nr][nc] == 0){
                        continue;
                    }
                    if (nr == tr && nc == tc){
                        return pathLength;
                    }
                    queue.add(new Pair<>(nr,nc));
                }
            }
        }
        return -1;
    }
}
