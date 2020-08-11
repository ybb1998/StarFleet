package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter{
	
	private static int inFleet = 0;
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super (name, commissionYear, maximalSpeed, crewMembers, weapons);
		inFleet++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name, commissionYear, maximalSpeed, crewMembers, Arrays.asList(new Weapon ("Laser Cannons",10,100)));
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		int sum = super.getAnnualMaintenanceCost();
		sum += inFleet*50;
		return sum;
	}
	
	@Override
	public String getType() {
		return "StealthCruiser";
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	
}
