package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper  extends Fighter{

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		int sum = (int) (4000 + (500 * this.crewMembers.size()) + (500*this.maximalSpeed));
		for (Weapon tool: weapons) {
			sum += tool.getAnnualMaintenanceCost();
		}
		return sum;
	}
	
	@Override
	public String getType() {
		return "ColonialViper";
	}
	
	
	
	@Override
	public String toString() {
		return super.toString();
	}

}
