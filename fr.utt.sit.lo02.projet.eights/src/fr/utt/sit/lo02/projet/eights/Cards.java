package fr.utt.sit.lo02.projet.eights;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Cards {
	private List<Card> list = new ArrayList<Card>();
	
	public Cards() {
		System.out.println("----------Creation Cards----------");
		String[] suit = {
				null, "Clubs", "Diamonds", "Hearts", "Spades"
				};
		String[] rank = {
		        null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
		        };
		for (int i=1;i<suit.length;i++)
			for(int j=1;j<rank.length;j++) {
				list.add(new Card(suit[i],rank[j]));
			}
		System.out.println("----------Creation Cards with success----------");	
	}
	
	public List<Card> getList(){
		return list;
	}
	
	public void shuffleCards() {
		System.out.println("----------shuffling cards randomly----------");
		Collections.shuffle(list);
	}
	
	public void showCards() {
		System.out.print("Card list:[ ");
		for (int i=0;i<list.size();i++) {
			System.out.print(list.get(i).getRank() + " " + list.get(i).getSuit() + " | ");
		}
		System.out.println("]");
	}
	
	public void removeCards(Card card) {
		list.remove(card);
	}
}
