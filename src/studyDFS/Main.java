package studyDFS;

import java.util.Scanner;
import java.util.ArrayList;

public class Main{
	private static class Family{
		private int n;
		private int A, B, relationCnt;
		private Person[] families;
		
		public Family(){
			Scanner scn = new Scanner(System.in);
			
			this.n = scn.nextInt();
			families = new Person[n];
			for(int i = 0; i < n; i++)
				families[i].name = i;
			
			this.A = scn.nextInt();
			this.B = scn.nextInt();
			A--;	B--;
			
			int relation = scn.nextInt();
			for(; relation > 0; relation--){
				int parent = scn.nextInt();
				int baby = scn.nextInt();
				parent--;	baby--;
				families[baby].setParent(families[parent]);
				families[parent].setBaby(families[baby]);
			}
			
			scn.close();
		}
		public void run(){
			boolean findFlag = false;
			
			//find my GRAND parent
			
			
			findFlag = findParents();
			if(findFlag){
				System.out.print(relationCnt);
				return;
			}
			
			findFlag = findBabies();
			if(findFlag)
				System.out.print(relationCnt);
			else
				System.out.print("-1");
		}
		
		private void findParents(){
			
		}
		private void findBabies(){
			
		}
	}
	private static class Person{
		private int name;
		private Person parent;
		private ArrayList<Person> baby;
		
		public Person(int name){
			this.name = name;
		}
		public void setParent(Person p){
			this.parent = p;
		}
		public void setBaby(Person p){
			if(this.baby == null)
				baby = new ArrayList<>();
			baby.add(p);
		}
	}
	
	public static void main(String[] args){
		Family solution = new Family();
		solution.run();
	}
}