package baekjoon;

import java.util.Scanner;

public class Hansoo {
	public static void mainHansoo(String[] args) {
		int input, output;
		
		Scanner scn = new Scanner(System.in);
		input = scn.nextInt();
		scn.close();
		if(input <= 0 || input > 1000){
			System.out.println("input error");
			return;
		}
		
		output = solution(input);
		System.out.println(output);
		
		return;
	}

	private static int solution(int input) {
		int output = 0;
		if(input < 100)
			output = input;
		else
			output = 99;
		
		for(int i = 100; i <= input; i++){
			int a, b, c, tmp;
			tmp = i;
			a = tmp/100;
			tmp = tmp%100;
			b = tmp/10;
			c = tmp%10;
			if(2 * b == a + c){
				output++;
			}
		}

		return output;
	}
}
