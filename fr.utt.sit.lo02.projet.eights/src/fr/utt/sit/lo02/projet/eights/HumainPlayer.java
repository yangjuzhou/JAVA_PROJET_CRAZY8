package fr.utt.sit.lo02.projet.eights;

import java.util.Scanner;

public class HumainPlayer extends Player implements Play{
	Scanner sc = new Scanner(System.in);
	private int s;
	HumainPlayer(){
		super();
	}
	TemporalList pl = new TemporalList();
	public void PlayCard(Player player_index, CardCollection cards, Game game) {
		pl.PossibleListCard(player_index,cards);
		if(pl.possibleList.size()>0) {
			for(int i=0;i<pl.possibleList.size();i++) {
				System.out.println(i + "---->" + pl.possibleList.get(i).getRank() + " " + pl.possibleList.get(i).getSuit());
			}
			System.out.print("Select your card which exists in the possible list:");
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
		}else {
			System.out.println("!!!!!!Draw your card!!!!!!");
		}

		cards.setDiscards(pl.getPossibleList().get(s));
		player_index.popHandCards(pl.m.get(s));
		System.out.println(player_index.getName() + " plays " + pl.possibleList.get(s).getRank() + pl.possibleList.get(s).getSuit());
		pl.possibleList.get(s).applyEffect(game);
	}

	public void SecondChance(Player player_index, CardCollection cards, Game game) {
		DrawCard(cards);
		pl.PossibleListCard(player_index,cards);
		if(pl.m.size()>0) {
			for(int i=0;i<pl.possibleList.size();i++) {
				System.out.println(i + "---->" + pl.possibleList.get(i).getRank() + " " + pl.possibleList.get(i).getSuit());
			}
			System.out.print("Select your card which exists in the possible list:");
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
			cards.setDiscards(pl.getPossibleList().get(s));
			player_index.popHandCards(pl.m.get(s));
			System.out.println(player_index.getName() + " plays " + pl.possibleList.get(s).getRank() + pl.possibleList.get(s).getSuit());
			pl.possibleList.get(s).applyEffect(game);
		}else{
			System.out.println(player_index.getName() + " pass this turn!");
		}
	}
}
