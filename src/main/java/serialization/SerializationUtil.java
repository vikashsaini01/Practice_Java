package serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationUtil {

	private static void lionSerialized() {
		Lion lion = Lion.getLionInstance();
		lion.setLionName("Pandey");
		lion.setId(1);
		lion.setOwner("Vicka");

		try {
			FileOutputStream fos = new FileOutputStream("H:\\lion.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(lion);
			fos.close();
			oos.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Lion lion2 = null;

		FileInputStream fis;
		try {
			fis = new FileInputStream("H://lion.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			lion2 = (Lion) ois.readObject();
			fis.close();
			ois.close();

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		System.out.println("lion " + lion);
		System.out.println("lion2 " + lion2);
		System.out.println("lion " + lion.toString());
		System.out.println("lion2 " + lion2.toString());
		System.out.println("lion == lion2 " + (lion == lion2));
		System.out.println("lion.equals(lion2) " + lion.equals(lion2));
		System.out.println("lion.hashCode " + lion.hashCode());
		System.out.println("lion2.hashCode " + lion2.hashCode());

		lion.setLionName("Pandey 1");
		lion2.setOwner("Homeless");

		System.out.println("lion " + lion);
		System.out.println("lion2 " + lion2);
		System.out.println("lion " + lion.toString());
		System.out.println("lion2 " + lion2.toString());
		System.out.println("lion == lion2 " + (lion == lion2));
		System.out.println("lion.equals(lion2) " + lion.equals(lion2));
		System.out.println("lion.hashCode " + lion.hashCode());
		System.out.println("lion2.hashCode " + lion2.hashCode());
	}

	private static void cowSerialize(){
		
		Cow cow = new Cow();
		try {
			FileOutputStream fos = new FileOutputStream("H:\\cow.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cow);
			fos.close();
			oos.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Cow cow2 = null;

		FileInputStream fis;
		try {
			fis = new FileInputStream("H://cow.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			cow2 = (Cow) ois.readObject();
			fis.close();
			ois.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Cow "+cow);
		System.out.println("Cow2 "+cow2);

	}
	
	public static void main(String[] s) {
		// dogSerialized();
		//lionSerialized();
		cowSerialize();
	}

	private static void dogSerialized() {
		Dog dog = new Dog();
		dog.setDogName("Pandey");
		dog.setId(1);
		dog.setOwner("Vicka");

		try {
			FileOutputStream fos = new FileOutputStream("H:\\dog.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dog);
			fos.close();
			oos.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		Dog dog2 = null;

		FileInputStream fis;
		try {
			fis = new FileInputStream("H://dog.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			dog2 = (Dog) ois.readObject();
			fis.close();
			ois.close();

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		System.out.println("dog " + dog);
		System.out.println("dog2 " + dog2);
		System.out.println("Dog " + dog.toString());
		System.out.println("Dog2 " + dog2.toString());
		System.out.println("dog == dog2 " + (dog == dog2));
		System.out.println("dog.equals(dog2) " + dog.equals(dog2));
		System.out.println("dog.hashCode " + dog.hashCode());
		System.out.println("dog2.hashCode " + dog2.hashCode());

		dog.setDogName("Pandey 1");
		dog2.setOwner("Homeless");

		System.out.println("dog " + dog);
		System.out.println("dog2 " + dog2);
		System.out.println("Dog " + dog.toString());
		System.out.println("Dog2 " + dog2.toString());
		System.out.println("dog == dog2 " + (dog == dog2));
		System.out.println("dog.equals(dog2) " + dog.equals(dog2));
		System.out.println("dog.hashCode " + dog.hashCode());
		System.out.println("dog2.hashCode " + dog2.hashCode());
	}
}
