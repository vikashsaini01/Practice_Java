package InterfacesAndClasses;

public class InterfaceDefaultMethodImpl implements InterfaceDefaultMethod{
	
	@Override
	public void mustImplement(){
	
		System.out.println("mustImplement");
	}	
	public static void main(String[] arg)
	{
		System.out.println(new InterfaceDefaultMethodImpl().display());
		System.out.println(InterfaceDefaultMethod.getInterfaceName());
	}
	

	
}