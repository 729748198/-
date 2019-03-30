//问题描述
//　　自从Peter Stuyvesant和Abel Tasman的日子以后，荷兰商人已经周游世界来买卖商品。有一次在Verweggistan的贸易，但是它在很短的时间后就结束了。在读完这个故事之后你就明白了。
//　　在当时Verweggistan是非常受欢迎的，因为世界上只有那个地方的人知道怎样制作一个“prul”（或者“prullen”，荷兰语中的复数形式），并且如今只有很少的人知道什么是一个“prul”。
//　　“prul”是在工场里生产的。当一个“prul”做完的时候，它被包装在一个箱子里，然后放在之前生产的“prul”所装的箱子堆的上面。
//　　价格取决于生产“prul”所需要的时间。如果一切顺利，一个“prul”的价格会是1或者2弗罗林，但是在一个恶劣的日子，价格会很容易地上升到15弗罗林或者更高。“prul”在品质上没有什么差别，所有的“prul”具有相同的价值。
//　　在这些天，“prul”在荷兰的售价为每件10弗罗林。交通运输的费用是可以忽略的，因为“prul”无论如何都会作为额外的东西被装载到要航行的船上。当一个荷兰商人去Verweggistan时，他有一个明确的目的：买“prul”，在荷兰销售，并且最大化他的利润。不幸的是，Verweggistan地区对“prul”的交易方式使得这比某些人预想的更为复杂。
//　　有人认为这很简单，商人会买那些最便宜的“prul”，而那些售价比10弗罗林高的“prul”会一直不能出售。不幸的是，Verweggistan的所有工场按照一种奇怪的顺序销售“prul”。堆顶的箱子里的“prul”会最先销售，然后销售从顶上开始数的第二个箱子里的“prul”，以此类推。所以即使第五个箱子里的“prul”是最便宜的，商人也必须买它上面四个箱子里的“prul”才能得到它。
//　　正如你想象的那样，这使得商人通过购买正确的“prul”的组合来最大化他们的利润是相当难的。没有电脑帮助他们的优化，他们迅速彻底失去了交易“prul”的兴趣。
//　　在这个问题中，给你对几个工场里箱子堆的描述。你必须根据上面所给的限制，计算出一个商人通过购买箱子堆中的“prul”可以获得的最大利润。另外，你必须确定他需要买多少个“prul”才能获得最大利润。
//输入格式
//　　输入文件包含多组测试数据。每个测试数据的第一行是一个整数w(1<=w<=50)，该测试数据中工场的数目。
//　　接下来有w行，每行描述一个放“prul”的箱子堆。每行的第一个整数b(0<=b<=20)，表示堆中的箱子数。接下来是b个正整数，表示堆中“prul”的价格（单位为弗罗林）。输入中箱子的顺序是从顶到底。
//　　输入数据终止于w=0，不再有后续的描述内容。
//输出格式
//　　对于每组测试数据，输出测试点的编号(1,2...)。然后输出两行，第一行输出商人可以获得的最大利润。第二行输出为获得最大利润商人需要买的“prul”数量。如果这个数量不是唯一确定的，按照升序输出可能的值。如果有超过10种可能的取值，只输出10个最小的取值。
//样例输入
//1
//6 12 3 10 7 16 5
//2
//5 7 3 11 9 10
//9 1 2 3 4 10 16 10 4 16
//0
//样例输出
//Workyards 1
//Maximum profit is 8.
//Number of pruls to buy: 4
//Workyards 2
//Maximum profit is 40.
//Number of pruls to buy: 6 7 8 9 10 12 13
//数据规模和约定
//　　1<=w<=50，0<=b<=20，输入文件保证测试点个数不超过10。
package 算法提高;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Trade_on_Verweggistan {

	private static int [][]book=new int[52][22];
	private static Integer sum=0;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generaed method stub
		Scanner in=new Scanner(System.in);
		int n;
		ArrayList<Integer>[]list = null;
		int ji=1;
		while (in.hasNext()) {
			n=in.nextInt();
			if(n==0) {
				return;
			}
			list=new ArrayList[n];
			int j2=0;
			for(int i=0;j2<n;i++) {
				j2++;
				int l=in.nextInt();
				if(l==0) {
					i--;
					continue;
				}
				list[i]=new ArrayList<>(l);
				for(int j=0;j<l;j++) {
					list[i].add(10-in.nextInt());
					book[i][j]=0;
				}
			}
			//存储每个工厂可能是购买数
			ArrayList[]result=new ArrayList[n];
			for(int i=0;i<n;i++) {
				result[i]=new ArrayList<>();
			}
			//存储每个工厂的最大利润
			ArrayList<Integer> maxnum=new ArrayList<>();
			
			for(int i=0;i<list.length;i++) {
				//用一个数组计算出每一个工厂最大利润和可能的购买数
				int[]temp=new int[list[i].size()];
				int max=0;
				for(int j=0;j<list[i].size();j++) {
					if(j==0) {
						temp[0]=list[i].get(0);
					}else
					temp[j]=temp[j-1]+list[i].get(j);
					if(temp[j]>max) {
						max=temp[j];
					}
				}
				//每个工厂的最大利润
				maxnum.add(max);
				boolean empty=true;
				for(int j=0;j<temp.length;j++) {
					//System.out.println("当前的最大和"+maxnum.get(i)+"  temp[j]"+temp[j]);
					if(temp[j]==maxnum.get(i)) {
						empty=false;
						result[i].add(j+1);
					}
				}
				if(empty) {
					result[i].add(0);
				}
			}
			System.out.println("Workyards "+ji);
			ji++;
			//最大利润max
			int max=0;
			//System.out.println("每行最大利润");
			for(int i=0;i<maxnum.size();i++) {
				//System.out.print(maxnum.get(i)+" ");
				max+=maxnum.get(i);
			}
			System.out.println("Maximum profit is "+max+".");
			//可能的组合,每个
			Set<Integer>set=new HashSet<>();
			dfs(result, set,0);
			System.out.print("Number of pruls to buy:");
			Iterator iterator=set.iterator();
			for(int i=0;i<10;i++) {
				if(iterator.hasNext())
				System.out.print(iterator.next()+" ");
				else {
					break;
				}
			}
			System.out.println();
		}
		
		
	}
	public static void dfs(ArrayList[]result,Set<Integer>set,int ji) {
		if(ji>=result.length) {
			set.add(sum);
			return;
		}
		for(int i=0;i<result[ji].size();i++) {
			if(book[ji][i]==0) {
				sum+=(Integer) result[ji].get(i);
				book[ji][i]=1;
				dfs(result, set, ji+1);
				sum-=(Integer)result[ji].get(i);
				book[ji][i]=0;
			}
		}
		
	}

}
