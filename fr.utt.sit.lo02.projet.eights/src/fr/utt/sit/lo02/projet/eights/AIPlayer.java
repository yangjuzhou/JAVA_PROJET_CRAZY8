package fr.utt.sit.lo02.projet.eights;

import java.util.ArrayList;
import java.util.List;

public class AIPlayer extends Player implements Play{
	AIPlayer(){
		super("AI");
	}
	List<Card> possibleList = new ArrayList<Card>();
	List<Integer> m = new ArrayList<Integer>();
	public List<Card> getPossibleList(){
		return possibleList;
	}
	public void PlayCard(Player player_index, CardCollection cards) {
		possibleList.clear();
		m.clear();
		for(int i=0;i<player_index.getHandCards().size();i++) {
			if(player_index.getHandCards().get(i).getRank() == cards.getDiscards().get(0).getRank() || player_index.getHandCards().get(i).getSuit() == cards.getDiscards().get(0).getSuit()) {
				possibleList.add(player_index.getHandCards().get(i));
				m.add(i);
			}
		}
		cards.setDiscards(getPossibleList().get(0));
		player_index.popHandCards(m.get(0));
		System.out.println(player_index.getName() + " plays " + possibleList.get(0).getRank() + possibleList.get(0).getSuit());
	}
	
	public void DrawCard(Player player_index, CardCollection cards) {
		player_index.setHandCards(cards.getDrawPile().get(0));
		System.out.println(player_index.getName() + " draws " + cards.getDrawPile().get(0).getRank() + cards.getDrawPile().get(0).getSuit());
		cards.popCards(cards.getDrawPile().get(0));
		possibleList.clear();
		m.clear();
		for(int i=0;i<player_index.getHandCards().size();i++) {
			if(player_index.getHandCards().get(i).getRank() == cards.getDiscards().get(0).getRank() || player_index.getHandCards().get(i).getSuit() == cards.getDiscards().get(0).getSuit()) {
				possibleList.add(player_index.getHandCards().get(i));
				m.add(i);
			}
		}
		if(m.size()>0) {
			cards.setDiscards(getPossibleList().get(0));
			player_index.popHandCards(m.get(0));
			System.out.println(player_index.getName() + " plays " + possibleList.get(0).getRank() + possibleList.get(0).getSuit());
		}
		else
			System.out.println(player_index.getName() + " pass this turn!");
	}
}