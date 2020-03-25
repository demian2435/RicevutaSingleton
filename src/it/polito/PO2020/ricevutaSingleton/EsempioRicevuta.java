package it.polito.PO2020.ricevutaSingleton;

public class EsempioRicevuta {

	public static void main(String[] args) {

//		Prodotto p = ListaPrezzi.getListaPrezzi().find(21);
//		p.print();
		Ricevuta r = new Ricevuta();
		r.add(10);
		r.add(47);
		r.add(128);
		r.add(736);

		r.printR();
	}

}
