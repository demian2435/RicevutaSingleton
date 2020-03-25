package it.polito.PO2020.ricevutaSingleton;

public class Prodotto {
	
	private double prezzo;
	private String nome;
	
	// GENERATO IN AUTOMATICO SE NO CI SONO COSTRUTTORI
	public Prodotto() {};
	
	public Prodotto(double prezzo, String nome) {
		this.prezzo = prezzo;
		this.nome = nome;
	}

	public double getPrezzo() {
		return prezzo;
	}
	
	public void print() {
		System.out.println("* nome: " + nome + "\t prezzo: " + String.format("%.2f", prezzo));
		// TODO stampare il nome con il comando format per allineare il tutto
	}
}
