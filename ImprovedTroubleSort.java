package coding_challenge;

import java.util.Arrays;
import java.util.Scanner;

public class ImprovedTroubleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int query = in.nextInt();
		
		int array[],array2[],org_array[];
		
		//result array
		String result [] =new String[query];
		for (int i =0 ;i<query;i++)
		{
			int size = in.nextInt();
			byte flag = 0;
			/*
			 * array to store elements at even indices in original array
			 */
			if (size%2==0)
				array = new int[(size/2)];
			else
				array = new int[(size/2)+1];
			
			/*
			 * array to store elements at odd indices in original array
			 */
			array2 = new int[size/2];
			org_array = new int[size];
			int temp [] = new int[size];
			int k = 0 ,l = 0;
			for (int j = 0;j <size;j++)
			{
				org_array[j] = in.nextInt();//Original array

				if (j%2==0)
					array[l++]=org_array[j];//Filling the even array
				else
					array2[k++] = org_array[j];//Filling the odd array
			}

			Arrays.sort(array);
			//sort the even arrays
			
			Arrays.sort(array2);
			//sort the odd arrays
			
			
			k = 0 ; l=1;
			
			/*
			 * Combining the two small sorted arrays into a new one 
			 */
			for (int j :array)
			{
				temp[k] = j;
				k+=2;
			}
			for (int j :array2)
			{
				temp[l] = j;
				l+=2;
			}
			int v ;
			
			//Sorting the original array
			Arrays.sort(org_array);
			
			for (v = 0;v < size;v++)
			{
				if (org_array[v]!=temp[v])
				{
					flag = 1;
					break;
				}
			}
			
			//If error occurs in trouble sorting record the position in the result
			
			if (flag == 1)
				result[i] =  Integer.toString(v);
			else//else inform that the sorting is correct for the current array
				result[i] = "OK";
		}
		//Display the result
		for (int i =0;i<query;i++)
			System.out.println("Case #"+(i+1)+": "+result[i]);
		in.close();
	}

}
