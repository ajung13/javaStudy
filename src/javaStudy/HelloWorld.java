package javaStudy;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
/*		YAHOO Q1 SOLUTION
**		Yahoo1Solution sol = new Yahoo1Solution();
**		Yahoo1Solution sol = new Yahoo1Solution(scanInt());
**		sol.printNums();
*/
		
/*		YAHOO Q2 SOLUTION
 * 		Yahoo2Solution sol = new Yahoo2Solution();
 * 		sol.findSubstring();
 *		System.out.println(sol.maxCnt());
 *		return;
 */
		
/*		YAHOO Q3 SOLUTION
 * 		Yahoo3Solution sol = new Yahoo3Solution();
 * 		sol.findSolution();
 *		System.out.println("answer: " + sol.maxDist());
 */
		
/*		Yahoo4Solution sol = new Yahoo4Solution();
		sol.findSolution();
		return;
*/
		
/*		Unknown1 sol = new Unknown1();
		sol.findSolution();
		return;
*/
		
		int a = 1;
		int b = 2;
		Integer insA = new Integer(1);
		Integer insB = new Integer(2);
		
		System.out.println("(before) int a: " + a + ", b: " + b);
		System.out.println("(before) Integer a: " + a + ", b: " + b);
		System.out.println();
		
		swap(a, b);
		swap(insA, insB);
		System.out.println();
		
		System.out.println("(after) int a: " + a + ", b: " + b);
		System.out.println("(after) Integer a: " + a + ", b: " + b);
	}
	
	private static void swap(int a, int b){
		int tmp = a;
		a = b;
		b = tmp;
		System.out.println("(function) int a: " + a + ", b: " + b);
	}
	private static void swap(Integer a, Integer b){
		Integer tmp = new Integer(a);
		a = b;
		b = tmp;
		System.out.println("(function) Integer a: " + a + ", b: " + b);
	}
	
	private static int scanInt(){
		Scanner scn = new Scanner(System.in);
		int result = scn.nextInt();
		scn.close();
		return result;
	}

}
