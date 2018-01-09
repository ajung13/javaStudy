package lgCodeMonster;

public class Function {
	private int a;
	private int b;
	
	public Function(){}
	public Function(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	public void setA(int a){
		this.a = a;
	}
	public void setB(int b){
		this.b = b;
	}
	public int getA(){
		return a;
	}
	public int getB(){
		return b;
	}
	
	public Function composition(Function tmp){
		Function result = new Function();
		result.setA(this.a * tmp.a);
		result.setB(this.a * tmp.b + this.b);
		return result;
	}
	
	public void duplicate(Function tmp){
		this.a = tmp.getA();
		this.b = tmp.getB();
	}

}
