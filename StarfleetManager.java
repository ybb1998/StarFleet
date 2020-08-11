package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<Spaceship> fleetLst = new ArrayList<>(fleet);
		Collections.sort(fleetLst, new FleetComparator());
		List<String> ordered = new ArrayList<String>();
		for (Spaceship ship: fleetLst) {
			ordered.add(ship.toString());
		}
		return ordered;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> toRet = new HashMap<String, Integer>();
		for (Spaceship ship: fleet) {
			if (toRet.containsKey(ship.getClass().getSimpleName())) {
				toRet.put(ship.getClass().getSimpleName(), toRet.get(ship.getClass().getSimpleName())+1);
			}
			else {
				toRet.put(ship.getClass().getSimpleName(),1);
			}
		}
		return toRet;

	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int sum = 0;
		for (Spaceship ship: fleet) {
			sum += ship.getAnnualMaintenanceCost();
		}
		return sum;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> toRet = new HashSet<String>();
		for(Spaceship ship: fleet) {
			if (ship instanceof Fighter) {
				Fighter fightShip = (Fighter) ship;
				for (Weapon weapon: fightShip.getWeapons()) {
					toRet.add(weapon.getName());
				}
			}
		}
		return toRet;

	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int sum = 0;
		for (Spaceship ship: fleet) {
			sum += ship.getCrewMembers().size();
		}
		return sum;

	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int sumAge = 0;
		int numOfCrew = 0;
		for (Spaceship ship: fleet) {
			for (CrewMember woman: ship.getCrewMembers()) {
				sumAge += woman.getAge();
				numOfCrew++;
			}
		}
		return ((float)sumAge)/(float)numOfCrew;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map <Officer, Spaceship> toRet = new HashMap<Officer, Spaceship>();
		for (Spaceship ship: fleet) {
			Officer temp = null;
			for (CrewMember woman: ship.getCrewMembers()) {
				if (woman instanceof Officer && temp == null) {
					temp = (Officer) woman;
				}
				else if (woman instanceof Officer && temp.getRank().compareTo(((Officer) woman).getRank()) < 0) {
					temp = (Officer) woman;
				}
			}
			if (temp != null) {
				toRet.put(temp, ship);
			}
		}
		return toRet;

	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> rankMap = new HashMap<>();
		for (Spaceship ship: fleet) {
			for (CrewMember woman: ship.getCrewMembers()) {
				if (woman instanceof Officer) {
					OfficerRank rank = ((Officer)woman).getRank();
					if (rankMap.containsKey(rank)) {
						rankMap.put(rank, rankMap.get(rank) + 1);
					}
					else {
						rankMap.put(rank, 1);
					}
				}
			}
		}
		List<Map.Entry<OfficerRank, Integer>> toRet = new ArrayList<Map.Entry<OfficerRank,Integer>>();
		for (Map.Entry<OfficerRank, Integer> entry: rankMap.entrySet()) {
			toRet.add(entry);
		}
		Collections.sort(toRet, new RankComparator());
		return toRet;
	}

}
