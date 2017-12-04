package fr.utt.sit.lo02.projet.eights;

public interface Play {
	public abstract void PlayCard(Player player_index, CardCollection cards);
	
	public abstract void DrawCard(Player player_index, CardCollection cards);
}
