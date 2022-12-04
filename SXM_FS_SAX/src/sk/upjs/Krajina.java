package sk.upjs;

import java.util.ArrayList;
import java.util.List;

/**
 * krajina z ponuky dovoleniek konkretneho zajazdu
 */

public class Krajina {
	
	/**
	 * presný názov štátu
	 */
	
	private String stat;
	private List<Termin> zoznamTerminov = new ArrayList<>();

	public Krajina() {
		super();
	}
	
	public Krajina(String stat) {
		super();
		this.stat = stat;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public List<Termin> getZoznamTerminov() {
		return zoznamTerminov;
	}
	
	/**
	 * Vypise krajiny.
	 */
	public void vypis() {
		System.out.println("Stat " + getStat());
		System.out.println("Terminy: ");
		for (Termin termin : zoznamTerminov) {
			termin.vypis();
		}
	}

	

}
