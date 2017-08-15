package z;

import java.util.Date;
import java.util.Random;

public class RandomUse {
	
	
	
	
	public static void main(String[] arg)
	{
		Random random = new Random(10);
		
		System.out.println(random.nextInt());
		System.out.println(random.nextInt());
		System.out.println(random.nextInt());
		System.out.println(random.nextInt());
		
		System.out.println();
		System.out.println();
		Random random1 = new Random(20);
		
		System.out.println(random1.nextInt());
		System.out.println(random1.nextInt());
		System.out.println(random1.nextInt());
		System.out.println(random1.nextInt());
		
		System.out.println();System.out.println();
		Random rnd1 = new Random(42);
        Random rnd2 = new Random(42);

        System.out.println(rnd1.nextInt(100)+" - "+rnd2.nextInt(100));
        System.out.println(rnd1.nextInt()+" - "+rnd2.nextInt());
        System.out.println(rnd1.nextDouble()+" - "+rnd2.nextDouble());
        System.out.println(rnd1.nextLong()+" - "+rnd2.nextLong());
        System.out.println();System.out.println();

        Random rnd3 = new Random(new Date().getTime());
    	System.out.println(rnd3.nextInt());
    	System.out.println(rnd3.nextInt());
    	System.out.println(rnd3.nextInt());
	}
	
}
