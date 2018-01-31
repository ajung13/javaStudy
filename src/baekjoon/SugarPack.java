package baekjoon;

import java.util.Scanner;

public class SugarPack{
	public static void mainSugar(String[] args){
		int sugar, bongji = 0;
		
		Scanner scn = new Scanner(System.in);
		sugar = scn.nextInt();
		scn.close();
		
		bongji = sugar / 5;
		sugar = sugar % 5;
		for(int i = 0; i < 5; i++){
			if(sugar % 3 == 0){
				bongji += sugar / 3;
				sugar = 0;
				break;
			}
			else if(bongji <= 0)
				break;
			bongji--;
			sugar += 5;
//			System.out.println("bongji: " + bongji + ", sugar: " + sugar);
		}
		
		if(sugar == 0)
			System.out.print(bongji);
		else
			System.out.print("-1");
	}
}