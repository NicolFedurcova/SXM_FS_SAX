package sk.upjs;

import java.util.ArrayList;
import java.util.List;

/**
 * Zajazd ponuky dovoleniek.
 */

public class Zajazd {
	
	/**
	 * kategória zájazdu
	 */
	
	private String kategoria;	
	private List<Krajina> zoznamKrajin = new ArrayList<>();

	
	public Zajazd() {
		super();
	}

	public Zajazd(String kategoria) {
		this.kategoria = kategoria;
	}
	
	public String getKategoria() {
		return kategoria;
	}

	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}

	public List<Krajina> getZoznamKrajin() {
		return zoznamKrajin;
	}
	
	/**
	 * Vypise zajazdy.
	 */
	
	public void vypis() {
		System.out.println("Kategoria " + getKategoria());
		System.out.println("Krajiny: ");
		for (Krajina krajina : zoznamKrajin) {
			krajina.vypis();
		}
	}
	
	

	

}
