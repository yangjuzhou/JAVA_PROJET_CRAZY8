package fr.utt.sit.lo02.projet.eights;

public class Card {

	private String rank;
	private String suit;
	
	public Card(String suit2, String rank2) {
		this.rank = rank2;
		this.suit = suit2;
	}
	
	public String getRank() {
		return rank;
	}
	
	public String getSuit() {
		return suit;
	}
	public void effect() {
		
	}
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof Card))
			return false;
		Card other = (Card) obj;
		if(suit == null) {
			if(other.suit != null)
				return false;
		}
		else if(suit.equals(other.suit))
			return false;
		if(rank == null) {
			if(other.rank != null)
				return false;
		}
		else if(rank.equals(other.rank))
			return false;
		return true;
	}
}
