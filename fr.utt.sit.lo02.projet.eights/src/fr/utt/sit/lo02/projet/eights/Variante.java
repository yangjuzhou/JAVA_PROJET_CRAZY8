package fr.utt.sit.lo02.projet.eights;

public class Variante {
	private Card effet;
	
	public void effet() {
		if(effet.getRank()=="8") {
			System.out.println("Please choose your suit to continue.");
		}
	}
}
