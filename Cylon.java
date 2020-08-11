package il.ac.tau.cs.sw1.ex9.starfleet;

public class Cylon extends CrewWoman{
	
	protected int modelNumber;
	
	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super (age, yearsInService, name);
		this.modelNumber = modelNumber;
	}
	
	public int getModelNumber() {
		return modelNumber;
	}
	
	@Override
	public String getType() {
		return "Cylon";
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + modelNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cylon other = (Cylon) obj;
		if (modelNumber != other.modelNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String toRet = super.toString();
		toRet += "\t" + "ModelNumber=" + this.modelNumber + "\n";
		return toRet;
	}

}
