package threads;

class Foo{
	public synchronized void doFoo(Bar bar){
		System.out.println("enter do Foo");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Foo want to call endBar");
		bar.endBar();
		System.out.println("exit do Foo");
	}
	public synchronized void endFoo(){
		System.out.println("endFoo");
	}
}
class Bar{
	public synchronized void doBar(Foo foo){
		System.out.println("enter do bar");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Bar want to call endFoo");
		foo.endFoo();
		System.out.println("exit do bar");
	}
	public synchronized void endBar(){
		System.out.println("endBar");
	}
}
public class Deadlock implements Runnable{
	Foo foo = new Foo();
	Bar bar = new Bar();
	@Override
	public void run(){
		foo.doFoo(bar);
	}
	public static void main(String[] arg)
	{	Deadlock dl = new Deadlock();
		Thread t = new Thread(dl);
		t.start();		
		System.out.println(t.getState());
		
		dl.bar.doBar(dl.foo);
	}
}