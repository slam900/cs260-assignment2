package edu.uwec.cs.olsonsd_hessledd3607.migration;

public class County {
	private int countyNumeric;
	private int stateNumeric;
	
	public County(int countyNumeric, int stateNumeric) {
		this.countyNumeric = countyNumeric;
		this.stateNumeric = stateNumeric;
	}
	
	public boolean equals(Object o) {
		County c = (County)o;
		return c.countyNumeric == countyNumeric
			&& c.stateNumeric == stateNumeric;
	}
}
