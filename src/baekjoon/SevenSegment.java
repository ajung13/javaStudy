package baekjoon;

import java.util.Scanner;

public class SevenSegment{
	private static class Segment{
		private int a, b;
		private int result;
		
		public Segment(String input){
			String tmp = "";
			
			//get first number
			int i;
			for(i = 0; i < input.length(); i++){
				if(input.charAt(i) == '+')
					break;
				tmp += input.charAt(i);
			}
			a = code_to_num(tmp);
			
			tmp = "";
			//get second number
			for(i++; i < input.length(); i++){
				if(input.charAt(i) == '=')
					break;
				tmp += input.charAt(i);
			}
			b = code_to_num(tmp);
		}
		
		public void operate(){
			result = a+b;
		}
		
		public void printResult(){
			int digit = (int) Math.pow(10, (int)Math.log10(result));
			for(; digit > 0; digit /= 10){
				printOneDigit(result/digit);
				result = result%digit;
				if(digit == 1)
					break;
			}
			System.out.println();
		}
		private int code_to_num(String input){
			int result = 0;
			for(int i = 0 ; i < input.length(); i += 3){
				result += code_to_num(Integer.parseInt(input.substring(i, i+3)));
				if(i + 3 < input.length())
					result *= 10;
			}
			return result;
		}
		private int code_to_num(int onedigit){
			int digit = 0;
			switch(onedigit){
			case 10:	digit = 1;	break;
			case 11:	digit = 7;	break;
			case 63:	digit = 0;	break;
			case 79:	digit = 3;	break;
			case 93:	digit = 2;	break;
			case 103:	digit = 5;	break;
			case 106:	digit = 4;	break;
			case 107:	digit = 9;	break;
			case 119:	digit = 6;	break;
			case 127:	digit = 8;	break;
			default:	break;
			}
			return digit;
		}
		private void printOneDigit(int digit){
			String print = "";
			switch(digit){
			case 0:	print = "063";	break;
			case 1: print = "010";	break;
			case 2: print = "093";	break;
			case 3: print = "079";	break;
			case 4:	print = "106";	break;
			case 5: print = "103";	break;
			case 6: print = "119";	break;
			case 7: print = "011";	break;
			case 8: print = "127";	break;
			case 9:	print = "107";	break;
			default:	break;
			}
			System.out.print(print);
		}
	}
	public static void main7Segment(String[] args){
		Scanner scn = new Scanner(System.in);
		while(true){
			String input = scn.nextLine();
			if(input.equals("BYE"))
				break;
			Segment solution = new Segment(input);
			solution.operate();
			System.out.print(input);
			solution.printResult();
		}
		scn.close();
	}
}