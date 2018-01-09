package javaStudy;

import java.util.Scanner;

public class Yahoo2Solution {
	String input;
	int maxCnt;
	
	public Yahoo2Solution(){
		Scanner scn = new Scanner(System.in);
		input = scn.nextLine();
		scn.close();
		maxCnt = -1;
	}
	public Yahoo2Solution(String input){
		this.input = input;
		maxCnt = -1;
	}
	
	public void findSubstring(){
		boolean flag = false;
		int cnt = 0;
		for(int i = 0; i < input.length(); i++){
			if(Character.isDigit(input.charAt(i))){
				updateMax(cnt, flag);
				flag = false;
				cnt = 0;
				continue;
			}
			if(Character.isUpperCase(input.charAt(i)))
				flag = true;
			cnt++;
		}
		updateMax(cnt, flag);
		return;
	}
	
	private void updateMax(int cnt, boolean flag){
		if(flag && maxCnt < cnt)
			maxCnt = cnt;
	}
	
	public int maxCnt(){
		return this.maxCnt;
	}
}
