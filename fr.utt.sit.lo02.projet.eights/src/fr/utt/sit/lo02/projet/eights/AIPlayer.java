package fr.utt.sit.lo02.projet.eights;

public class AIPlayer extends Player implements Play{
	AIPlayer(int ID){
		super("AI "+ID);
	}
	TemporalList pl = new TemporalList();
	public void PlayCard(Player player_index, CardCollection cards, Game game) {
		pl.PossibleListCard(player_index,cards);
		cards.setDiscards(pl.getPossibleList().get(0));
		player_index.popHandCards(pl.m.get(0));
		System.out.println(player_index.getName() + " plays " + pl.possibleList.get(0).getRank() + pl.possibleList.get(0).getSuit());
		pl.possibleList.get(0).applyEffect(game);
	}

	public void SecondChance(Player player_index, CardCollection cards, Game game) {
		DrawCard(cards);
		pl.PossibleListCard(player_index,cards);
		if(pl.m.size()>0) {
			cards.setDiscards(pl.getPossibleList().get(0));
			player_index.popHandCards(pl.m.get(0));
			System.out.println(player_index.getName() + " plays " + pl.possibleList.get(0).getRank() + pl.possibleList.get(0).getSuit());
			pl.possibleList.get(0).applyEffect(game);
		}
		else {
				System.out.println(player_index.getName() + " pass this turn!");
		}
	}
}