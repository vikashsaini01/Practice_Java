package InterfacesAndClasses;
public interface InterfaceDefaultMethod {
	void mustImplement();
	
	default String display(){
		return this.toString();
	}
	
	static String getInterfaceName(){
		return "InterfaceDefaultMethod";
	}
}
