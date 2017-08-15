package lambda;

interface LambdaVarI{
	int getValue(int n);
}
public class LambdaVar {
	int x;
	
	LambdaVarI varI;
	
	public void display(){
		int d = 4;
		
		varI = (n) -> {
			int temp = n+d+x;			
//			d++ ;		
			x++;
			return temp;
		};
		x++;
//		d++ ;
		System.out.println(x);
		System.out.println(varI.getValue(10));
		System.out.println(x);
	}
	
	public static void main(String[] arg){
		LambdaVar lambdaVar = new LambdaVar();
		lambdaVar.display();
	}
}
