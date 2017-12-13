package fr.utt.sit.lo02.projet.eights;

public interface Play {
	public abstract void PlayCard(Player player_index, CardCollection cards, Game game);
	
	public abstract void SecondChance(Player player_index, CardCollection cards, Game game);
}
