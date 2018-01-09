package lgCodeMonster;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainClass {
	static int testCase;

	public static void main(String[] args) throws FileNotFoundException {
		String filePath = "C:\\Users\\cwhth\\workspace\\javaStudy\\src\\lgCodeMonster\\input.txt";
		File file = new File(filePath);
		Scanner scn = new Scanner(file);
		Composition1 solution = new Composition1();
		
		testCase = scn.nextInt();
		for(int i = 0; i < testCase; i++){
			int funcNum = scn.nextInt();
			solution.init(funcNum);
			
			for(int j = 0; j < funcNum; j++){
				int a, b;
				a = scn.nextInt();
				b = scn.nextInt();
				solution.setFunc(j, a, b);
			}
			//solution.printFunc();
			
			solution.calculate();
			
			System.out.println(solution.getAnswer());
//			System.out.println();
			
			solution.delete();
		}
	}

}
