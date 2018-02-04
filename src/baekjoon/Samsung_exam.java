package baekjoon;

import java.util.Scanner;

public class Samsung_exam{
	public static void main(String[] args){
		int n, b, c;
		int[] students;
		long director = 0;
		
		Scanner scn = new Scanner(System.in);
		n = scn.nextInt();
		students = new int[n];
		for(int i = 0; i < n; i++)
			students[i] = scn.nextInt();
		b = scn.nextInt();
		c = scn.nextInt();
		scn.close();
		
		//count main directors
		for(int i = 0; i < n; i++)
			students[i] -= b;
		director += n;
		
		//count sub directors
		for(int i = 0; i < n; i++){
			if(students[i] <= 0)
				continue;
			if(students[i]%c == 0)
				director += (students[i]/c);
			else
				director += (students[i]/c + 1);
		}
		
		System.out.print(director);
	}
}