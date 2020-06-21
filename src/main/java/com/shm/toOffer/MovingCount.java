package com.shm.toOffer;

/**
 * 机器人的运动范围
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {
    int count = 0;
    int[][] visited;
    public int movingCount(int threshold, int rows, int cols)
    {
        visited = new int[rows][cols];
        move(threshold,rows,cols,0,0);
        return count;
    }

//    链接：https://www.nowcoder.com/questionTerminal/6e5207314b5241fb83f2329e89fdecc8?answerType=1&f=discussion
//    来源：牛客网

    // 判断坐标是否符合要求
    public boolean isValid(int row, int col, int threshold){
        int sum = 0;
        while(row > 0){
            sum += row%10;
            row = row/10;
        }
        while(col >0){
            sum += col%10;
            col = col/10;
        }
        if(sum > threshold)return false;
        else return true;
    }
    public void move(int threshold, int rows, int cols,int row,int col){
        //先 //如果坐标不符合则不计数
        if (row < 0 || row >= rows || col>= cols || col<0) {
            return;
        }
        //后 //如果曾经被访问过则不计数
        if (visited[row][col] == 1){
            return;
        }
        //如果不满足坐标有效性，则不计数并且标记是访问的
        if(!isValid(row,col,threshold)){
            visited[row][col] = 1;
            return;
        }
        visited[row][col] = 1;
        count++;
        move(threshold, rows, cols, row - 1, col);
        move(threshold, rows, cols, row + 1, col);
        move(threshold, rows, cols, row, col - 1);
        move(threshold, rows, cols, row, col + 1);
    }


//    链接：https://www.nowcoder.com/questionTerminal/6e5207314b5241fb83f2329e89fdecc8?answerType=1&f=discussion
//    来源：牛客网

    // 判断坐标是否符合要求
//    public boolean isValid(int row, int col, int threshold){
//        int sum = 0;
//        while(row > 0){
//            sum += row%10;
//            row = row/10;
//        }
//        while(col >0){
//            sum += col%10;
//            col = col/10;
//        }
//        if(sum > threshold)return false;
//        else return true;
//    }
//    //统计能够走到的次数
//    public int count = 0;
//
//    public void help(int i, int j, int threshold, int rows, int cols, int[][] flag){
//        if(i < 0 || i >= rows || j < 0 || j >= cols)return;//如果坐标不符合则不计数
//        if(flag[i][j] == 1)return;//如果曾经被访问过则不计数
//        if(!isValid(i, j, threshold)){
//            flag[i][j] = 1;//如果不满足坐标有效性，则不计数并且标记是访问的
//            return;
//        }
//        //无论是广度优先遍历还是深度优先遍历，我们一定要知道的时候遍历一定会有终止条件也就是要能够停止，
//        //不然程序就会陷入死循环，这个一定是我们做此类题目必须要注意的地方
//        flag[i][j] = 1;
//        count++;
//        help(i-1, j, threshold, rows, cols, flag);//遍历上下左右节点
//        help(i+1, j, threshold, rows, cols, flag);
//        help(i, j-1, threshold, rows, cols, flag);
//        help(i, j+1, threshold, rows, cols, flag);
//    }
//
//
//    public int movingCount(int threshold, int rows, int cols)
//    {
//        int[][] flag = new int[rows][cols];
//        help(0, 0, threshold, rows, cols, flag);
//        return count;
//    }
}
