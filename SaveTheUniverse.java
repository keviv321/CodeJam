package coding_challenge;

import java.util.Scanner;

public class SaveTheUniverse {

	public static void main(String []args)
	{
		SaveTheUniverse hack1 = new SaveTheUniverse();
		Scanner in = new Scanner (System.in);
		
		int query = in.nextInt();
		String []result = new String [query];
		
		for (int i = 0 ;i <query;i++)
		{
			int shield = in.nextInt();
			int s = 0,temp =0,count = 0;
			StringBuilder st = new StringBuilder(in.next());
			
			/*
			 * Checks if there is absence of Charge in string and if the shield is less than the 
			 * shoots then the Universe will be doomed and cannot be saved
			 */
			if ((st.indexOf("C")==-1)&&(shield<st.length()))
				result[i] = "IMPOSSIBLE";
			
			/*
			 * If there is absence of shoots then the universe will not be doomed in any possible 
			 * way and therefore no hacks are required
			 */
			else if (st.indexOf("S")==-1)
				result[i] = Integer.toString(0);
			/*
			 * If the shoots are greater than the shield
			 * then the Universe will be doomed and cannot be saved
			 */
			else if (hack1.count(st)>shield)
				result[i]  = "IMPOSSIBLE";

			else
			{
				s = hack1.calculateDestruction(st);

				if (s<=shield)
					result[i] = Integer.toString(0);
				else
				{

					for (int k = st.length()-1;k>0;k--)
					{
						char ch = st.charAt(k);
						if (ch=='S'&&st.charAt(k-1)=='C')
						{

							count++;
							if (k==1)
								st.replace(0, 2, "SC");
							else
								st.replace(k-1, k+1, "SC");
							temp = hack1.calculateDestruction(st);
							if (temp<=shield)
							{
								result[i] = Integer.toString(count);
								break;
							}
							if (k == 1)
								k =st.length();

						}
						else if (temp>shield && k==1)
							k = st.length();

					}	
				}
			}
		}
		//Displaying the result
		for (int i = 0; i< query;i++)
			System.out.println("Case #"+(i+1)+": "+result[i]);
		in.close();
	}

	/*
	 * Count number of shoots
	 */
	private int count(StringBuilder st) {
		// TODO Auto-generated method stub
		int counter = 0;

		for( int i=0; i<st.length(); i++ ) {
			if( st.charAt(i) == 'S' ) {
				counter++;
			} 
		}
		return counter;
	}
	
	/*
	 * Function to calculate the destruction of the string
	 */
	private int calculateDestruction(StringBuilder st) {
		// TODO Auto-generated method stub
		int s = 0,c=1;

		for (int m = 0;m<st.length();m++)
		{
			if (st.charAt(m)=='C')
				c<<=1;
			else if (st.charAt(m)=='S')
				s+=c;
		}
		//System.out.println(st+" "+s);
		return s;
	}

}
