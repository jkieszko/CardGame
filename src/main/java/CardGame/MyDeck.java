package CardGame;

import java.util.*;
    //@auth Chase, Dustin
    // provides count of cards in hand
public class MyDeck
{
   private MyCard[] deckCard = new MyCard[52];
   private int index = 0;
  
   public MyDeck()
   {
       int secondIndex = 0;
       for(int i = 0; i < 4; i++)
       {
           for(int j = 0; j < 13; j++)
           {
               MyCard a = new MyCard(i, j);
               deckCard[secondIndex] = a;
               secondIndex++;
           }
       }
   }
           //counts the deck, taking out what is in my hand
   public void shuffle()
   {
       index = 0;
       int counter = 0;
       while(counter < 500)
       {
           Random rand = new Random();
           int x = rand.nextInt(52);
           int y = rand.nextInt(52);
           MyCard stored = deckCard[x];
           deckCard[x] = deckCard[y];
           deckCard[y] = stored;
           counter++;
       }
   }
   public boolean hasNextCard()
   {
       return index < 52;
   }
   public MyCard nextCard()
   {
       if(index < 52)
       {
           index++;
           return deckCard[index - 1];
      
       }
       else
           return null;
   }
}