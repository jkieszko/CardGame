package CardGame;



import java.awt.event.*;

//Author Joseph Branham
//Shows game action. Win, push, lose.

public class BlackJackGame
{
   public MyHand playerCard;
   public MyHand dealerCard;
   public MyDeck deckOfCards;
   public BlackJackGUI guiVersion;

   public BlackJackGame()
   {
       guiVersion = new BlackJackGUI();
       guiVersion.setPlay(new PlayAction());
       guiVersion.setHit(new HitAction());
       guiVersion.setStand(new StandAction());
       guiVersion.enablePlayButton();
   }
  
   class PlayAction implements ActionListener
   {
       public void actionPerformed (ActionEvent ae)
       {
           deckOfCards = new MyDeck();
           deckOfCards.shuffle();
           playerCard = new MyHand();
           dealerCard = new MyHand();
           playerCard.add(deckOfCards.nextCard());
           dealerCard.add(deckOfCards.nextCard());
           playerCard.add(deckOfCards.nextCard());
           dealerCard.add(deckOfCards.nextCard());
           guiVersion.showHand(playerCard);
           guiVersion.showDealerCard(dealerCard.getTopCard());
          
           if(!playerCard.checkBlackJack() && !dealerCard.checkBlackJack()
                   && !playerCard.checkBust())
           {
               guiVersion.enableHitAndStandButton();
           }
           if(playerCard.checkBlackJack() || dealerCard.checkBlackJack() ||
                   playerCard.checkBust())
               finishGame();
       }
   }

   class HitAction implements ActionListener
   {
       public void actionPerformed (ActionEvent ae)
       {
           if(!playerCard.checkBust() && playerCard.valueOf() != 21)
           {
               playerCard.add(deckOfCards.nextCard());
               guiVersion.showHand(playerCard);
           }
           if(playerCard.checkBust() || playerCard.valueOf() == 21)
               finishGame();
       }
   }
      
   class StandAction implements ActionListener
   {
       public void actionPerformed (ActionEvent ae)
       {
           finishGame();
       }
   }
   private void finishGame()
   {
       if(playerCard.checkBlackJack())
       {
           guiVersion.showDealer(dealerCard);
           guiVersion.showHand(playerCard);
           guiVersion.showResult("Win");
       }
       else if(dealerCard.checkBlackJack() && playerCard.checkBlackJack())
       {
           guiVersion.showDealer(dealerCard);
           guiVersion.showHand(playerCard);
           guiVersion.showResult("Push");
       }
       else if(dealerCard.checkBlackJack())
       {
           guiVersion.showDealer(dealerCard);
           guiVersion.showHand(playerCard);
           guiVersion.showResult("Lose");
       }
       else if(playerCard.checkBust())
       {
           guiVersion.showDealer(dealerCard);
           guiVersion.showHand(playerCard);
           guiVersion.showResult("Lose");
       }
       else
       {
           while(dealerCard.valueOf() < 17 && !dealerCard.checkBust())
           {
               dealerCard.add(deckOfCards.nextCard());
           }
           if(dealerCard.checkBust())
           {
               guiVersion.showDealer(dealerCard);
               guiVersion.showHand(playerCard);
               guiVersion.showResult("Win");
           }
           else if(dealerCard.checkBlackJack())
           {
               guiVersion.showDealer(dealerCard);
               guiVersion.showHand(playerCard);
               guiVersion.showResult("Lose");
           }
           else if(dealerCard.valueOf() == playerCard.valueOf())
           {
               guiVersion.showDealer(dealerCard);
               guiVersion.showHand(playerCard);
               guiVersion.showResult("Push");
           }
           else if(dealerCard.valueOf() > playerCard.valueOf())
           {
               guiVersion.showDealer(dealerCard);
               guiVersion.showHand(playerCard);
               guiVersion.showResult("Lose");
           }
           else if(playerCard.valueOf() > dealerCard.valueOf())
           {
               guiVersion.showDealer(dealerCard);
               guiVersion.showHand(playerCard);
               guiVersion.showResult("Win");}
           }
       guiVersion.enablePlayButton();
   }
  
   public static void main(String[] s)
   {
       new BlackJackGame();
   }
}