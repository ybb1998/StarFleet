package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public abstract class SomeShip implements Spaceship{
	protected String name;
	protected int commissionYear;
	protected float maximalSpeed;
	protected Set<? extends CrewMember> crewMembers;
	protected final int FIRE_POWER=10;
	
	public SomeShip(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers) {
		this.name = name;
		this.commissionYear = commissionYear;
		this.maximalSpeed = maximalSpeed;
		this.crewMembers = crewMembers;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCommissionYear() {
		return commissionYear;
	}
	
	public float getMaximalSpeed() {
		return maximalSpeed;
	}
	
	public int getFirePower() {
		return FIRE_POWER;
	}
	
	public Set<? extends CrewMember> getCrewMembers(){
		return crewMembers;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + FIRE_POWER;
		result = prime * result + commissionYear;
		result = prime * result + ((crewMembers == null) ? 0 : crewMembers.hashCode());
		result = prime * result + Float.floatToIntBits(maximalSpeed);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		SomeShip other = (SomeShip) obj;
		if (FIRE_POWER != other.FIRE_POWER)
			return false;
		if (commissionYear != other.commissionYear)
			return false;
		if (crewMembers == null) {
			if (other.crewMembers != null)
				return false;
		} else if (!crewMembers.equals(other.crewMembers))
			return false;
		if (Float.floatToIntBits(maximalSpeed) != Float.floatToIntBits(other.maximalSpeed))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String toRet = "\t" + "Name=" + this.name + "\n";
		toRet += "\t" + "CommissionYear=" + this.commissionYear + "\n";
		toRet += "\t" + "MaximalSpeed=" + this.maximalSpeed + "\n";
		toRet += "\t" + "FirePower=" + this.getFirePower() + "\n";
		toRet += "\t" + "CrewMembers=" + crewMembers.size() + "\n";
		toRet += "\t" + "AnnualMaintenanceCost=" + this.getAnnualMaintenanceCost() + "\n";
		return toRet;
	}
	
	
}
