package fr.utt.sit.lo02.projet.eights;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
public class Game {
	public int nb_humainplayer;
	public int nb_aiplayer;
	public static Scanner sc;
	private CardCollection cards;
	public List<Player> player;
	//private TemporalList two;
	//private int variant;
	public int turn;
	
	Game(){
		this.player = new ArrayList<Player>();
		sc = new Scanner(System.in);
		boolean ready = true;
		do {
			try {
				System.out.print("Set a number of the humain player:");
				this.nb_humainplayer=sc.nextInt();
				ready = true;
			}catch(Exception e) {
				System.out.print("Please enter an integer number:");
				ready = false;
				sc.nextLine();
			}
		}while(ready==false || this.nb_humainplayer>5 || this.nb_humainplayer<0);
		for(int i=0;i<this.nb_humainplayer;i++) {
			System.out.print("please enter name for player "+(i+1)+":");
			HumainPlayer humainplayer = new HumainPlayer();
			this.player.add(humainplayer);
		}
		for(int i=0;i<this.player.size();i++)
        {
            System.out.println("Welcome：" + this.player.get(i).getName());
        }
		boolean ready1 = true;
		do {
			try {
				System.out.print("Set a number of the ai player:");
				this.nb_aiplayer=sc.nextInt();
				ready1 = true;
			}catch(Exception e) {
				System.out.print("Please enter an integer number:");
				ready1 = false;
				sc.nextLine();
			}
		}while(ready1==false || this.nb_aiplayer+this.nb_humainplayer<2 || this.nb_aiplayer+this.nb_humainplayer>5);
		for(int i=0;i<this.nb_aiplayer;i++) {
			AIPlayer aiplayer = new AIPlayer(i);
			this.player.add(aiplayer);
		}
		this.cards = new CardCollection();
//		this.two = new TemporalList();
	}
	/**************Les effects des cartes**************/
	public void changeDirection() {
		Collections.reverse(player);
		turn=Math.abs(turn-this.player.size()+1);
		System.out.println("!!!!!!!REVERSED!!!!!!!!");
	}
	public void changeColor() {
		System.out.println("Choose the suit you want to set:");
		System.out.println("0.Spade");
		System.out.println("1.Heart");
		System.out.println("2.Club");
		System.out.println("3.Diamond");
		System.out.print("Set your suit:");
		sc = new Scanner(System.in);
		boolean error=true;
		int color = 0;
		String suit;
		if(this.player.get(turn) instanceof AIPlayer) {
			color = (int) (Math.random() * 4);
		}else {
			do {
				try {
					color = sc.nextInt();
					error = false;
				} catch (Exception e) {
					System.out.println("Please enter an integer number!");
					error = true;
					sc.nextLine();
				}
			} while (error == true || color < 0 || color > 3);
		}
		switch (color) {
		case 0:
			suit = "Spades";
			break;
		case 1:
			suit = "Hearts";
			break;
		case 2:
			suit = "Clubs";
			break;
		case 3:
			suit = "Diamonds";
			break;
		default:
			suit = "";
			break;
		}
		this.cards.setDiscards(new Card(suit,"8"));
		System.out.println("!!!!!!!!Color has been changed to " + suit.toLowerCase() + "!!!!!!!!!" );
	}
	public void drawTwoCards() {
		System.out.println("!!!!!!Next player draw 2 cards!!!!!!");
		turn=(turn+1)%(this.nb_aiplayer+this.nb_humainplayer);
		for(int i=0;i<2;i++) {
		this.player.get(turn).DrawCard(cards);
		}
	}
	public void replay() {
		System.out.println("!!!!!!REPLAY!!!!!!");
		turn=(turn-1+this.nb_humainplayer+this.nb_aiplayer)%(this.nb_aiplayer+this.nb_humainplayer);;
	}
	public void skipPlayer() {
		System.out.println("!!!!!!!SKIP!!!!!!!!!");
		turn=(turn+1)%(this.nb_aiplayer+this.nb_humainplayer);
	}
	/*************************************************/
	public void startGame() {
		//this.cards.showDrawPile();
		System.out.println("----------shuffling cards randomly----------");
		this.cards.shuffleDrawPile();
//		System.out.println("----------Show all cards shuffled-----------");
//		this.cards.showDrawPile();
		
		int count = 0;
		System.out.println("-----------Distribution the cards-----------");
		for(int i=0;i<6;i++) {
			for(int j=0;j<this.player.size();j++) {
				this.player.get(j).setHandCards(this.cards.getDrawPile().get(0));
				this.cards.popCards(this.cards.getDrawPile().get(0));
				count++;
			}
		}
//		System.out.println("--------Remove distributed cards--------");
		System.out.println("distribute "+count+"card(s)");
		
		System.out.println("----------Rest cards----------");
		this.cards.showDrawPile();
		
		ValueOfCard cc = new ValueOfCard();
		System.out.println("------Show handcards for each player-------");
		for (int i=0;i<this.player.size();i++) {
			System.out.println("player "+this.player.get(i).getName()+"'s hand cards:");
			Collections.sort(this.player.get(i).getHandCards(),cc);
			for(int j=0;j<this.player.get(i).getHandCards().size();j++) {
				Card handcards = this.player.get(i).getHandCards().get(j);
				System.out.print(handcards.getRank() + " " + handcards.getSuit() + " | ");
			}System.out.println();
		}
		
		System.out.println("-------Put the first card on the discard pile--------");
		this.cards.setDiscards(this.cards.getDrawPile().get(0));
		this.cards.popCards(this.cards.getDrawPile().get(0));
		
		System.out.println("----------Show discard pile-----------");
		this.cards.showDiscard();
		System.out.println("--------Starting play game------");
		OUT:
		do {
			for(turn=0;turn<this.player.size();turn++) {
				/**********show hand cards for each************/
				System.out.println("Player " + this.player.get(turn).getName() + " has " + this.player.get(turn).getHandCards().size() + " card(s).");
				System.out.println("player "+this.player.get(turn).getName()+"'s hand cards:");
				Collections.sort(this.player.get(turn).getHandCards(),cc);
				for(int n=0;n<this.player.get(turn).getHandCards().size();n++) {
					Card handcards = this.player.get(turn).getHandCards().get(n);
					System.out.print(handcards.getRank() + " " + handcards.getSuit() + " | ");
				}System.out.println();
				/*********************************************/
				try{
					this.player.get(turn).PlayCard(this.player.get(turn), this.cards, this);
					if(this.player.get(turn).getHandCards().size()==0){
						break OUT;
					}
				}catch(Exception e){
					this.player.get(turn).SecondChance(this.player.get(turn), this.cards, this);
					if(this.player.get(turn).getHandCards().size()==0){
						break OUT;
					}
				}finally {
					System.out.println();
				}
			}
		}while(this.cards.getDrawPile().size()!=0);
		
		/**********************************************************************************/
		
		System.out.println("--------End of the game---------");
		System.out.println("----------Show discard pile-----------");
		this.cards.showDiscard();
		System.out.println("------Show hand cards for player-------");
		for (int i=0;i<this.player.size();i++) {
			System.out.println("player "+this.player.get(i).getName()+"'s hand cards:");
			//Order your cards
			Collections.sort(this.player.get(i).getHandCards(),cc);
			for(int j=0;j<this.player.get(i).getHandCards().size();j++) {
				Card handcards = this.player.get(i).getHandCards().get(j);
				System.out.print(handcards.getRank() + " " + handcards.getSuit() + " | ");
			}System.out.println();
		}
		System.out.println("----------Rest cards----------");
		this.cards.showDrawPile();
		
		System.out.println("--------Resault---------");
		System.out.println("Discard Pile : "+this.cards.getDiscards().size());
		System.out.println("Draw Pile : "+this.cards.getDrawPile().size());
		for(int i=0;i<this.player.size();i++){
			if(this.player.get(i).getHandCards().size()==0) {
				System.out.println(this.player.get(i).getName() + " wins!");
			}
		}
		/**********************************************************************************/
	}
}
