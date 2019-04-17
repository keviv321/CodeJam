package coding_challenge;

import java.math.BigInteger;
import java.util.*;
import java.util.Scanner;
import java.util.TreeSet;

public class Cryptopangrams {

	static StringBuilder answer = null;
	
	public static BigInteger gcd(BigInteger a , BigInteger b)
	{
		if (a.equals(0))
			return b;
		else 
			return gcd(b.mod(a),a);
	}

	/*public static BigInteger primeFactors(BigInteger n) 
	{ 

		while ((n.mod(BigInteger.valueOf(2l))).compareTo(BigInteger.valueOf(0l))==0) 
		{ //System.out.println('H');
			return BigInteger.valueOf(2L);
		} 


		for (BigInteger i = BigInteger.valueOf(3L); i.compareTo(n.pow(1/2))>0; i = i.add(BigInteger.valueOf(2L))) 
		{ 

			while ((n.mod(i)).compareTo(BigInteger.valueOf(0l))==0) 
			{ //System.out.println(i+" H ");
				return i; 
			} 
		} 
		return BigInteger.valueOf(0L);

	} */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		int case1 = in.nextInt();
		answer = new StringBuilder();
		BigInteger list1[] = null;
		BigInteger prime[] = null;
		TreeSet<BigInteger> prime1 = null ;
		ArrayList <BigInteger>a = null  ;
		int len = 0 , index = 1 , flag = 0;
		BigInteger p = new BigInteger("1");
		//BigInteger dup;

		for (int i = 0 ; i<case1;i++)
		{
			long v = in.nextLong();
			
			len = in.nextInt();
			in.nextLine();
			list1 = new BigInteger[len];
			prime = new BigInteger[len+1];
			index = 1;
			flag = 0;
			/*list1[0] = new BigInteger(in.next());
			list1[1] = new BigInteger(in.next());
			//p = gcd(list1[0].min(list1[1]),list1[0].max(list1[1]));
			p = list1[0].gcd(list1[1]);
			prime.add(p);
			prime.add(0,list1[0].divide(p));
			p = list1[1].divide(p);
			prime.add(p);
			
			for (int j = 2 ;j<len;j++)
			{
				list1[j]=new BigInteger(in.next());
				p = list1[j].divide(p);
				prime.add(p);
			}
			//prime.add(p);*/
			
			
			for (int j = 0 ;j<len;j++)
			{
				list1[j] = in.nextBigInteger();
			}
			
			p = list1[0].gcd(list1[index]);//System.out.println(prime);
			//prime.add(1,p);
			while(p.compareTo(list1[index])==0)
			{//System.out.println("True"+" "+index);
				index++;
				flag = 1;
			}
			/*if (flag==1)
				index--;*/
			
			//prime.add(index, list1[0].gcd(list1[index]));
			prime[index] = list1[0].gcd(list1[index]);//System.out.println(prime[index]);
			//System.out.println(prime.get(1)+" 1st");
			for (int j = index;j<len;j++)
			{
				prime[j+1]= list1[j].divide(prime[j]) ;
			}
			for (int j = index;j>0;j--)
			{
				//System.out.println("J :"+j);
				prime[j-1] = list1[j-1].divide(prime[j]) ;
			}
				//System.out.println(prime.get(0)+" 0th");
			prime1 = new TreeSet<BigInteger>(Arrays.asList(prime));
			//System.out.println(prime1);
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
