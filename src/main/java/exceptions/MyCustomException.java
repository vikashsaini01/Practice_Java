package exceptions;

public class MyCustomException extends Exception{
	public MyCustomException(String str) {
		super(str);
	}
	public static Throwable getExceptionInstance(){
		MyCustomException customException = new MyCustomException("My Custome Exception Instance");
		
		
		customException.initCause(new Exception());
		customException.initCause(new Exception());
		customException.initCause(new Exception());
		return customException;
	}
	
	public static void main(String[] aaa){
		System.out.println(MyCustomException.getExceptionInstance());
	}
}
