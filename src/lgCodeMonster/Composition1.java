package lgCodeMonster;

public class Composition1 {
	int funcNum;
	int func[][];
	public Composition1(){}
	
	public void init(int n){
		this.funcNum = n;
		this.func = new int[n][2];
	}
	public void delete(){
		this.funcNum = 0;
		this.func = null;
	}
	public void setFunc(int n, int a, int b){
		if(n < 0 || n > funcNum)	return;
		func[n][0] = a;
		func[n][1] = b;
	}
	public void printFunc(){
		for(int i = 0; i < funcNum; i++)
			System.out.println(func[i][0] + "x + " + func[i][1]);
	}
}
