package baekjoon;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class MemberSort{
	private static class Person{
		public int age;
		public String name;
		public int signup;
		public Person(int age, String name, int signup){
			this.age = age;
			this.name = name;
			this.signup = signup;
		}
	}
	private static LinkedList<Person> list;
	public static void mainSort(String[] args){
		Scanner scn = new Scanner(System.in);
		list = new LinkedList<Person>();
		
		int n = scn.nextInt();
		for(int i = 0 ; i < n; i++)
			list.add(new Person(scn.nextInt(), scn.nextLine(), i));
		scn.close();
		
		Collections.sort(list, new myCompare());
		for(Person i : list)
			System.out.println(i.age + i.name);
	}
	
	private static class myCompare implements Comparator<Person>{
		@Override
		public int compare(Person e1, Person e2){
			if(e1.age < e2.age)
				return -1;
			else if(e1.age == e2.age && e1.signup < e2.signup)
				return -1;
			else
				return 1;
		}
	}
}