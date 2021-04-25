package CardGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 //@auth Chase, Dustin
 // create gui for card game
public class BlackJackGUI extends JFrame
{
   private static final long serialVersionUID = 1L;
   private Container containerP;
   private JPanel buttonP = new JPanel();
   private JPanel result = new JPanel();
  
   private JButton playB = new JButton("Play ");
   private JButton hitB = new JButton("Hit ");
   private JButton standB = new JButton("Stand");
  
   private JTextArea player1 = new JTextArea();
   private JTextArea dealer1 = new JTextArea();

   // Construct the frame
   public BlackJackGUI()
   {
       containerP = getContentPane();
       containerP.setLayout(new BorderLayout());
       containerP.setLayout(new BorderLayout());
       setSize(new Dimension(800, 600));
       setTitle("BlackJack");

       containerP.add(buttonP, BorderLayout.SOUTH);
       buttonP.add(playB, null);
       buttonP.add(hitB, null);
       buttonP.add(standB, null);
       containerP.add(result, BorderLayout.CENTER);
       result.setLayout(new FlowLayout());
       result.add(player1, null);
       result.add(dealer1, null);
       hitB.setEnabled(false);
       standB.setEnabled(false);
       player1.setText(" ");
       dealer1.setText(" ");
       int width = getWidth();
       int height = getHeight();
       player1.setPreferredSize(new Dimension (width / 2 - 20, height));
       dealer1.setPreferredSize(new Dimension (width / 2 - 20, height));
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
   }

   public void setPlay(ActionListener listener)
   {
       playB.addActionListener(listener);
   }

   public void setHit(ActionListener listener)
   {
       hitB.addActionListener(listener);
   }

   public void setStand(ActionListener listener)
   {
       standB.addActionListener(listener);
   }

   public void showHand(MyHand hand)
   {
       player1.setText("Player:\n" + hand.valueOf() + "\n" + hand);
   }

   public void showDealer(MyHand hand)
   {
       dealer1.setText("Dealer:\n" + hand.valueOf() + "\n" + hand);
   }

   public void showDealerCard(MyCard card)
   {
       dealer1.setText("Dealer Shows:\n" + card);
   }

   public void showResult(String result)
   {
       player1.setText(player1.getText() + "\n\n" + result);
   }

   public void enableHitAndStandButton()
   {
       playB.setEnabled(false);
       hitB.setEnabled(true);
       standB.setEnabled(true);
   }

   public void enablePlayButton()
   {
       playB.setEnabled(true);
       hitB.setEnabled(false);
       standB.setEnabled(false);
}
}