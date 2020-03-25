package it.polito.PO2020.ricevutaSingleton;

public class Ricevuta {

	private Item primoElemento;
	public static double totaleRicevuta;
	public static int totProdotti;

	public Ricevuta() {
	}

	public void add(int codice) {
		Prodotto prodotto = ListaPrezzi.getListaPrezzi().find(codice);
		Item nuovoElemento = new Item(prodotto, primoElemento);
		primoElemento = nuovoElemento;
	}

	// SANSIONE CENTRALIZZATA
	public void print() {
		double totale = 0.0;
		Item x = primoElemento;

		while (x.getNext() != null) {
			totale += x.getPrezzo();
			x.print();
			x = x.getNext();
		}

		totale += x.getPrezzo();
		x.print();

		System.out.printf("Totale: %.2f", totale);
	}

	// SCANSIONE DE-CENTRALIZZATA (DELEGA L'OGGETTO)
	public void printR() {
		primoElemento.printRicorsivo();
		System.out.printf("\n  Prodotti: %-7d Totale: %6.2f", totProdotti, totaleRicevuta);
	}

	private static class Item {

		private Prodotto prodotto;
		private Item nextItem;

		public Item(Prodotto prodotto, Item nextItem) {
			this.prodotto = prodotto;
			this.nextItem = nextItem;
			totaleRicevuta += prodotto.getPrezzo();
			totProdotti++;
		}

		public void print() {
			prodotto.print();
		}

		public void printRicorsivo() {
			// prodotto.print(); // STAMPA DAL PRIMO ALL'ULTIMO

			// TOTALE STATIC
			// double somma = 0.0;

			// FINE RICORSIONE
			if (nextItem != null) {
				// TOTALE STATIC
				// somma = nextItem.printRicorsivo();
				nextItem.printRicorsivo();
			}

			prodotto.print(); // STAMPA DALL'ULTIMO AL PRIMO

			// TOTALE STATIC
			// return getPrezzo() + somma;
		}

		public double getPrezzo() {
			return prodotto.getPrezzo();
		}

		public Item getNext() {
			return nextItem;
		}
	}
}
