package studyDFS;

import java.util.Scanner;
import java.util.ArrayList;

public class DupNumbers{
	public static void main(String[] args){
		ArrayList<Integer> d = new ArrayList<>();
		int p = 0;
		
		Scanner scn = new Scanner(System.in);
		d.add(scn.nextInt());
		p = scn.nextInt();
		scn.close();
		
		int prev = d.get(0), next;
		while(true){
			//get (idx+1)th number
			next = 0;
			while(prev != 0){
				next += Math.pow(prev%10, p);
				prev = prev/10;
			}
			
			//check if 'next' is dup
			if(d.indexOf(next) >= 0){
				System.out.print(d.indexOf(next));
				break;
			}
			
			//add next into d
			d.add(next);
			prev = next;
		}
	}
}