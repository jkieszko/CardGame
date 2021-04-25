package CardGame;
 //@author Jacob Kieszkowski
	// access the hand count and total value
public class MyHand
{
   public int counter = 0;
   private MyCard[] cardHand;
  
   public MyHand()
   {
       cardHand = new MyCard[20];
   }
   public void add(MyCard card)
   {
       cardHand[counter++] = card;
   }
   public MyCard getTopCard()
   {
       return cardHand[0];
   }
   public int valueOf()
   {
       int total = 0;
       int cardLevel = 0;
       int secondCount = counter;
       int access = 0;
       for(int c = 0; c < secondCount; c++)
       {
           cardLevel = cardHand[c].valueOf();
           total += cardLevel;
           if(cardLevel == 11)
               access++;
       }
       while(access > 0 && total > 21)
       {
           total -= 10;
           access--;
       }      
       return total;
   }
   public boolean checkBlackJack()
   {
       int total = cardHand[0].valueOf() + cardHand[1].valueOf();
       return total == 21;
   }

   public boolean checkBust()
   {
       return valueOf() > 21;
   }
   public String toString()
   {
       String string ="";
       int secondCount = counter;
       for(int c = 0; c < secondCount; c++)
           string += cardHand[c].toString() + "\n";
       if(checkBust())
           string += "\n\n Bust";
       if(checkBlackJack())
           string += "\n\n Blackjack";
       return string;
   }
}