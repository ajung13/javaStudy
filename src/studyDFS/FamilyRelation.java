package studyDFS;

import java.util.Scanner;
import java.util.ArrayList;

public class FamilyRelation{
	private static class Family{
		private int n;
		private int A, B;
		private Person[] families;
		
		public Family(){
			Scanner scn = new Scanner(System.in);
			
			this.n = scn.nextInt();
			families = new Person[n];
			for(int i = 0; i < n; i++)
				families[i] = new Person(i);
			
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
			//find the same ancestor of A and B
			ArrayList<Person> ancestorA = families[A].myParents();
			ArrayList<Person> ancestorB = families[B].myParents();
			
			boolean findFlag = false;
			int i = 0, j = 0;
			for(i = 0 ; i < ancestorA.size(); i++){
				for(j = 0; j < ancestorB.size(); j++){
					if(ancestorA.get(i).name == ancestorB.get(j).name){
						findFlag = true;
						break;
					}
				}
				if(findFlag)	break;
			}
			
			if(findFlag)
				System.out.print(i+j);
			else
				System.out.print("-1");
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
		
		public ArrayList<Person> myParents(){
			ArrayList<Person> parents = new ArrayList<>();
			Person pointer = this;
			while(pointer != null){
				parents.add(pointer);
				pointer = pointer.parent;
			}
			return parents;
		}
	}
	
	public static void mainFamily(String[] args){
		Family solution = new Family();
		solution.run();
	}
}