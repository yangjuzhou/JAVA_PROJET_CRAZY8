package fr.utt.sit.lo02.projet.eights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	private int id;
	private String name;
	private Scanner sc;
	private List<Card> handcards = new ArrayList<Card>();
	
	public Player() {
		sc = new Scanner(System.in);
		this.name=sc.next();
	}
	public Player(String ai) {
		this.name = ai;
	} 
	public List<Card> getHandCards(){
		return handcards;
	}
	
	public void setHandCards(Card card) {
		handcards.add(card);
	}
	
	public void popHandCards(int index) {
		handcards.remove(index);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void PlayCard(Player player_index, CardCollection cards, Game game) {
		
	}
	
	public void DrawCard(CardCollection cards) {
		setHandCards(cards.getDrawPile().get(0));
		System.out.println(getName() + " draws " + cards.getDrawPile().get(0).getRank() + cards.getDrawPile().get(0).getSuit());
		cards.popCards(cards.getDrawPile().get(0));
	}
	
	public void SecondChance(Player player_index, CardCollection cards, Game game) {
		
	}
}