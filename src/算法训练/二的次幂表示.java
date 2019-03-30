//问题描述
//　　任何一个正整数都可以用2进制表示，例如：137的2进制表示为10001001。
//　　将这种2进制表示写成2的次幂的和的形式，令次幂高的排在前面，可得到如下表达式：137=2^7+2^3+2^0
//　　现在约定幂次用括号来表示，即a^b表示为a（b）
//　　此时，137可表示为：2（7）+2（3）+2（0）
//　　进一步：7=2^2+2+2^0 （2^1用2表示）
//　　3=2+2^0 
//　　所以最后137可表示为：2（2（2）+2+2（0））+2（2+2（0））+2（0）
//　　又如：1315=2^10+2^8+2^5+2+1
//　　所以1315最后可表示为：
//　　2（2（2+2（0））+2）+2（2（2+2（0）））+2（2（2）+2（0））+2+2（0）
//输入格式
//　　正整数（1<=n<=20000）
//输出格式
//　　符合约定的n的0，2表示（在表示中不能有空格）
//样例输入
//137
//样例输出
//2(2(2)+2+2(0))+2(2+2(0))+2(0)
//样例输入
//1315
//样例输出
//2(2(2+2(0))+2)+2(2(2+2(0)))+2(2(2)+2(0))+2+2(0)
//提示
//　　用递归实现会比较简单，可以一边递归一边输出
package 算法训练;

import java.util.Scanner;


public class 二的次幂表示 {

	public static void fun(int n) {
		if(n/2>0&&n!=2) {
			System.out.print(2);
		}else if (n==2) {
			System.out.print(2);
			return;
		}else if (n==1) {
			System.out.print("2(0)");
			return;
		}else if(n==0) {
			return;
		}
		int temp=0;

		if(n==2) {
			return;
		}
		if(n/2>1) {
			  temp=n/2;
			  System.out.print("(");
				fun(temp);
				System.out.print(")");
		}else {
			 temp=n%2;
			 System.out.print("+");
			 fun(temp);
		}
		
	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		fun(n);
		
	}

}
