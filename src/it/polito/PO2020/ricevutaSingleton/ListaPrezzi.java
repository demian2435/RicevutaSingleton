package it.polito.PO2020.ricevutaSingleton;

import java.util.Random;

public class ListaPrezzi {

	Random generator = new Random(2);
	public static final int NUMERO_PRODOTTI = 1000;
	private Prodotto[] prodotti;
	private static ListaPrezzi singleton;

	private ListaPrezzi(int numeroProdotti) {
		prodotti = new Prodotto[numeroProdotti];
		for (int i = 0; i < prodotti.length; i++) {
			prodotti[i] = new Prodotto(generaPrezzo(), generaNome(i));
		}
	}

	public static ListaPrezzi getListaPrezzi() {
		if (singleton == null) {
			singleton = new ListaPrezzi(NUMERO_PRODOTTI);
		}
		;
		return singleton;
	}

	public Prodotto find(int codice) {
		if (codice < 0 || codice >= prodotti.length) {
			System.out.println("Errore: prodotto inesistente");
			return null;
		}
		return prodotti[codice];
	}

	private double generaPrezzo() {
		return (generator.nextDouble() * 100) + 0.1;
	}

	private String generaNome(int i) {
		return "P_" + i;
	}

}
