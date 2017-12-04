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
	public void PlayCard(Player player_index, CardCollection cards) {
		possibleList.clear();
		m.clear();
		for(int i=0;i<player_index.getHandCards().size();i++) {
			if(player_index.getHandCards().get(i).getRank() == cards.getDiscards().get(0).getRank() || player_index.getHandCards().get(i).getSuit() == cards.getDiscards().get(0).getSuit()) {
				possibleList.add(player_index.getHandCards().get(i));
				m.add(i);
			}
		}
		if(possibleList.size()>0) {
			for(int i=0;i<possibleList.size();i++) {
				System.out.println(i + "---->" + possibleList.get(i).getRank() + " " + possibleList.get(i).getSuit());
			}
			System.out.print("Select your card which exists in the possible list:");
		}else {
			System.out.print("Type any number to draw a card if you don't have any playable card:");
		}
		
		boolean ready = true;
		do {
			try {
				s=sc.nextInt();
				ready = true;
			}catch(Exception e) {
				System.out.print("Please enter an integer number:");
				ready = false;
				sc.nextLine();
			}
		}while(ready==false);
		
		cards.setDiscards(getPossibleList().get(s));
		player_index.popHandCards(m.get(s));
		System.out.println(player_index.getName() + " plays " + possibleList.get(s).getRank() + possibleList.get(s).getSuit());
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
			for(int i=0;i<possibleList.size();i++) {
				System.out.println(i + "---->" + possibleList.get(i).getRank() + " " + possibleList.get(i).getSuit());
			}
			s=sc.nextInt();
			cards.setDiscards(getPossibleList().get(s));
			player_index.popHandCards(m.get(s));
			System.out.println(player_index.getName() + " plays " + possibleList.get(s).getRank() + possibleList.get(s).getSuit());
		}else if(m.size()==0){
			System.out.println(player_index.getName() + " pass this turn!");
		}
	}
}
