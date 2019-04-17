package coding_challenge;

import java.math.BigInteger;
import java.util.Scanner;

public class ForegoneSolution {

	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int case1 = in.nextInt();
		
		StringBuilder  n ;
		String p ;
		BigInteger x ;
		for (int i = 0 ; i<case1;i++)
		{
			n = new StringBuilder();
			n = n.append(in.next());
			p = n.toString();
			
			String value = n.toString().replace("4", "2");
			x = new BigInteger(value);
			BigInteger remaining = (new BigInteger(p)).subtract(x);
			
			answer.append("Case #"+(i+1)+": ");
			answer.append(remaining.toString()+" "+x.toString()+"\n");
		}
		in.close();
		System.out.println(answer);
	}

}
