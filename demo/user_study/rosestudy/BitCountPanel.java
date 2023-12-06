/********************************************************************************/
/*                                                                              */
/*              BitCountPanel.java                                              */
/*                                                                              */
/*              BitCount task                                                   */
/*                                                                              */
/********************************************************************************/

package rosestudy;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;

import java.awt.event.KeyEvent;


public class BitCountPanel extends StudyPanel {

/********************************************************************************/
/*                                                                              */
/*      Private Storage                                                         */
/*                                                                              */
/********************************************************************************/

private JTextField decimal_field;
private JTextField binary_field;
private int decimal_value;



/********************************************************************************/
/*                                                                              */
/* Constructors */
/*                                                                              */
/********************************************************************************/

BitCountPanel() {
   super("Task 3");
   
   JLabel lbl1 = new JLabel("Count how many 1-bits in a number");
   addGBComponent(lbl1, 0, y_count++, 1, 1, 0, 0);
   addSeparator();
   
   decimal_field = addTextField("Decimal to Count", "FIRST", null, 20, null);
   decimal_field.addKeyListener(new CustomKeyListener());
   
   binary_field = addTextField("Binary Representation", "SECOND", null, 20, null);
   binary_field.setEditable(false);
   
   addButton("COUNT", "GO", this);
   
   addResultField();
}


private class CustomKeyListener extends KeyAdapter {
   
   public void keyReleased(KeyEvent e) {
      try {
         decimal_value = Integer.parseInt(decimal_field.getText().trim());
         binary_field.setText(Integer.toBinaryString(decimal_value));
       } 
      catch (NumberFormatException ex) {
         binary_field.setText("");
       }
    }
   
}       // end of inner class CustomKeyListener




/********************************************************************************/
/*                                                                              */
/*      Abstract Method Implementations                                         */
/*                                                                              */
/********************************************************************************/

@Override
protected String checkArguments() {
   try {
      decimal_value = Integer.parseInt(decimal_field.getText().trim());
    } 
   catch (NumberFormatException e) {
      return "Decimal to Count is not a valid integer";
    }
    
   return null;
}


@Override
protected String compute() {
   decimal_value = Integer.parseInt(decimal_field.getText().trim());
   int rslt = MathLibrary.bitcount(decimal_value);
   // set breakpoint here
   return Integer.toString(rslt);
}



}       // end of class BitCountPanel



/* end of BitCountPanel.java */
