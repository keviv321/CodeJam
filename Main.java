package coding_challenge;

import java.util.Scanner;

public class Main {
	
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		int query = in.nextInt();
		
		int row , col ;
		AlphabetCake cake[] = new AlphabetCake[query];
		
		for (int i = 0;i<query;i++)
		{
			row = in.nextInt();
			col = in.nextInt();
			char input[][] = new char[row][col];
			for (int k = 0;k<row;k++)
			{
				input[k]=in.next().toCharArray();
			}
			cake[i] = new AlphabetCake(row,col,input);
		}
		
		for (int i = 0;i<query;i++)
		{
			answer.append("Case #"+(i+1)+":"+"\n");
			char result[][] = cake[i].solution();
			for (char j[]:result)
			{
				for (char k:j)
					answer.append(k);
				answer.append("\n");
			}
		}
		
		System.out.println(answer);
		in.close();
	}

}
