package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends SomeShip{
	
	protected List<Weapon> weapons;
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super (name, commissionYear, maximalSpeed, crewMembers);
		this.weapons = weapons;
		
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}
	
	public int getFirePower() {
		int power = super.getFirePower();
		for (Weapon tool: weapons) {
			power += tool.getFirePower();
		}
		return power;
	}


	@Override
	public int getAnnualMaintenanceCost() {
		int sum = (int) (2500 + 1000*maximalSpeed);
		for (Weapon tool: weapons) {
			sum += tool.getAnnualMaintenanceCost();
		}
		return sum;
	}
	
	public String getType() {
		return "Fighter";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((weapons == null) ? 0 : weapons.hashCode());
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
		Fighter other = (Fighter) obj;
		if (weapons == null) {
			if (other.weapons != null)
				return false;
		} else if (!weapons.equals(other.weapons))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String toRet = this.getType() + "\n";
		toRet += super.toString();
		toRet += "\t" + "WeaponArray=" + this.weapons.toString() + "\n";
		return toRet;
	}
	
}
