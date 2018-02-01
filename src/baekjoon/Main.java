package baekjoon;

import java.util.Scanner;
import java.util.ArrayList;

public class Main{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int testcase = Integer.parseInt(scn.nextLine());
		String input = "";
		
		for(int i = 0; i < testcase; i++){
			input = scn.nextLine();
			findPasswd(input);
		}
		
		scn.close();
		return;
	}

	private static void findPasswd(String input) {
		ArrayList<Character> passwd = new ArrayList<>();
		int cursor = 0;
		
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) == '<'){
				cursor--;
				if(cursor < 0)	cursor = 0;
			}
			else if(input.charAt(i) == '>'){
				cursor++;
				if(cursor > passwd.size())	cursor = passwd.size();
			}
			else if(input.charAt(i) == '-'){
				if(cursor > 0){
					cursor--;
					passwd.remove(cursor);
				}
			}
			else{
				passwd.add(cursor, input.charAt(i));
				cursor++;
			}
		}
		
		for(int i = 0; i < passwd.size(); i++)
			System.out.print(passwd.get(i));
		
		passwd = null;
	}
}