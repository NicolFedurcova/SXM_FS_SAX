package sk.upjs;

/**
 * termin zajazdu
 */

public class Termin {
	
	/**
	 * datum kedy sa zajazd odohrá
	 */
	
	private String datum;
	
	/**
	 * mesto kam smeruje zajazd
	 */
	
	private String mesto;
	
	/**
	 * hotel kam smeruje zajazd
	 */
	
	private String hotel;
	
	/**
	 * doprava akou s adopraví zajazd
	 */
	
	private String doprava;
	
	/**
	 * pocet osob za uvedenu cenu
	 */
	
	private int pocetOsob;
	
	/**
	 * cena za pocet osob
	 */
	
	private int cena;
	
	/**
	 * volite¾ná poznámka k termínu
	 */
	
	private String poznamka;
	
	public Termin(String datum) {
		super();
		this.datum = datum;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getDoprava() {
		return doprava;
	}

	public void setDoprava(String doprava) {
		this.doprava = doprava;
	}

	public int getPocetOsob() {
		return pocetOsob;
	}

	public void setPocetOsob(int pocetOsob) {
		this.pocetOsob = pocetOsob;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}
	
	public String getPoznamka() {
		return poznamka;
	}

	public void setPoznamka(String poznamka) {
		this.poznamka = poznamka;
	}
	
	

	
	@Override
	public String toString() {
		return "Termin [datum=" + datum + ", mesto=" + mesto + ", hotel=" + hotel + ", doprava=" + doprava
				+ ", pocetOsob=" + pocetOsob + ", cena=" + cena + ", poznamka=" + poznamka + "]";
	}

	/**
	 * Vypise terminy.
	 */
	
	public void vypis() {
		String vypis = "Termin [datum=" + datum + ", mesto=" + mesto + ", hotel=" + hotel + ", doprava=" + doprava
				+ ", pocetOsob=" + pocetOsob + ", cena=" + cena + "]";
		if (poznamka!=null) {
			vypis+= "Poznamka: " + poznamka;
		}
		System.out.println(vypis);
	}

	
	
	
}
