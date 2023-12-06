/********************************************************************************/
/*                                                                              */
/*              TutorialPanel.java                                              */
/*                                                                              */
/*      Panel for the study tutorial                                            */
/*                                                                              */
/********************************************************************************/



package rosestudy;

import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class TutorialPanel extends StudyPanel implements ActionListener
{


/********************************************************************************/
/*                                                                              */
/*      Private Storage                                                         */
/*                                                                              */
/********************************************************************************/

private JTextField      first_field;
private JTextField      second_field;
private float           first_value;
private float           second_value;



/********************************************************************************/
/*                                                                              */
/*      Constructors                                                            */
/*                                                                              */
/********************************************************************************/

TutorialPanel()
{
   super("Tutorial");
   
   JLabel lbl1 = new JLabel("Compute the MAX of two numbers",SwingConstants.CENTER);
   addGBComponent(lbl1,0,y_count++,1,1,0,0);
   addSeparator();
   
   first_field = addTextField("First Number","FIRST",null,20,null);
   second_field = addTextField("Second Number","SECOND",null,20,null);
   
   addButton("COMPUTE MAX","GO",this);
   
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
      first_value = Float.parseFloat(first_field.getText().trim());
    }
   catch (NumberFormatException e) {
      return "First number is not a valid floating point number";
    }
   try {
      second_value = Float.parseFloat(second_field.getText().trim());
    }
   catch (NumberFormatException e) {
      return "Second number is not a valid floating point number";
    }
   
   return null;
}


@Override protected String compute()
{
   float rslt = MathLibrary.max(first_value,second_value);
   // set breakpoint here
   assert rslt >= first_value && rslt >= second_value;
   
   return Float.toString(rslt);
}



}       // end of class TutorialPanel




/* end of TutorialPanel.java */

