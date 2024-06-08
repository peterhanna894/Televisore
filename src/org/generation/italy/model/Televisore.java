package org.generation.italy.model;

import java.util.ArrayList;

public class Televisore {
	private String marca;
	private String modello;
	private int nrPollici;
	private boolean stato;
	private int volume;
	private boolean modalitaHotel;
	// private String[] elencoCanali9={"RAI 1","RAI 2","RAI 3","RAI 4","RAI 5","RAI
	// 6","RAI 7","RAI 8","RAI 9","RAI 10"};
	private ArrayList<Canale> elencoCanali = new ArrayList<Canale>();
	private int canaleCorrente;

	public Televisore(String marca, String modello, int nrPollici, boolean modalitaHotel) throws Exception {

		if (!marca.isEmpty())
			this.marca = marca;
		else // valore predefinito
			throw new Exception("marca non valida!");
		if (!modello.isEmpty())
			this.modello = modello;
		else // valore predefinito
			throw new Exception("modello non valido!");
		if (nrPollici <= 150 && nrPollici > 10)
			this.nrPollici = nrPollici;
		else // valore predefinito
			throw new Exception("numero pollici non valido!");

		this.stato = false;
//		if (volume<=10&&volume>=0)
//			this.volume = volume;			
//		else 
//			throw new Exception("numero pollici non valido!");	
		this.volume = 0;
		this.modalitaHotel = modalitaHotel;
		
		this.canaleCorrente = 1;
		
		this.elencoCanali.add(new Canale("RAI 1", 100));
		this.elencoCanali.add(new Canale("RAI 2", 120));
		this.elencoCanali.add(new Canale("RAI 3", 135));
		this.elencoCanali.add(new Canale("Rete 4", 160));
		this.elencoCanali.add(new Canale("Canale 5", 180));
		this.elencoCanali.add(new Canale("Italia 1", 219));
		this.elencoCanali.add(new Canale("La 7", 232));
		this.elencoCanali.add(new Canale("Canale 8", 324));
		this.elencoCanali.add(new Canale("Il 9", 532));
		this.elencoCanali.add(new Canale("Telelombardia", 650));
	}

	public Televisore(String marca, String modello, int nrPollici) throws Exception {

		this(marca, modello, nrPollici, false);

	}

	public void accendi() {
		if (!stato) {
			stato = true;
			System.out.println("TV accesa");
		} else // valore predefinito
			System.out.println("TV già accesa");

	}

	public void spegni() {
		if (stato) {
			stato = false;
			System.out.println("TV spenta");
		} else // valore predefinito
			System.out.println("TV già spenta");
	}

	public void aumentaVolume() {
		if (stato) {
			int vmax;
			if (modalitaHotel)
				vmax = 5;
			else
				vmax = 10;
			if (volume < vmax) {
				volume++;
				System.out.println("Volume " + volume);
			} else
				System.out.println("Volume al massimo");
		} else
			System.out.println("La TV è spenta (accendi prima la tv)");
	}

	public void dimenuisciVolume() {
		if (stato) {
			int vmin = 0;
			if (volume > vmin) {
				volume--;
				System.out.println("Volume " + volume);
			} else
				System.out.println("Volume al minimo");
		} else
			System.out.println("La TV è spenta (accendi prima la tv)");
	}

	public boolean cambiaCanale(int canale) {
		boolean canaleCambiato=false;
		if (stato) {
			if (canale <= elencoCanali.size()) {
				canaleCorrente = canale;
				canaleCambiato = true;
				System.out.println("Canale cambiato con successo: Canale: " + elencoCanali.get(canale - 1));
			} else {
				System.out.println("Numero canale non trovato");
				canaleCambiato = false;
			} 
		}else
			System.out.println("La TV è spenta (accendi prima la tv)");
		return canaleCambiato;
	}

	public void mostraCanali() {
		if (stato) {
			for (int i = 0; i < elencoCanali.size(); i++) {
				System.out.println("canale " + (i + 1) + " " + elencoCanali.get(i));
			} 
		}else
			System.out.println("La TV è spenta (accendi prima la tv)");
	}

	public void mostraCanaleCorrente() {

		if (stato) {
			System.out
					.println("canale corrente: (" + canaleCorrente + ") " + elencoCanali.get(canaleCorrente - 1).toString());
		}else
			System.out.println("La TV è spenta (accendi prima la tv)");

	}

	public void aggiungiNuovoCanale(String nuovoCanale,int frequenza) {

		if (stato) {
			Canale c =new Canale(nuovoCanale, frequenza);
			if (elencoCanali.size() <= 20) {
				elencoCanali.add(c);

				System.out.println("Canale aggiunto con successo ");
			} else {
				System.out.println("Lista canali piena");

			} 
		}else
			System.out.println("La TV è spenta (accendi prima la tv)");

	}

	public void cancellaCanale(int canaleCancellare) {

		if (stato) {
			if (canaleCancellare <= elencoCanali.size()) {
				System.out.println("Canale (" + elencoCanali.get(canaleCancellare - 1) + ") rimosso con sucesso");
				elencoCanali.remove(canaleCancellare - 1);
			} else {
				System.out.println("Canale non trovato");
			} 
		}else
			System.out.println("La TV è spenta (accendi prima la tv)");
	}

	public void cambiaStatoHotel() {
		if (stato) {
			modalitaHotel = !modalitaHotel;
		}else
			System.out.println("La TV è spenta (accendi prima la tv)");
	}

	public ArrayList<Canale> getElencoCanali() {
		return elencoCanali;
	}

//	public void setElencoCanali(ArrayList<String> elencoCanali) {
//		this.elencoCanali = elencoCanali;
//	}

	public String getMarca() {
		return marca;
	}

	public String getModello() {
		return modello;
	}

	public int getNrPollici() {
		return nrPollici;
	}

	public boolean isStato() {
		return stato;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isModalitaHotel() {
		return modalitaHotel;
	}

	public int getCanaleCorrente() {
		return canaleCorrente;
	}

}
