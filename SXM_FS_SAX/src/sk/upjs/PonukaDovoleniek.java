package sk.upjs;

import java.util.ArrayList;
import java.util.List;

/**
 * Ponuka dovoleniek v danom roku.
 */

public class PonukaDovoleniek {
	
	private int rok;
	private List <Zajazd> zajazdy = new ArrayList<>();
	
	/**
	 * Vytvori novu ponuku dovoleniek.
	 * 
	 * @param rok
	 *            rok ponuky
	 */

	public PonukaDovoleniek(int rok) {
		super();
		this.rok = rok;
	}

	public int getRok() {
		return rok;
	}

	public void setRok(int rok) {
		this.rok = rok;
	}

	public List<Zajazd> getZajazd() {
		return zajazdy;
	}

	public void setZajazd(List<Zajazd> zajazdy) {
		this.zajazdy = zajazdy;
	}
	
	/**
	 * Vypise ponuku dovoleniek.
	 */
	
	public void vypis() {
		System.out.println("Rok: " + getRok());
		System.out.println("Zajazdy: ");
		for (Zajazd zajazd : zajazdy) {
			zajazd.vypis();
		}
	}
	
	

}
