/********************************************************************************/
/*                                                                              */
/*              FormatTaskPanel.java                                            */
/*                                                                              */
/*      Number formatting task                                                  */
/*                                                                              */
/********************************************************************************/

/*********************************************************************************
 *                                                                               *
 *                        All Rights Reserved                                    *
 *                                                                               *
 * This program and the accompanying materials are made available under the      *
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, *
 * and is available at                                                           *
 *      http://www.eclipse.org/legal/epl-v10.html                                *
 *                                                                               *
 ********************************************************************************/

/* SVN: $Id$ */



package rosestudy;

import javax.swing.JLabel;
import javax.swing.JTextField;

class FormatTaskPanel extends StudyPanel
{


/********************************************************************************/
/*                                                                              */
/*      Private Storage                                                         */
/*                                                                              */
/********************************************************************************/

private JTextField      number_field;
private JTextField      width_field;
private JTextField      pad_field;
private int             number_value;
private int             width_value;
private char            pad_char;




/********************************************************************************/
/*                                                                              */
/*      Constructors                                                            */
/*                                                                              */
/********************************************************************************/

FormatTaskPanel()
{
   super("Task 2");
   
   JLabel lbl1 = new JLabel("Append a number with a character to a fixed width.");
   addGBComponent(lbl1,0,y_count++,1,1,0,0);
   addSeparator();
   
   number_field = addTextField("Number","FIRST",null,20,null);
   width_field = addTextField("Width","SECOND",null,20,null);
   pad_field = addTextField("Pad Character","PAD",null,4,null);
   
   addButton("FORMAT NUMBER","GO",this);
   
   addResultField();
}


/********************************************************************************/
/*                                                                              */
/*       Abstract Method Implementations                                        */
/*                                                                              */
/********************************************************************************/


@Override protected String checkArguments()
{
   try {
       number_value = Integer.parseInt(number_field.getText().trim());
    }
   catch (NumberFormatException e) {
      return "Number is not a valid integer";
    }
   try {
      width_value = Integer.parseInt(width_field.getText().trim());
    }
   catch (NumberFormatException e) {
      return "Width is not a valid integer";
    }
   String padstr = pad_field.getText();
   if (padstr.length() == 0) return "No pad character given";
   else if (padstr.length() > 1) return "Pad character should only be one character";
   pad_char = padstr.charAt(0);
   
   return null;
}




@Override protected String compute()
{
   MathLibrary.clearBuffer();
   String rslt = MathLibrary.appendFixedWidthPadRight(number_value,width_value,pad_char);
   // set breakpoint here
   String s = Integer.toString(number_value);
   // sanity check
   assert rslt.length() == width_value && (rslt.contains(s) || s.contains(rslt));
   
   return rslt;
}



}       // end of class FormatTaskPanel




/* end of FormatTaskPanel.java */

