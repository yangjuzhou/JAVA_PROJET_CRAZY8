package fr.utt.sit.lo02.projet.eights;

import java.util.ArrayList;
import java.util.List;

public class TemporalList {
	List<Card> possibleList = new ArrayList<Card>();
	List<Integer> m = new ArrayList<Integer>();
	
	public List<Card> getPossibleList(){
		return possibleList;
	}
	public void setPossibleList(Card card) {
		possibleList.add(card);
	}
	
	public void PossibleListCard(Player player_index, CardCollection cards){
		possibleList.clear();
		m.clear();
		for(int i=0;i<player_index.getHandCards().size();i++) {
			if(player_index.getHandCards().get(i).getRank() == cards.getDiscards().get(0).getRank() || player_index.getHandCards().get(i).getSuit() == cards.getDiscards().get(0).getSuit()) {
				setPossibleList(player_index.getHandCards().get(i));
				m.add(i);
			}
		}
	}
}
