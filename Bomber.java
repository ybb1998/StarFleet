package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends Fighter{

	private int numberOfTechnicians;
	
	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super (name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}

	public int getNumberOfTechnicians() {
		return numberOfTechnicians;
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		double sum = 5000;
		if (numberOfTechnicians != 0) {
			for (Weapon tool: weapons) {
				sum += (double)((10 - (double)numberOfTechnicians )/ 10.0)*tool.getAnnualMaintenanceCost();
			}
		}
		else {
			for (Weapon tool: weapons) {
				sum += tool.getAnnualMaintenanceCost();
			}
		}
		return (int) sum;
	}
	
	@Override
	public String getType() {
		return "Bomber";
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numberOfTechnicians;
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
		Bomber other = (Bomber) obj;
		if (numberOfTechnicians != other.numberOfTechnicians)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String toRet = super.toString();
		toRet += "\t" + "NumberOfTechnicians=" + numberOfTechnicians;
		return toRet;
	}

}
