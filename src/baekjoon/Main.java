package baekjoon;

import java.util.Scanner;

public class Main{
	private static class Sigam{
		private int n, b, c;
		private int[] students;
		private long director;
		public Sigam(){
			Scanner scn = new Scanner(System.in);
			n = scn.nextInt();
			students = new int[n];
			for(int i = 0; i < n; i++)
				students[i] = scn.nextInt();
			b = scn.nextInt();
			c = scn.nextInt();
			scn.close();
			director = 0;
		}
		private void solve(){
			//count main directors
			for(int i = 0; i < n; i++)
				students[i] -= b;
			director += n;
			
			for(int i = 0; i < n; i++){
				if(students[i] <= 0)
					continue;
				if(students[i]%c == 0)
					director += (students[i]/c);
				else
					director += (students[i]/c + 1);
			}
		}
	}
	public static void main(String[] args){
		Sigam solution = new Sigam();
		solution.solve();
		System.out.print(solution.director);
	}
}