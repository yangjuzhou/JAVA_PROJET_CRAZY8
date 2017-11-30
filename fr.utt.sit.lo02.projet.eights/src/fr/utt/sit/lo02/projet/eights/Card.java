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
	/*public int compareTo(Card that) {
		if(this.suit<that.suit) {
			return -1;
		}
		if(this.suit>that.suit) {
			return 1;
		}
		if(this.rank<that.rank) {
			return -1;
		}
		if(this.rank<that.rank) {
			return -1;
		}
		return 0;
	}*/
}
