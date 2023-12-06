/********************************************************************************/
/*                                                                              */
/*              GcdTaskPanel.java                                               */
/*                                                                              */
/*      Try computing GCD of two numbers                                        */
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

class GcdTaskPanel extends StudyPanel
{


/********************************************************************************/
/*                                                                              */
/*      Private Storage                                                         */
/*                                                                              */
/********************************************************************************/

private JTextField      first_field;
private JTextField      second_field;
private int             first_value;
private int             second_value;




/********************************************************************************/
/*                                                                              */
/*      Constructors                                                            */
/*                                                                              */
/********************************************************************************/

GcdTaskPanel()
{
   super("Task 1");
   
   JLabel lbl1 = new JLabel("Compute the GCD of two numbers");
   addGBComponent(lbl1,0,y_count++,1,1,0,0);
   addSeparator();
   
   first_field = addTextField("First Number","FIRST",null,20,null);
   second_field = addTextField("Second Number","SECOND",null,20,null);
   
   addButton("COMPUTE GCD","GO",this);
   
   addResultField();
}



/********************************************************************************/
/*                                                                              */
/*       Action methods                                                         */
/*                                                                              */
/********************************************************************************/


@Override protected String checkArguments()
{
   try {
      first_value = Integer.parseInt(first_field.getText().trim());
    }
   catch (NumberFormatException e) {
      return "First number is not a valid integer";
    }
   try {
      second_value = Integer.parseInt(second_field.getText().trim());
    }
   catch (NumberFormatException e) {
      return "Second number is not a valid integer";
    }
   
   return null;
}



@Override protected String compute()
{
   int rslt = MathLibrary.gcd(first_value,second_value);
   // set breakpoint here
   return Integer.toString(rslt);
}







}       // end of class GcdTaskPanel




/* end of GcdTaskPanel.java */

