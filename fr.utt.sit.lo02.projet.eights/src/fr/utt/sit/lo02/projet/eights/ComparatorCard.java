package fr.utt.sit.lo02.projet.eights;

import java.util.Comparator;

public class ComparatorCard implements Comparator<Card>{

	@Override
	public int compare(Card c1, Card c2) {
		String[] suit = {
				null, "Clubs", "Diamonds", "Hearts", "Spades"
				};
		String[] rank = {
		        null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"
		        };
		int valueOfC1 = 0;
        int valueOfC2 = 0;
        for(int i=1;i<rank.length;i++){
            if(c1.getRank().equals(rank[i])) valueOfC1 += i;
            if(c2.getRank().equals(rank[i])) valueOfC2 += i;
        }
        for(int i=1;i<suit.length;i++){
            if(c1.getSuit().equals(suit[i])) valueOfC1 += i*100;
            if(c2.getSuit().equals(suit[i])) valueOfC2 += i*100;
        }

        if( valueOfC1 > valueOfC2 ) return 1;
        if( valueOfC1 < valueOfC2 ) return -1;
		return 0;
	}
	
}

