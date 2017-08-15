package z;

class A{
	int x = 1;
	public void doX(){
		System.out.println("A "+ x);
	}
}
class B extends A{
	int x= 2;
	
	public void doX(){
		System.out.println("B "+ x);
	}
}
class C{
	int x = 3;
}
public class StringAndObject {
	
	void met(A a){
		System.out.println("A");
		if(a!=null)a.doX();
	}
	void met(B b){
		System.out.println("B");
		if(b!=null)b.doX();
	}
	void met(C c){
		System.out.println("C");
	}
	void display(Object obj){
		System.out.println("Object");
	}
	void display(String obj){
		System.out.println("String");
	}
	public static void main(String[] str){
		StringAndObject andObject = new StringAndObject();
		andObject.display(null);
		C c = null;
		andObject.met(c);
		B b = null;
		andObject.met(b);
		A a= null;
		andObject.met(a);
		
		A ab= new B();
		andObject.met(ab);
	}
}
