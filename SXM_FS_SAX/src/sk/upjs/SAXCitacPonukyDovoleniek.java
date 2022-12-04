package sk.upjs;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXCitacPonukyDovoleniek {

	/**
	 * Vytvori studijnu skupinu podla obsahu xml suboru.
	 * 
	 * @param xmlSubor
	 *            subor s xml popisom studijnej skupiny.
	 * @return studijna skupina.
	 */
	public PonukaDovoleniek citajZXml(File xmlSubor) {
		// Vytvorime tovaren na SAX parsery
		SAXParserFactory spf = SAXParserFactory.newInstance();

		// Vytvorime parse s pozadovanymi vlastnostami
		SAXParser parser;
		try {
			parser = spf.newSAXParser();
		} catch (Exception e) {
			throw new RuntimeException("Neviem vytvorit pozadovany parser.", e);
		}
		// Skusime rozparsovat dokument
		try {
			// Vytvorime handler, v ktorom sa pocas parsovania vytvoria
			// prislusne objekty
			PonukaDovoleniekSAXHandler handler = new PonukaDovoleniekSAXHandler();
			// Parsovanie s vyuzitim handlera
			parser.parse(xmlSubor, handler);
			// Vratime vysledok vytvoreny handlerom.
			return handler.vratVysledokParsovania();
		} catch (Exception e) {
			throw new RuntimeException(
					"XML dokument sa nepodarilo precitat alebo rozparsovat.", e);
		}
	}

	public static void main(String[] args) {
		SAXCitacPonukyDovoleniek citac = new SAXCitacPonukyDovoleniek();
		PonukaDovoleniek ponuka = citac.citajZXml(new File(
				"PonukaDovoleniek.xml"));

		ponuka.vypis(); 
	}


}
