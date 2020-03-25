package it.polito.PO2020.ricevutaSingleton;

public class EsempioRicevuta {
	
	public static void main(String[] args) {
		
		ListaPrezzi listino = new ListaPrezzi(1000);
//		Prodotto p = listino.find(21);
//		p.print();
		Ricevuta r = new Ricevuta(listino);
		r.add(10);
		r.add(47);
		r.add(128);
		
		r.print();
	}

}
