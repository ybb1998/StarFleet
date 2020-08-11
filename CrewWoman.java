package il.ac.tau.cs.sw1.ex9.starfleet;

public class CrewWoman implements CrewMember{
	
	protected String name;
	protected int age;
	protected int yearsInService;
	
	public CrewWoman(int age, int yearsInService, String name){
		this.age = age;
		this.yearsInService = yearsInService;
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getAge() {
		return this.age;
	}

	@Override
	public int getYearsInService() {
		return this.yearsInService;
	}
	
	public String getType() {
		return "CrewWoman";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + yearsInService;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrewWoman other = (CrewWoman) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (yearsInService != other.yearsInService)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String toRet = this.getType();
		toRet += "\t" + "Name=" + this.name + "\n";
		toRet += "\t" + "Age=" + this.age + "\n";
		toRet += "\t" + "YearsInService=" + this.yearsInService;
		return toRet;
	}
	
	

}
