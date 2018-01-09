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
		
		Unknown1 sol = new Unknown1();
		sol.findSolution();
		return;
		
	}
	
	private static int scanInt(){
		Scanner scn = new Scanner(System.in);
		int result = scn.nextInt();
		scn.close();
		return result;
	}

}
