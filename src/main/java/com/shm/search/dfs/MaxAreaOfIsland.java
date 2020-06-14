package com.shm.search.dfs;

/**在程序实现 DFS 时需要考虑以下问题：
 栈：用栈来保存当前节点信息，当遍历新节点返回时能够继续遍历当前节点。可以使用递归栈。
 标记：和 BFS 一样同样需要对已经遍历过的节点进行标记。
 1. 查找最大的连通面积
 https://leetcode-cn.com/problems/max-area-of-island/description/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 * 695. 岛屿的最大面积
 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 示例 1:
 [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 示例 2:
 [[0,0,0,0,0,0,0,0]]
 对于上面这个给定的矩阵, 返回 0。
 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 */
public class MaxAreaOfIsland {
    private int m,n;
    private int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea ,dfs(grid,i,j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid,int r,int c){
        if (r<0||r>=m||c<0||c>=n||grid[r][c]==0){
            return 0;
        }
        grid[r][c] = 0;
        int area = 1;
        for (int[] ints : direction) {
            area+=dfs(grid,r+ints[0],c+ints[1]);
        }
        return area;
    }
}
