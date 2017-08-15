package generics;

class TwoD<I extends Number, J >
{
	I i;
	J j;
	public TwoD(I i, J j){
		this.i = i;
		this.j = j;
	}
	
	public double  getISquare(){
		Integer x = 0;
		x = x*x ;
		return i.doubleValue()*i.doubleValue();
	}
	
	public boolean isSame(TwoD<? extends Number, ?> obj){
		
		return false;
	}
}



public class Coords {

}
