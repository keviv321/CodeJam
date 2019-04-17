package coding_challenge;

import java.math.BigInteger;
import java.util.*;
public class Cryptopangrams {

	static StringBuilder answer = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		int case1 = in.nextInt();
		answer = new StringBuilder();
		BigInteger list1[] = null;
		BigInteger prime[] = null;
		TreeSet<BigInteger> prime1 = null ;
		ArrayList <BigInteger>a = null  ;
		int len = 0 , index = 1 ;
		BigInteger p = new BigInteger("1");

		for (int i = 0 ; i<case1;i++)
		{
			@SuppressWarnings("unused")
			long v = in.nextLong();
			len = in.nextInt();
			in.nextLine();
			list1 = new BigInteger[len];
			prime = new BigInteger[len+1];
			index = 1;
			
			for (int j = 0 ;j<len;j++)
			{
				list1[j] = in.nextBigInteger();
			}

			p = list1[0].gcd(list1[index]);
			while(p.compareTo(list1[index])==0)
			{
				index++;
			}
			
			prime[index] = list1[0].gcd(list1[index]);
			for (int j = index;j<len;j++)
			{
				prime[j+1]= list1[j].divide(prime[j]) ;
			}
			for (int j = index;j>0;j--)
			{
				prime[j-1] = list1[j-1].divide(prime[j]) ;
			}
			prime1 = new TreeSet<BigInteger>(Arrays.asList(prime));
			a = new ArrayList<BigInteger>(prime1);

			HashMap<BigInteger , Character> diction = new HashMap<BigInteger , Character>();
			for (char ch = 'A';ch<='Z';ch++)
			{
				diction.put(a.get(ch-65), ch);
			}

			StringBuilder st = new StringBuilder();
			Arrays.stream(prime).forEach((BigInteger ind)->st.append(diction.get(ind)));

			answer.append("Case #"+(i+1)+": ");
			answer.append(st+"\n");
		}


		System.out.println(answer);
		in.close();

	}

}
