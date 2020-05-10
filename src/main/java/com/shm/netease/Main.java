package com.shm.netease;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int T = in.nextInt();
//            dao[] daos = new dao[T];
            int[] da = new int[T];
            for (int n = 0; n < T; n++) {
                int M = in.nextInt();
                int L = in.nextInt();
//                daos[n].M = M;
//                daos[n].L = L;
                int[][] arr = new int[M][M];
                for (int i = 0; i < M; i++) {
                    for (int j = 0; j < M; j++) {
                        int a = in.nextInt();
                        arr[i][j] = a;
                    }
                }
//                daos[n].arr = arr;
                int x = in.nextInt();
                int y = in.nextInt();
//                daos[n].x = x;
//                daos[n].y = y;
                HashMap<String,Double> map = new HashMap<>();
                double[][] lens = new double[M][M];
                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr.length; j++) {
                            if (arr[i][j] != 0) {
//                                lens[i][j] = Math.sqrt(Math.pow(x - i, 2) + Math.pow(y - j, 2));
//                                if (lens[j] <= L) {
//                                    L = L + arr[i][j];
//                                }
                                double len = Math.sqrt(Math.pow(x - i, 2) + Math.pow(y - j, 2));
                                String s = ""+i+j;
                                map.put(s,len);
                            }
                        }
                    }
            }

        }

    }

    class node{
        private double length;
        private int p;

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public int getP() {
            return p;
        }

        public void setP(int p) {
            this.p = p;
        }
    }
    class dao {
        private int M;
        private int L;
        private int[][] arr;
        private int x;
        private int y;

        public int getM() {
            return M;
        }

        public void setM(int m) {
            M = m;
        }

        public int getL() {
            return L;
        }

        public void setL(int l) {
            L = l;
        }

        public int[][] getArr() {
            return arr;
        }

        public void setArr(int[][] arr) {
            this.arr = arr;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    private static void sort(double array[]) {
        double tmp = 0;
        double lastExchangeIndex = 0;
        double sortBorder = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }


//    作者：Harmon
//    链接：https://www.nowcoder.com/discuss/405887?type=1
//    来源：牛客网

    static int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int num = in.nextInt();
////in.nextLine();
////System.out.println("");
//        for(int t=0; t<num; t++){
//            int m=in.nextInt();
//            int len=in.nextInt();
//            int[][] grid=new int[m][m];
//            in.nextLine();
//            for(int i=0; i<m; i++){
//                for(int j=0; j<m; j++){
//                    grid[i][j]=in.nextInt();
//                }
//            }
//            int x=in.nextInt();
//            int y=in.nextInt();
//            boolean[][] visited = new boolean[m][m];
//            System.out.println(lenOfBlade(grid, len, visited, x, y));
////in.nextLine();
//        }
//    }

    public static int lenOfBlade(int[][] grid, int len, boolean[][] visited, int i, int j){
        if(grid==null || grid.length==0 || grid[0].length==0) {
            return len;
        }
        int m=grid.length;
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{i, j});
        while(!q.isEmpty()){
            int size=q.size();
            int plus=0;
            for(int n=0; n<size; n++){
                int[] cur=q.poll();
                int x=cur[0];
                int y=cur[1];
//System.out.println("x: "+x+", y: "+y);
                visited[x][y]=true;
                plus+=grid[x][y];
                grid[x][y]=0;
                for(int[] d: directions){
                    int xx=x+d[0];
                    int yy=y+d[1];
                    if(xx<0 || xx>=m || yy<0 || yy>=m || ((xx-i)*(xx-i)+(yy-j)*(yy-j)>len*len)|| visited[xx][yy]==true){
                        continue;
                    }
                    q.offer(new int[]{xx,yy});
                }
            }
            len+=plus;
        }
        return len;
    }
}
