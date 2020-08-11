package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends SomeShip{

	private int cargoCapacity, passengerCapacity;
	
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super (name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
	}

	
	
	public int getCargoCapacity() {
		return cargoCapacity;
	}



	public int getPassengerCapacity() {
		return passengerCapacity;
	}



	@Override
	public int getAnnualMaintenanceCost() {
		return 3000 + 5*cargoCapacity + 3*passengerCapacity;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + cargoCapacity;
		result = prime * result + passengerCapacity;
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
		TransportShip other = (TransportShip) obj;
		if (cargoCapacity != other.cargoCapacity)
			return false;
		if (passengerCapacity != other.passengerCapacity)
			return false;
		return true;
	}



	@Override
	public String toString() {
		String toRet = "TransportShip" + "\n" + super.toString();
		toRet += "\t" + "CargoCapacity=" + cargoCapacity + "\n";
		toRet += "\t" + "PassengerCapacity=" + passengerCapacity + "\n";
		return toRet;
	}

}
