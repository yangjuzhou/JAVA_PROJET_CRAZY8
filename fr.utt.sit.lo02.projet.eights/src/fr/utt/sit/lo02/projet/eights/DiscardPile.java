package fr.utt.sit.lo02.projet.eights;

import java.util.ArrayList;
import java.util.List;

public class DiscardPile {
	private List<Card> discards = new ArrayList<Card>();

	public List<Card> getDiscards() {
		return discards;
	}

	public void setDiscards(Card card) {
		discards.add(0, card);
	}

	
}
