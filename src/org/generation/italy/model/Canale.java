package org.generation.italy.model;

import java.util.Random;

public class Canale {

	private String nome;
	private int frequenza;
	private int segnale;
	Random r=new Random();
	public Canale(String nome, int frequenza) {
		super();
		do {
			if (!nome.isBlank())
				this.nome = nome;
		} while (nome.isBlank());
		this.frequenza = frequenza;
		this.segnale = r.nextInt(101);
	}
	
	
}
