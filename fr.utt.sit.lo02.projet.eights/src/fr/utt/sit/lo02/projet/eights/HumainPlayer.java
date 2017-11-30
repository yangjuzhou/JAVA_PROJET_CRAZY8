package fr.utt.sit.lo02.projet.eights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumainPlayer extends Player{
	List<Card> possibleList = new ArrayList<Card>();
	List<Integer> m = new ArrayList<Integer>();
	Scanner sc = new Scanner(System.in);
	private int s;
	HumainPlayer(){
		super();
	}
	
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
		if(possibleList.size()>0) {
			for(int i=0;i<possibleList.size();i++) {
				System.out.println(i + "---->" + possibleList.get(i).getRank() + " " + possibleList.get(i).getSuit());
			}
			System.out.println("Select your card which exists in the possible list : ");
		}else {
			System.out.println("Type any number to draw a card if you don't have any playable card");
		}
		s=sc.nextInt();
		discard.setDiscards(getPossibleList().get(s));
		player_index.popHandCards(m.get(s));
		System.out.println(player_index.getName() + " plays " + possibleList.get(s).getRank() + possibleList.get(s).getSuit());
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
			for(int i=0;i<possibleList.size();i++) {
				System.out.println(i + "---->" + possibleList.get(i).getRank() + " " + possibleList.get(i).getSuit());
			}
			s=sc.nextInt();
			discard.setDiscards(getPossibleList().get(s));
			player_index.popHandCards(m.get(s));
			System.out.println(player_index.getName() + " plays " + possibleList.get(s).getRank() + possibleList.get(s).getSuit());
		}else if(m.size()==0){
			System.out.println(player_index.getName() + " pass this turn!");
		}
	}
}
