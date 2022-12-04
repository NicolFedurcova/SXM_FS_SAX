package sk.upjs;

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Handler pre parsovanie xml so studijnou skupinou.
 */

public class PonukaDovoleniekSAXHandler extends DefaultHandler {

		/**
		 * StringBuilder, v ktorom budeme akumulovat textovy obsah elementov.
		 * Vyuzivame, ze elementy neobsahuju mixed content (ak neratame biele znaky)
		 */
		private StringBuilder textContentBuilder;

		/**
		 * Zasobnik, v ktorom si budeme uchovavat objekty zodpovedajuce "hlavnym"
		 * otvorenym elementom.
		 */
		private Stack<Object> stack;

		/**
		 * Vysledok spracovania.
		 */
		private PonukaDovoleniek vysledok;

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			
			String name = localName.isEmpty() ? qName : localName;
			textContentBuilder.setLength(0);
		
			//PonukaDovoleniek je koreÚov˝m elementom (v˝sledkom) s povinn˝m atrib˙tom rok
			if ("PonukaDovoleniek".equals(name)) {
				int rok = Integer.parseInt(attributes.getValue("rok"));
				this.vysledok = new PonukaDovoleniek(rok);
				stack.push(this.vysledok);
				return;
			}
			//zajazd je podelement ponuky dovoleniek
			if ("Zajazd".equals(name)) {
				Zajazd zajazd = new Zajazd();
				//pridame zajazd do ponuky dovoleniek - rodicom zajazdu je ponuka dovoleniek
				zajazd.setKategoria(attributes.getValue("kategoria"));
				((PonukaDovoleniek) stack.peek()).getZajazd().add(zajazd);

				// Pridame zajazd medzi "otvorene elementy" - do stacku
				stack.push(zajazd);
				return;
			}
			//krajina je podelement zajazdu
			if ("Krajina".equals(name)) {
				Krajina krajina = new Krajina();
				//tu tahame atributy --> vnorene objekty az pri end elemente
				krajina.setStat(attributes.getValue("stat"));
				((Zajazd) stack.peek()).getZoznamKrajin().add(krajina);
				stack.push(krajina);
				return;
			}
			//termin je podelement krajiny
			if ("Termin".equals(name)) {
				Termin termin = new Termin(attributes.getValue("datum"));
				((Krajina) stack.peek()).getZoznamTerminov().add(termin);
				stack.push(termin);
				return;
			}
			
			//ak element (napr. Hotel) nema podlelementy ani atributy neprid·vam ho do stacku
		}
		
		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			String name = localName.isEmpty() ? qName : localName;
		
			if ("PonukaDovoleniek".equals(name) || "Zajazd".equals(name)
					|| "Krajina".equals(name) || "Termin".equals(name)) {
				stack.pop(); 
				return;
			}
			
			// Ak je aktivny objekt (na "vrchu" stacku) termin, spracujeme koncove tagy jeho
			// podelementov s informaciami.
			
			//pri ostatn˝ch tagoch, ktorÈ s˙ nad termÌnom nem·me ûiadne elementy, 
			//ktorÈ by museli byù takto spracovanÈ 
			
			Object peekObject = stack.peek();
			if (peekObject instanceof Termin) {
				
				Termin termin = (Termin) peekObject;
				switch (name) {
				//viem ze som v Termine
				case "Mesto":
					termin.setMesto(textContentBuilder.toString());
					break;
				case "Hotel":
					termin.setHotel(textContentBuilder.toString());
					break;
				case "Doprava":
					termin.setDoprava(textContentBuilder.toString());
					break;
				case "PocetOsob":
					termin.setPocetOsob(Integer.parseInt(textContentBuilder.toString()));
					break;
				case "Cena":
					termin.setCena(Integer.parseInt(textContentBuilder.toString()));
					break;
				case "Poznamka":
					termin.setPoznamka(textContentBuilder.toString());
					break;
				}
			}

			textContentBuilder.setLength(0); //vynulujeme text content builder
		}
		
		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			textContentBuilder.append(ch, start, length);
		}

		public PonukaDovoleniekSAXHandler() {
			textContentBuilder = new StringBuilder();
			stack = new Stack<>();
		}

		/**
		 * Vrati naplneny objekt studijnej skupiny, ktory je vysledkom parsovania.
		 */
		public PonukaDovoleniek vratVysledokParsovania() {
			return vysledok;
		}
}
