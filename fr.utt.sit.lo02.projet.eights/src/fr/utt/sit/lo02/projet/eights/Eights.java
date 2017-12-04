package fr.utt.sit.lo02.projet.eights;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
public class Eights {
	public static int nb_humainplayer;
	public int nb_aiplayer;
	public static Scanner sc;
	private CardCollection cards;
	private List<Player> player;

	Eights(){
		this.player = new ArrayList<Player>();
		sc = new Scanner(System.in);
		boolean ready = true;
		do {
			try {
				System.out.print("Set a number of the humain player(0-2):");
				this.nb_humainplayer=sc.nextInt();
				ready = true;
			}catch(Exception e) {
				System.out.print("Please enter an integer number:");
				ready = false;
				sc.nextLine();
			}
		}while(ready==false || this.nb_humainplayer>2 || this.nb_humainplayer<0);
		for(int i=0;i<this.nb_humainplayer;i++) {
			System.out.print("please enter name for player "+(i+1)+":");
			HumainPlayer humainplayer = new HumainPlayer();
			this.player.add(humainplayer);
		}
		for(int i=0;i<this.player.size();i++)
        {
            System.out.println("Welcome："+this.player.get(i).getName());
        }
		boolean ready1 = true;
		do {
			try {
				System.out.print("Set a number of the ai player(1-3):");
				this.nb_aiplayer=sc.nextInt();
				ready1 = true;
			}catch(Exception e) {
				System.out.print("Please enter an integer number:");
				ready1 = false;
				sc.nextLine();
			}
		}while(ready1==false || this.nb_aiplayer<1 || this.nb_aiplayer>3);
		for(int i=0;i<this.nb_aiplayer;i++) {
			AIPlayer aiplayer = new AIPlayer();
			this.player.add(aiplayer);
		}
		this.cards = new CardCollection();
	}
	public static void main(String[] args) {
		Eights game = new Eights();
		//game.cards.showCards();
		System.out.println("----------shuffling cards randomly----------");
		game.cards.shuffleDrawPile();
		System.out.println("----------Show all cards shuffled-----------");
		//game.cards.showCards();
		
		int count = 0;
		System.out.println("-----------Distribution the cards-----------");
		for(int i=0;i<6;i++) {
			for(int j=0;j<game.player.size();j++) {
				game.player.get(j).setHandCards(game.cards.getDrawPile().get(0));
				game.cards.popCards(game.cards.getDrawPile().get(0));
				count++;
			}
		}
		System.out.println("--------Remove distributed cards--------");
		System.out.println("distribute "+count+"card(s)");
		
		System.out.println("----------Rest cards----------");
		game.cards.showDrawPile();
		
		ComparatorCard cc = new ComparatorCard();
		System.out.println("------Show handcards for each player-------");
		for (int i=0;i<game.player.size();i++) {
			System.out.println("player "+game.player.get(i).getName()+"'s hand cards:");
			Collections.sort(game.player.get(i).getHandCards(),cc);
			for(int j=0;j<game.player.get(i).getHandCards().size();j++) {
				Card handcards = game.player.get(i).getHandCards().get(j);
				System.out.print(handcards.getRank() + " " + handcards.getSuit() + " | ");
			}System.out.println();
		}
		
		System.out.println("-------Put the first card on the discard pile--------");
		game.cards.setDiscards(game.cards.getDrawPile().get(0));
		game.cards.popCards(game.cards.getDrawPile().get(0));
		
		System.out.println("----------Show discard pile-----------");
		game.cards.showDiscard();
		System.out.println("--------Starting play game------");
		OUT:
		do {
			for(int i=0;i<game.player.size();i++) {
				try{
					if(i<nb_humainplayer) {
						System.out.println("player "+game.player.get(i).getName()+"'s hand cards:");
						Collections.sort(game.player.get(i).getHandCards(),cc);
						for(int n=0;n<game.player.get(i).getHandCards().size();n++) {
							Card handcards = game.player.get(i).getHandCards().get(n);
							System.out.print(handcards.getRank() + " " + handcards.getSuit() + " | ");
						}System.out.println();
					}
					game.player.get(i).PlayCard(game.player.get(i), game.cards);
					if(game.player.get(i).getHandCards().size()==0){
						break OUT;
					}
					
				}catch(Exception e){
					game.player.get(i).DrawCard(game.player.get(i), game.cards);
					if(game.player.get(i).getHandCards().size()==0){
						break OUT;
					}
				}
			}
		}while(game.cards.getDrawPile().size()!=0);
		
		/**********************************************************************************/
		/*
		 * Test function for each iterator
		 */
		System.out.println("--------End of the game---------");
		System.out.println("----------Show discard pile-----------");
		game.cards.showDiscard();
		System.out.println("------Show hand cards for player-------");
		for (int i=0;i<game.player.size();i++) {
			System.out.println("player "+game.player.get(i).getName()+"'s hand cards:");
			//Order your cards
			Collections.sort(game.player.get(i).getHandCards(),cc);
			for(int j=0;j<game.player.get(i).getHandCards().size();j++) {
				Card handcards = game.player.get(i).getHandCards().get(j);
				System.out.print(handcards.getRank() + " " + handcards.getSuit() + " | ");
			}System.out.println();
		}
		System.out.println("----------Rest cards----------");
		game.cards.showDrawPile();
		/**********************************************************************************/
		
		System.out.println("--------Resault---------");
		System.out.println("Discard Pile : "+game.cards.getDiscards().size());
		System.out.println("Draw Pile : "+game.cards.getDrawPile().size());
		for(int i=0;i<game.player.size();i++){
			if(game.player.get(i).getHandCards().size()==0) {
				System.out.println(game.player.get(i).getName() + " wins!");
			}
		}
	}
}
