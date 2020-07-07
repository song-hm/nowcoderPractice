package com.shm;
import java.util.Scanner;
public class Main{
	public void swap(char [] arr,int front,int end) {
		while(front<end){
			char tmp;
			tmp=arr[front];
			arr[front]=arr[end];
			arr[end]=tmp;
			front++;
			end--; 
		}
	}
	public String swapWords(String str) {
		char[] charArry=str.toCharArray();
		int len=charArry.length;
		int begin=0;
		swap(charArry, 0, len-1);
		for(int i = 0;i < len;i++){
			if(charArry[i]==' '){
				swap(charArry, begin, i-1);
				begin=i+1;		
			}
		}
		swap(charArry, begin, len-1);
		return new String(charArry);
	}
	public static void main(String[] args) {
		StringBuilder string=new StringBuilder();
		Scanner scanner =new  Scanner(System.in);
		while(scanner.hasNext()){
			string.append(scanner.nextLine());
			System.out.println(new Main().swapWords(new String(string))) ;
		}
	}


//	#include<iostream>
//#include<cstdio>
//#include<cstring>
//#include<cmath>
//#include<algorithm>
//	using namespace std;
//	int pre[1010]; //里面全是掌门
//
//	int unionsearch(int root)
//	{
//		int son, tmp;
//		son = root;
//		while(root != pre[root]) //寻找掌门ing……
//			root = pre[root];
//		while(son != root) //路径压缩
//		{
//			tmp = pre[son];
//			pre[son] = root;
//			son = tmp;
//		}
//		return root; //掌门驾到~
//	}
//
//	int main()
//	{
//		int num, road, total, i, start, end, root1, root2;
//		while(scanf("%d%d", &num, &road) && num)
//		{
//			total = num - 1; //共num-1个门派
//			for(i = 1; i <= num; ++i) //每条路都是掌门
//				pre[i] = i;
//			while(road--)
//			{
//				scanf("%d%d", &start, &end); //他俩要结拜
//				root1 = unionsearch(start);
//				root2 = unionsearch(end);
//				if(root1 != root2) //掌门不同？踢馆！~
//				{
//					pre[root1] = root2;
//					total--; //门派少一个，敌人（要建的路）就少一个
//				}
//			}
//			printf("%d\n", total);//天下局势：还剩几个门派
//		}
//		return 0;
//	}

}
