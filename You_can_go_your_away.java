package coding_challenge;

import java.util.Scanner;

public class You_can_go_your_away {
	
	static StringBuilder answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		int test_case = in.nextInt();
		int len = 0;
		String input;
		answer = new StringBuilder();
		for (int i = 0;i<test_case;i++)
		{
			len = in.nextInt();
			input = in.next();
			input = (((input.replace('S','@')).replace('E', 'S')).replace('@', 'E'));
			//System.out.println(input);
			answer.append("Case #"+(i+1)+": ");
			answer.append(input+"\n");
		}
		System.out.println(answer);
		in.close();

	}

}
