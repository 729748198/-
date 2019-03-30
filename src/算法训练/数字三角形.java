//问题描述
//　　（图３.１－１）示出了一个数字三角形。 请编一个程序计算从顶至底的某处的一条路
//　　径，使该路径所经过的数字的总和最大。
//　　●每一步可沿左斜线向下或右斜线向下走；
//　　●1＜三角形行数≤100；
//　　●三角形中的数字为整数0，1，…99；

//　　（图３.１－１）
//输入格式
//　　文件中首先读到的是三角形的行数。
//
//　　接下来描述整个三角形
//输出格式
//　　最大总和（整数）
//样例输入
//5
//7
//3 8
//8 1 0
//2 7 4 4
//4 5 2 6 5
//样例输出
//30
package 算法训练;

import java.util.Scanner;

public class 数字三角形 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int [][]num=new int[n+1][n+1];
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				num[i][j]=in.nextInt();
			}
		}
		
		int [][]dp=new int [n+1][n+1];
		for(int i=n-1;i>=0;i--)
		{
			for(int j=i;j>=0;j--) {
				dp[i][j]=Math.max(num[i][j]+dp[i+1][j], num[i][j]+dp[i+1][j+1]);
			}
		}
		System.out.println(dp[0][0]);
		
	}

}
