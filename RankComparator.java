package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class RankComparator implements Comparator<Map.Entry<OfficerRank, Integer>>{

	@Override
	public int compare(Entry<OfficerRank, Integer> o1, Entry<OfficerRank, Integer> o2) {
		if (o1.getValue() > o2.getValue()) {
			return 1;
		}
		else if (o1.getValue() < o2.getValue()) {
			return -1;
		}
		else {
			return o1.getKey().compareTo(o2.getKey());
		}
	}

}
