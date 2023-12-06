/********************************************************************************/
/*                                                                              */
/*              StudyPanel.java                                                 */
/*                                                                              */
/*      Generic panel for a user study                                          */
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

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

abstract class StudyPanel extends GenericPanel implements ActionListener
{



/********************************************************************************/
/*                                                                              */
/*      Private Storage                                                         */
/*                                                                              */
/********************************************************************************/

private String panel_name;
private JLabel result_field;


/********************************************************************************/
/*                                                                              */
/*      Constructors                                                            */
/*                                                                              */
/********************************************************************************/

StudyPanel(String name)
{
   panel_name = name;
   result_field = null;
   setVisible(false);
}



/********************************************************************************/
/*                                                                              */
/*      Setup methods                                                           */
/*                                                                              */
/********************************************************************************/

protected void addResultField()
{
   addSeparator();
   result_field = addLabelField("RESULT",null);
}


/********************************************************************************/
/*                                                                              */
/*       Access methods                                                         */
/*                                                                              */
/********************************************************************************/

// for button display purposes

@Override public String toString()
{
   return panel_name;
}


/********************************************************************************/
/*                                                                              */
/*       Handle Compute button                                                  */
/*                                                                              */
/********************************************************************************/

@Override public void actionPerformed(ActionEvent evt)
{
   String error = checkArguments();
   if (error != null) {
      JOptionPane.showMessageDialog(null, error);
      return;
    }
   
   String rslt  = compute();
   
   if (result_field != null) {
      result_field.setBorder(new LineBorder(Color.GREEN,3));
      result_field.setText(rslt);
    }
}


abstract protected String checkArguments();

abstract protected String compute();




}       // end of class StudyPanel




/* end of StudyPanel.java */

