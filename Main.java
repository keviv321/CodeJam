package coding_challenge;

import java.util.Scanner;

public class Main {
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		int query = in.nextInt();
		int row,col;
		AlphabetCake cake[] = new AlphabetCake[query];
		
		for (int i = 0;i<query;i++)
		{
			row = in.nextInt();
			col = in.nextInt();
			char input[][] = new char[row][col];
			for (int k = 0;k<row;k++)
			{
				//for (int j = 0;j<col;j++)
					input[k]=in.next().toCharArray();
			}
			cake[i] = new AlphabetCake(row,col,input);
		}
		
		for (int i = 0;i<query;i++)
		{
			System.out.println("Case #"+(i+1)+":");
			char result[][] = cake[i].solution();
			for (char j[]:result)
			{
				for (char k:j)
					System.out.print(k);
				System.out.println();
			}
		}
		
		in.close();
	}

}
