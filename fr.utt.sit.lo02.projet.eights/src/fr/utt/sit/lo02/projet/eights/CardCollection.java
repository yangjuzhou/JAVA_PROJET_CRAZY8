package fr.utt.sit.lo02.projet.eights;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class CardCollection {
	private List<Card> drawpile = new ArrayList<Card>();
	private List<Card> discardpile = new ArrayList<Card>();
	public CardCollection() {
		System.out.println("----------Creation Cards----------");
		String[] suit = {
				null, "Clubs", "Diamonds", "Hearts", "Spades"
				};
		String[] rank = {
		        null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
		        };
		for (int i=1;i<suit.length;i++)
			for(int j=1;j<rank.length;j++) {
				drawpile.add(new Card(suit[i],rank[j]));
			}
		System.out.println("----------Creation Cards with success----------");	
	}
	
	public List<Card> getDrawPile(){
		return drawpile;
	}
	
	public void shuffleDrawPile() {
		Collections.shuffle(drawpile);
	}
	
	public void showDrawPile() {
		System.out.print("Card list:[ ");
		for (int i=0;i<drawpile.size();i++) {
			System.out.print(drawpile.get(i).getRank() + " " + drawpile.get(i).getSuit() + " | ");
		}
		System.out.println("]");
	}
	
	public void popCards(Card card) {
		drawpile.remove(card);
	}
	
	public List<Card> getDiscards() {
		return discardpile;
	}

	public void setDiscards(Card card) {
		discardpile.add(0, card);
	}
	
	public void showDiscard() {
		System.out.print("Card list:[ ");
		for(int i=0;i<discardpile.size();i++) {
			System.out.print(discardpile.get(i).getRank() + " " + discardpile.get(i).getSuit() + " | ");
		}System.out.println("]");
	}
}
