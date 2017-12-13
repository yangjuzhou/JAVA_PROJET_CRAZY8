package fr.utt.sit.lo02.projet.eights;

public class Card {

	private String rank;
	private String suit;
	
	public Card(String suit, String rank) {
		this.rank = rank;
		this.suit = suit;
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
	public void applyEffect(Game game) {
		switch(this.rank)
		{
		case "Ace":
			game.changeDirection();
			break;
		case "2":
			game.drawTwoCards();
			break;
		case "8":
			game.changeColor();
			break;
		case "10":
			game.replay();
			break;
		case "Jack":
			game.skipPlayer();
			break;
		default:
			break;
		}
	}
}
