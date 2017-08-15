package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

class Animal {
	String typeOfAnimal;
	String geoLocation;

	public String getTypeOfAnimal() {
		return typeOfAnimal;
	}

	public void setTypeOfAnimal(String typeOfAnimal) {
		this.typeOfAnimal = typeOfAnimal;
	}

	public String getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

}

public class Cow extends Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	int id;
	String name;
	boolean givesMilk;
	int children;
	Date dob;

	public Cow() {
		this.id = 1;
		this.name = "gori";
		this.givesMilk = true;
		this.children = 3;
		this.dob = (new Date());
		this.typeOfAnimal = "COW";
		this.geoLocation = "India";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGivesMilk() {
		return givesMilk;
	}

	public void setGivesMilk(boolean givesMilk) {
		this.givesMilk = givesMilk;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Cow [id=" + id + ", name=" + name + ", givesMilk=" + givesMilk + ", children=" + children + ", dob=" + dob + ", typeOfAnimal=" + typeOfAnimal
				+ ", geoLocation=" + geoLocation + "]";
	}

	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();
		setTypeOfAnimal((String)ois.readObject());
		setGeoLocation((String)ois.readObject());
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		oos.writeObject(getTypeOfAnimal());
		oos.writeObject(getGeoLocation());

	}
}
