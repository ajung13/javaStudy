package studyDFS;

import java.util.Scanner;

public class Main{
	private static class Relation{
		//private member variables
		private int n;
		private int[] friend;
		
		//public methods and constructor
		public Relation(int n){
			this.n = n;
			friend = new int[(n*(n-1))/2];
			for(int i = 0; i < friend.length; i++)
				friend[i] = Integer.MAX_VALUE;
		}
		public void newRelationship(int a, int b){
			a--;	b--;
			friend[idx(a, b)] = 1;
		}
		public int run(){
			int minBacon = Integer.MAX_VALUE;
			int minPerson = -1;
			
			setFriends();
			
			for(int i = 0; i < n; i++){
				int tmp = KevinBacon(i);
				if(tmp < minBacon){
					minBacon = tmp;
					minPerson = i;
				}
			}
			
			return minPerson + 1;
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
			int sum = 0;
			for(int i = 0; i < n; i++){
				if(person == i)
					continue;
				sum += friend[idx(person, i)];
			}
			return sum;
		}
		private void setFriends(){
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