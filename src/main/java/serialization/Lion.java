package serialization;

import java.io.Serializable;

public class Lion implements Serializable{
	
	@Override
	public String toString() {
		return "Lion [id=" + id + ", owner=" + owner + ", lionName=" + lionName + "]";
	}

	private static final long serialVersionUID = 1L;
	
	int id;
	String owner;
	String lionName;
	
	private Lion(){}// Singleton
	
	public static final Lion lionInstance = new Lion();
	
	
	public static Lion getLionInstance(){
		return lionInstance;
	}
	
	
	
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getLionName() {
		return lionName;
	}
	public void setLionName(String lionName) {
		this.lionName = lionName;
	}
		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lionName == null) ? 0 : lionName.hashCode());
		result = prime * result + id;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}
		
	protected Object readResolve(){
		return getLionInstance();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lion other = (Lion) obj;
		if (lionName == null) {
			if (other.lionName != null)
				return false;
		} else if (!lionName.equals(other.lionName))
			return false;
		if (id != other.id)
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}
	
	
}