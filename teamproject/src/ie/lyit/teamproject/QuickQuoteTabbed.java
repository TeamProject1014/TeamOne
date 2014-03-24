package ie.lyit.teamproject;
import java.awt.*;
import javax.swing.*;

public class QuickQuoteTabbed extends JFrame{

   //Decalre tabs
   private JTabbedPane quickQuoteTabs;
   private External external;
   private Floor internal;
   private Walls walls;
   private Roof roof;  
   
   
   
   //Constructor
   public QuickQuoteTabbed()
   {
      quickQuoteTabs = new JTabbedPane();
      
      //externalWalls tab
      external = new External();
      quickQuoteTabs.add(external, "External");
      quickQuoteTabs.setToolTipTextAt(0, "External");
      
      
      //internal tab
      internal = new Floor();
      quickQuoteTabs.add(internal, "Floor");
      quickQuoteTabs.setToolTipTextAt(0, "internal");
      
      //Walls
      walls = new Walls();
      quickQuoteTabs.add(walls, "walls");
      quickQuoteTabs.setToolTipTextAt(0, "walls");
      
      //roof
      roof = new Roof();
      quickQuoteTabs.add(roof, "roof");
      quickQuoteTabs.setToolTipTextAt(0, "roof");
      
      getContentPane().add(quickQuoteTabs, BorderLayout.CENTER);
      
      }
      
      public static void main (String [] args)
      {
         QuickQuoteTabbed frame = new QuickQuoteTabbed();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setTitle("Quick Quote");
         frame.setSize(460, 380);
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);

        }
        }