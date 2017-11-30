package fr.utt.sit.lo02.projet.eights;

import java.util.ArrayList;
import java.util.List;

public class AIPlayer extends Player{
	AIPlayer(){
		super("ai");
	}
	List<Card> possibleList = new ArrayList<Card>();
	List<Integer> m = new ArrayList<Integer>();
	public List<Card> getPossibleList(){
		return possibleList;
	}
	public void PlayCard(Player player_index, DiscardPile discard) {
		possibleList.clear();
		m.clear();
		for(int i=0;i<player_index.getHandCards().size();i++) {
			if(player_index.getHandCards().get(i).getRank() == discard.getDiscards().get(0).getRank() || player_index.getHandCards().get(i).getSuit() == discard.getDiscards().get(0).getSuit()) {
				possibleList.add(player_index.getHandCards().get(i));
				m.add(i);
			}
		}
		discard.setDiscards(getPossibleList().get(0));
		player_index.popHandCards(m.get(0));
		System.out.println(player_index.getName() + " plays " + possibleList.get(0).getRank() + possibleList.get(0).getSuit());
	}
	
	public void DrawCard(Player player_index, Cards cards, DiscardPile discard) {
		player_index.setHandCards(cards.getList().get(0));
		System.out.println(player_index.getName() + " draws " + cards.getList().get(0).getRank() + cards.getList().get(0).getSuit());
		cards.removeCards(cards.getList().get(0));
		possibleList.clear();
		m.clear();
		for(int i=0;i<player_index.getHandCards().size();i++) {
			if(player_index.getHandCards().get(i).getRank() == discard.getDiscards().get(0).getRank() || player_index.getHandCards().get(i).getSuit() == discard.getDiscards().get(0).getSuit()) {
				possibleList.add(player_index.getHandCards().get(i));
				m.add(i);
			}
		}
		if(m.size()>0) {
			discard.setDiscards(getPossibleList().get(0));
			player_index.popHandCards(m.get(0));
			System.out.println(player_index.getName() + " plays " + possibleList.get(0).getRank() + possibleList.get(0).getSuit());
		}
		else
			System.out.println(player_index.getName() + " pass this turn!");
	}
}