/********************************************************************************/
/*                                                                              */
/*              IsValidParenthesesPanel.ja                                      */
/*                                                                              */
/*      IsValidParenthesesPanel task                                            */
/*                                                                              */
/********************************************************************************/

package rosestudy;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.util.regex.Pattern;


public class IsValidParenthesesPanel extends StudyPanel {


/********************************************************************************/
/*                                                                              */
/*      Private Storage                                                         */
/*                                                                              */
/********************************************************************************/

private JTextField string_field;
private String string_value;



/********************************************************************************/
/*                                                                              */
/*      Constructors                                                            */
/*                                                                              */
/********************************************************************************/

IsValidParenthesesPanel() {
   super("Task 4");
   
   JLabel lbl1 = new JLabel("Check if a parentheses string is valid");
   addGBComponent(lbl1, 0, y_count++, 1, 1, 0, 0);
   addSeparator();
   
   string_field = addTextField("Parentheses String to Check", "FIRST", null, 20, null);
   
   addButton("CHECK IF VALID", "GO", this);
   
   addResultField();
}



/********************************************************************************/
/*                                                                              */
/*      Abstract Method Implementations                                         */
/*                                                                              */
/********************************************************************************/

@Override
protected String checkArguments() {
   
   string_value = string_field.getText();
   if (!Pattern.matches("[()]*", string_value))
      return "Please input no characters other than '(' or ')'";
   else
      return null;
}



@Override
protected String compute() {
   boolean rslt = MathLibrary.isValidParenthesization(string_value);
   // set breakpoint here
   return Boolean.toString(rslt);
}



}       // end of class IsValidParenthesisPanel



/* end of IsValidParenthesisPanel.java */
