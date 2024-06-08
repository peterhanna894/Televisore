package org.generation.italy;

import java.util.Scanner;

import org.generation.italy.model.Televisore;

public class MainTelevisore {

	public static void main(String[] args) throws Exception {
		String scelta;
		String marca;
		String modello;
		String modalitaHotel;
		int nrPollici;
		boolean esci=false;
		Televisore t = null;
		boolean ricicla=false;
		int canale;
		String scelta2;
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		do {
			try {
				ricicla=false;
				System.out.println("Vuoi creare una TV nuova?(s/n)");
				scelta=sc.nextLine();
				if(scelta.equalsIgnoreCase("s")) {
					System.out.println("Inserisci la marca");
					marca=sc.nextLine();
					System.out.println("Inserisci il modello");
					modello=sc.nextLine();
					System.out.println("inserisci il numero di pollici");
					nrPollici=sc.nextInt();
					sc.nextLine();
					System.out.println("Lo vuoi in modalità Hotel?(s/n)");
					modalitaHotel=sc.nextLine();
					if(modalitaHotel.equalsIgnoreCase("s")) {
						t=new Televisore(marca, modello, nrPollici,true);
					}else {
						t=new Televisore(marca, modello, nrPollici);
					}
				}
				}catch (Exception e) {
					ricicla=true;
					System.out.println("Impossibile creare l'oggetto: "+ e.getMessage());
				}
		}while(ricicla);
			do {
				System.out.println("Menu TV");
				System.out.println("(1) Accendi");
				System.out.println("(2) Spegni");
				System.out.println("(3) Aumenta volume");
				System.out.println("(4) Abbassa volume");
				System.out.println("(6) Cambia canale");
				System.out.println("(7) Mostra canale corrente");
				System.out.println("(8) Visualizza elenco canali");
				System.out.println("(9) Aggiungere o cancellare un canale");
				System.out.println("(10) Modalità Hotel (on/off)");

				System.out.println("(00) Esci");
				scelta=sc.nextLine();
				
	            switch (scelta) {
	            case "1":				// Accendi la TV
	            	t.accendi();
	                break;
	            case "2":                // Spegni la TV
	            	t.spegni();
	                break;
	            case "3":                // Aumenta il volume
	            	t.aumentaVolume();
	                break;
	            case "4":                // Abbassa il volume
	            	t.dimenuisciVolume();
	                break;
	            case "6":                // Cambia canale
	            	if (t.isStato()) {
						System.out.println("Inserisci il numero di canale: ");
						t.mostraCanali();
						canale = sc.nextInt();
						sc.nextLine();
						t.cambiaCanale(canale);
					}else
						System.out.println("La TV è spenta (accendi prima la tv)");
					break;
	            case "7":		 // Mostra canale corrente
	            	t.mostraCanaleCorrente();
	                break;
	            case "8":
	                // Visualizza elenco canali
	                t.mostraCanali();
	                break;
	            case "9":
	            	//Aggiungi canale
	            	
		            do {
		            	System.out.println("(1) Per aggiungere un canale");
		            	System.out.println("(2) Per cancellare un canale");
		            	System.out.println("(3) Per tornare al menù principale");
		            	scelta2=sc.nextLine();
		            	switch (scelta2) {
						case "1":
							String nuovoCanale;
							int frequenza;
			            	System.out.println("Scrivi il nome del nuovo canale:");
			            	nuovoCanale=sc.nextLine();
			            	System.out.println("Inserisci la frequenza: ");
			            	frequenza=sc.nextInt();
			            	sc.nextLine();
			            	t.aggiungiNuovoCanale(nuovoCanale, frequenza);
							break;
						case "2":
							int canaleCancellare;
			            	System.out.println("Scrivi il numero del canale da cancellare:");
			            	canaleCancellare=sc.nextInt();
			            	sc.nextLine();
			            	t.cancellaCanale(canaleCancellare);
							break;
							
						default:
							System.out.println("Scelta non valida");
							break;
						}
		            	
		            }while(scelta2.equals("3"));
	                break;
	            case "10":
	            	  if (t.isStato()) {
						//modalità hotel (on/off)
						do {
							if (t.isModalitaHotel())
								System.out.println("Stato modalità Hotel: On ");
							else
								System.out.println("Stato modalità Hotel: Off ");
							System.out.println("Premi tasto invio per cambiare modalità");
							System.out.println("Premi tasto (1)  per tornare al menu prncipale");
							scelta2 = sc.nextLine();
							switch (scelta2) {
							case "":
								t.cambiaStatoHotel();
								break;

							default:
								break;
							}
						} while (false);
					}else
						System.out.println("La TV è spenta (accendi prima la tv)");
					break;
	            case "00":
	            	   // Esci dal menu
		               esci = true;
	            	break;
	            default:
	                System.out.println("Opzione non valida. Riprova.");
	                break;

	            }
			}while(esci==false);
			sc.close();
		}
		
	}


