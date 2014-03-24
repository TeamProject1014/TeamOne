package ie.lyit.teamproject;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
					
// FastFoodMenu IS-A JPanel ==> Inheritance
public class Floor extends JPanel{
   private JTextField txtLength;
   //private JTextField txtMatWidth;
   private JTextField txtMatWidth;
   private JTextField txtMatNeeded;
   private JTextField txtwidth;
   private JTextField txtWidth1;
   private JTextField txtMatLength1;
   private JTextField txtMatRequired;
   private JTextField textField_9;
   private JTextField textField_10;
   private JTextField textField_11;
   private JTextField textField_12;
   private JTextField textField_13;
   float length, width, matLength, matWidth, total, matTotal, matNeeded;
   private JTextField txtMatWidth1;
   
   //Constructor
   public Floor()
   {
   setLayout(null);
   
   JPanel panel = new JPanel();
   panel.setBounds(224, 5, 1, 1);
   panel.setLayout(null);
   panel.setBorder(new TitledBorder(null, "Dimensions", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
   add(panel);
   
   JButton button = new JButton("Calculate");
   button.setBounds(52, 166, 89, 23);
   panel.add(button);
   
   JLabel label = new JLabel("Length:");
   label.setBounds(10, 31, 46, 14);
   panel.add(label);
   
   JLabel label_1 = new JLabel("Width:");
   label_1.setBounds(10, 56, 46, 14);
   panel.add(label_1);
   
   txtLength = new JTextField();
   txtLength.setColumns(10);
   txtLength.setBounds(102, 28, 86, 20);
   panel.add(txtLength);
   
   //txtWidth = new JTextField();
   //txtWidth.setColumns(10);
   //txtWidth.setBounds(102, 53, 86, 20);
   //panel.add(txtWidth);
   
   JLabel label_2 = new JLabel("Length of Material:");
   label_2.setBounds(10, 81, 98, 14);
   panel.add(label_2);
   
   txtMatWidth = new JTextField();
   txtMatWidth.setColumns(10);
   txtMatWidth.setBounds(102, 78, 86, 20);
   panel.add(txtMatWidth);
   
   JRadioButton radioButton = new JRadioButton("Tile");
   radioButton.setBounds(105, 136, 58, 23);
   panel.add(radioButton);
   
   JRadioButton radioButton_1 = new JRadioButton("Wood");
   radioButton_1.setSelected(true);
   radioButton_1.setBounds(52, 136, 68, 23);
   panel.add(radioButton_1);
   
   JLabel label_3 = new JLabel("Type:");
   label_3.setBounds(10, 141, 46, 14);
   panel.add(label_3);
   
   JLabel label_4 = new JLabel("Width of Material:");
   label_4.setBounds(10, 106, 98, 14);
   panel.add(label_4);
   
   txtMatWidth = new JTextField();
   txtMatWidth.setColumns(10);
   txtMatWidth.setBounds(102, 103, 86, 20);
   panel.add(txtMatWidth);
   
   JPanel panel_1 = new JPanel();
   panel_1.setLayout(null);
   panel_1.setBorder(new TitledBorder(null, "Dimensions", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
   panel_1.setBounds(10, 41, 198, 200);
   add(panel_1);
   
   JButton btnCalculate = new JButton("Calculate");
   btnCalculate.setBounds(52, 166, 89, 23);
   panel_1.add(btnCalculate);
   
   JLabel label_5 = new JLabel("Length:");
   label_5.setBounds(10, 31, 46, 14);
   panel_1.add(label_5);
   
   JLabel label_6 = new JLabel("Width:");
   label_6.setBounds(10, 56, 46, 14);
   panel_1.add(label_6);
   
   txtMatNeeded = new JTextField();
   txtMatNeeded.setColumns(10);
   txtMatNeeded.setBounds(102, 28, 86, 20);
   panel_1.add(txtMatNeeded);
   
   txtwidth = new JTextField();
   txtwidth.setColumns(10);
   txtwidth.setBounds(102, 53, 86, 20);
   panel_1.add(txtwidth);
   
   JLabel label_7 = new JLabel("Length of Material:");
   label_7.setBounds(10, 81, 98, 14);
   panel_1.add(label_7);
   
   txtWidth1 = new JTextField();
   txtWidth1.setColumns(10);
   txtWidth1.setBounds(102, 78, 86, 20);
   panel_1.add(txtWidth1);
   
   JRadioButton radioButton_2 = new JRadioButton("Tile");
   radioButton_2.setBounds(105, 136, 58, 23);
   panel_1.add(radioButton_2);
   
   JRadioButton radioButton_3 = new JRadioButton("Wood");
   radioButton_3.setSelected(true);
   radioButton_3.setBounds(52, 136, 68, 23);
   panel_1.add(radioButton_3);
   
   JLabel label_8 = new JLabel("Type:");
   label_8.setBounds(10, 141, 46, 14);
   panel_1.add(label_8);
   
   JLabel label_9 = new JLabel("Width of Material:");
   label_9.setBounds(10, 106, 98, 14);
   panel_1.add(label_9);
   
   txtMatWidth1 = new JTextField();
   txtMatWidth1.setBounds(102, 106, 86, 20);
   panel_1.add(txtMatWidth1);
   txtMatWidth1.setColumns(10);
   
   //txtMatLength = new JTextField();
   //txtMatLength.setColumns(10);
   //txtMatLength.setBounds(102, 103, 86, 20);
   //panel_1.add(txtMatLength);
   
   JPanel panel_2 = new JPanel();
   panel_2.setLayout(null);
   panel_2.setBorder(new TitledBorder(null, "Materials Required", TitledBorder.LEADING, TitledBorder.TOP, null, null));
   panel_2.setBounds(224, 41, 206, 200);
   add(panel_2);
   
   JLabel label_10 = new JLabel("Tiles/Wood Meters Sq:");
   label_10.setBounds(10, 30, 108, 14);
   panel_2.add(label_10);
   
   JLabel label_11 = new JLabel("Grout:");
   label_11.setBounds(10, 80, 63, 14);
   panel_2.add(label_11);
   
   JLabel label_12 = new JLabel("Rolls of Underlay:");
   label_12.setBounds(10, 55, 108, 14);
   panel_2.add(label_12);
   
   txtMatRequired = new JTextField();
   txtMatRequired.setEditable(false);
   txtMatRequired.setColumns(10);
   txtMatRequired.setBounds(133, 27, 63, 20);
   panel_2.add(txtMatRequired);
   
   textField_9 = new JTextField();
   textField_9.setEditable(false);
   textField_9.setColumns(10);
   textField_9.setBounds(133, 52, 63, 20);
   panel_2.add(textField_9);
   
   textField_10 = new JTextField();
   textField_10.setEditable(false);
   textField_10.setColumns(10);
   textField_10.setBounds(133, 77, 63, 20);
   panel_2.add(textField_10);
   
   JLabel label_13 = new JLabel("Adhesive:");
   label_13.setBounds(10, 105, 52, 14);
   panel_2.add(label_13);
   
   textField_11 = new JTextField();
   textField_11.setEditable(false);
   textField_11.setColumns(10);
   textField_11.setBounds(133, 102, 63, 20);
   panel_2.add(textField_11);
   
   JLabel label_14 = new JLabel("Price:");
   label_14.setBounds(10, 130, 52, 14);
   panel_2.add(label_14);
   
   textField_12 = new JTextField();
   textField_12.setEditable(false);
   textField_12.setColumns(10);
   textField_12.setBounds(133, 127, 63, 20);
   panel_2.add(textField_12);
   
   JLabel lblNewLabel = new JLabel("Total Price:");
   lblNewLabel.setBounds(136, 252, 72, 14);
   add(lblNewLabel);
   
   textField_13 = new JTextField();
   textField_13.setBounds(224, 249, 86, 20);
   add(textField_13);
   textField_13.setColumns(10);
   
 //Add Calculations
 	//Add action listener to button
   btnCalculate.addActionListener(new ActionListener()
  {

      public void actionPerformed(ActionEvent e)
      {
    	  
    	  try
    	  {
    		//Get total size of floor in square meters
   		   length = Float.parseFloat (txtMatNeeded.getText());
   		   width = Float.parseFloat (txtwidth.getText());
   		   total = (int)length * width;
   		   
   		   //Get total size of material
   		   matWidth = Float.parseFloat (txtWidth1.getText());
		   matLength = Float.parseFloat (txtMatWidth1.getText());
		   matTotal = (int)matLength * matWidth;
		   
		   //Calculate material needed
		   matNeeded = total/matTotal;
		   
   		   
   		   //set text
		   txtMatRequired.setText(" " + matNeeded);
   		   
    		  
    	  }
    	  
    	  catch(NumberFormatException nfe) 
    	  {
    		  txtLength.setText("0");
    		  txtwidth.setText("0");
    		  txtWidth1.setText("0");
    		  txtMatWidth.setText("0");
    		  txtMatWidth.setText("0");
    		  txtMatNeeded.setText("0");
    
    	  }
    	  
    	  
        
   	   
      }
  
   	   });
   	   }
   }
   
   