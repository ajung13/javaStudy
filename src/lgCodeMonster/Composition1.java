package lgCodeMonster;

public class Composition1 {
	int funcNum;		//the number of functions
	Function[] func;	//the functions
	
	int answer;
	int maxConstant;
	
	int[] compFunc;		//the constants of function compositions
	int compIdx;		//for using the array
	int[] permutation;	//for sorting the order of functions
	int[] maxPermutation;
	
	public Composition1(){}
	
	public void init(int n){
		this.funcNum = n;
		this.func = new Function[n];
		this.compFunc = new int[factorial(n)];
		compIdx = 0;
		for(int i = 0; i < n; i++)
			func[i] = new Function();
		answer = 1000000000;
		maxConstant = 0;
	}
	public void delete(){
		this.funcNum = 0;
		this.func = null;
		this.compIdx = 0;
		this.compFunc = null;
	}
	public void setFunc(int n, int a, int b){
		if(n < 0 || n > funcNum)	return;
		func[n].setA(a);
		func[n].setB(b);
	}
	
	public void calculate(){
		//calculate all cases of composition to compFunc[]
		permutation = new int[funcNum];
		maxPermutation = new int[funcNum];
		for(int i=0; i<permutation.length; i++)
			permutation[i] = i;
		permute(0, permutation.length-1);
	}
	
	private void permute(int l, int r){
		if(l == r){
			compFunc[compIdx] = calculateConstant();
			compIdx++;
			int tmp = calculateConstant();
			if(tmp > maxConstant){
				maxConstant = tmp;
				answer = calculateAnswer();
			}
			else if(tmp == maxConstant){
				int tmp2 = calculateAnswer();
				if(answer > tmp2)
					answer = tmp2;
			}
		}
		else{
			for(int i = l; i <= r; i++){
				swap(l, i);
				permute(l+1, r);
				swap(l, i);
			}
		}
		return;
	}
	
	private int calculateAnswer() {
		int sum = 0;
		
		int[] tmp = new int[permutation.length];
		for(int i = 0; i < permutation.length / 2; i++){
			tmp[i] = permutation[permutation.length - i - 1];
			tmp[permutation.length - i - 1] = permutation[i];
		}
		
		for(int i = 0; i < funcNum; i++){
			sum += (i+1) * (tmp[i] + 1);
//			System.out.print(tmp[i] + " ");
		}
//		System.out.println();
		return sum;
	}

	private int calculateConstant() {
		// using permutation[] and func[], calculate the constant of function composition
		// ex. permutation[] = {0, 2, 1} then
		// returns the constant of f1(f3(f2(x)))
		
		Function tmp = new Function();
		tmp.duplicate(func[permutation[funcNum-1]]);
		for(int i = funcNum-2; i >= 0; i--){
			tmp = func[permutation[i]].composition(tmp);
		}
//		System.out.println("calculate: " + tmp.getA() + "x + " + tmp.getB());
		
		return tmp.getB();
	}

	private void swap(int i, int j){
		int tmp = permutation[i];
		permutation[i] = permutation[j];
		permutation[j] = tmp;
	}
	
	public void printFunc(){
		for(int i = 0; i < funcNum; i++)
			System.out.println(func[i].getA() + "x + " + func[i].getB());
	}
	public int getAnswer(){
		return answer;
	}
	
	private int factorial(int n){
		int result = 1;
		for(int i = 1; i <= n; i++)
			result *= i;
		return result;
	}
}
