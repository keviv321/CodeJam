package coding_challenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Num {
	public static void main(String []args)
	{
		Scanner in = new Scanner (System.in);
		int query = in.nextInt();

		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(5);
		int element;
		for (int i = 2;i<301;i++)
		{
			element = ((((arr.get(i-1)*6)-(arr.get(i-2)*4))+10001)%1000);
			arr.add(i, element);
		}
		
		for (int i =0;i<query;i++)
		{
			System.out.print("Case #"+(i+1)+": ");
			System.out.printf("%03d",arr.get(((in.nextInt())%100)+100));//formatting the output
			System.out.println();
		}
		in.close();
		arr.clear();
	}

}
