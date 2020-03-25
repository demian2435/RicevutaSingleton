package it.polito.PO2020.ricevutaSingleton;

public class Ricevuta {
	
	public static final int NUMERO_MASSIMO_ELEMENTI = 10;
	private Item[] items;
	private int index;
	private ListaPrezzi listino;
	
	public Ricevuta(ListaPrezzi listino) {
		items = new Item[NUMERO_MASSIMO_ELEMENTI];
		index = 0;
		this.listino = listino;
	}
	
	public void add(int codice) {
		if(index >= items.length) {
			System.out.println("Errore: raggiunto limite scontrino");
			return;
		}
		
		Prodotto prodotto = listino.find(codice);
		items[index] = new Item(prodotto);
		index++;		
	}
	
	public void print() {
		double totale = 0.0;
		
		for (Item item : items) { 
			if(item == null) {
				break;
			}
			totale += item.getPrezzo();
			item.print();
		}
		
		System.out.println("Totale: " + String.format("%.2f", totale));
	}
}
