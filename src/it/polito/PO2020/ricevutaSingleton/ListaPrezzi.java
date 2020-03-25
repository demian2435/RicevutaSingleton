package it.polito.PO2020.ricevutaSingleton;

import java.util.Random;

public class ListaPrezzi {
	
	Random generator = new Random(0);
	private Prodotto[] prodotti;

	public ListaPrezzi() {
		prodotti = new Prodotto[] {
				new Prodotto(1.5,"Birra"),
				new Prodotto(7.25,"Vino"),
				new Prodotto(0.7,"Patatine"),
				new Prodotto(2.0,"Coca-Cola"),
				new Prodotto(4.75,"Nutella")
		};
	}
	
	public ListaPrezzi(int numeroProdotti) {
		prodotti = new Prodotto[numeroProdotti];	
		for (int i = 0; i < prodotti.length; i++) {
			prodotti[i] = new Prodotto(generaPrezzo(), generaNome(i));
		}
	}
	
	public Prodotto find(int codice) {
		if(codice < 0 || codice >= prodotti.length) {
			System.out.println("Errore: prodotto inesistente");
			return null;
		}
		return prodotti[codice];
	}
	
	private double generaPrezzo() {
		return (generator.nextDouble() * 100) + 0.1;
	}
	
	private String generaNome(int i) {
		return "Prodotto " + i;
	}
	
}
