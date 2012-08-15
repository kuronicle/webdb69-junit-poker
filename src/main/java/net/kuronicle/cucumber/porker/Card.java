package net.kuronicle.cucumber.porker;

public class Card {
    
    public enum Suit {
        DIAMONDS, SPADES, HEARTS, CLUBS;
    }
    
    public final int no;
    public final Suit suit;
    
    Card(Suit suit, int no){
        this.suit = suit;
        this.no = no;
    }
    
    public static Card get(char suit, int no) {
        if( no < 1 || 12 < no ) throw new IllegalArgumentException();
        
        switch (suit) {
        case 'D':
            return new Card(Suit.DIAMONDS, no);
        case 'S':
            return new Card(Suit.SPADES, no);
        case 'H':
            return new Card(Suit.SPADES, no);
        case 'C':
            return new Card(Suit.CLUBS, no);
        default:
            throw new IllegalArgumentException();
        }
    }

}
