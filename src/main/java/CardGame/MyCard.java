package CardGame;

//Author Joseph Branham
//Shows card suits and values
public class MyCard
{
   private int suit;
   private int rank;
   private static final String[] ranks = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Jack", "Queen", "King" };
   private static final String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };
  
   public MyCard(int suit, int rank)
   {
       this.rank = rank;
       this.suit = suit;
   }
   public int valueOf()
   {
       //returns the value of the Card
       if (this.rank == 0)
           return 11;
      
       if (this.rank < 10)
           return rank + 1;
      
       if(this.rank >= 10)
           return 10;
      
       else
           return 0;      
   }
   public String toString()
   {
      // returns a String for Card representation in Jack of Diamonds, Ace of Clubs,
      // etc."
       return ranks[this.rank] + " of " + suits[this.suit];
   }
}