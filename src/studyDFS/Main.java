package studyDFS;

import java.util.Scanner;

public class Main{
	private static class Relation{
		//private member variables
		private int n;
		private boolean[] friend;
		
		//public methods and constructor
		public Relation(int n){
			this.n = n;
			friend = new boolean[(n*(n-1))/2];
		}
		public void newRelationship(int a, int b){
			a--;	b--;
			friend[idx(a, b)] = true;
		}
		public int run(){
			int minBacon = Integer.MAX_VALUE;
			int minPerson = -1;
			
			for(int i = 0; i < n; i++){
				int tmp = KevinBacon(i);
				if(tmp < minBacon){
					minBacon = tmp;
					minPerson = i;
				}
			}
			
			return minPerson;
		}
		
		//private methods
		private int idx(int i, int j){
			int idx;
			if(i < j)
				idx = n*i - i*(i+1)/2 + j - i - 1;
			else
				idx = n*j - j*(j+1)/2 + i - j - 1;
			return idx;
		}
		private int KevinBacon(int person){
			return 0;
		}
	}
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		
		Relation solution = new Relation(scn.nextInt());
		int cnt = scn.nextInt();
		for(; cnt > 0; cnt--)
			solution.newRelationship(scn.nextInt(), scn.nextInt());
		
		scn.close();
		
		System.out.print(solution.run());
	}
}