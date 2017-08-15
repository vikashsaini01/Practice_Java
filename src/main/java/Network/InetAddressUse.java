package Network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressUse {
	public static void main(String[] str) throws UnknownHostException{
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address);
		address = InetAddress.getByName("www.google.com");
		System.out.println(address);
		InetAddress[] aad  = InetAddress.getAllByName("www.google.com");
		System.out.println(aad);
		System.out.println(Arrays.toString(aad));
		
		aad  = InetAddress.getAllByName("www.nba.com");
		System.out.println(aad);
		System.out.println(Arrays.toString(aad));
	}
}
