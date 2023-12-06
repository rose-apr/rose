/********************************************************************************/
/*										*/
/*		UserStudy.java							*/
/*										*/
/*	Driver program for ROSE user study.					*/
/*										*/
/*	Written by Xuan Wei							*/
/*										*/
/********************************************************************************/


/********************************************************************************/
/*										*/
/*	 Main Program								*/
/*										*/
/********************************************************************************/



package rosestudy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.util.ArrayList;
import java.util.List;



public class UserStudy {


/********************************************************************************/
/*										*/
/*	 Main program								*/
/*										*/
/********************************************************************************/

public static void main(String[] args)
{
   UserStudy main_panel = new UserStudy();

   main_panel.process();
}




/********************************************************************************/
/*										*/
/*	 Private Storage							*/
/*										*/
/********************************************************************************/

private List<StudyPanel>	user_studies;
private JFrame			main_frame;




/********************************************************************************/
/*										*/
/*	 Constructors								*/
/*										*/
/********************************************************************************/

private UserStudy()
{
   user_studies = new ArrayList<>();
   user_studies.add(new DummyPanel());
   user_studies.add(new TutorialPanel());
   user_studies.add(new GcdTaskPanel());
   user_studies.add(new FormatTaskPanel());
   user_studies.add(new BitCountPanel());
   user_studies.add(new IsValidParenthesesPanel());

}



/********************************************************************************/
/*										*/
/*	 Processing methods							*/
/*										*/
/********************************************************************************/

private void process()
{
   main_frame = new JFrame("ROSE User Study");
   main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   GenericPanel top = new GenericPanel();
   top.addGBComponent(new SelectorPanel(),0,0,1,1,10,0);
   boolean enable = true;
   for (StudyPanel pnl : user_studies) {
      pnl.setVisible(enable);
      enable = false;
      top.addGBComponent(pnl,0,1,1,1,10,10);
    }

   main_frame.setContentPane(top);
   main_frame.pack();
   main_frame.setVisible(true);
}



/********************************************************************************/
/*										*/
/*	 Study selector panel							*/
/*										*/
/********************************************************************************/

private static final String welcome_text = "<html>Thank you for taking our user study.";


private class SelectorPanel extends GenericPanel implements ActionListener {

   private JComboBox<StudyPanel> selector_box;

   SelectorPanel() {
      JLabel lbl = new JLabel("ROSE User Study",SwingConstants.CENTER);
      lbl.setFont(lbl.getFont().deriveFont(16f));
      addGBComponent(lbl,0,y_count++,0,1,1,0);
      JLabel lbl1 = new JLabel(welcome_text);
      addGBComponent(lbl1,0,y_count++,0,1,1,0);
      selector_box = addChoice("Select user study","STUDY",user_studies,0,this);
      addSeparator();
    }

   @Override public void actionPerformed(ActionEvent evt) {
      StudyPanel usepnl = (StudyPanel) selector_box.getSelectedItem();
      for (StudyPanel pnl : user_studies) {
	 pnl.setVisible(pnl == usepnl);
       }
      main_frame.pack();
      main_frame.setSize(main_frame.getPreferredSize());
    }

}	// end of inner class SelectorPanel



/********************************************************************************/
/*                                                                              */
/*       Dummy panel for showing no task                                        */
/*                                                                              */
/********************************************************************************/

private static class DummyPanel extends StudyPanel {
   
   DummyPanel() {
      super("Select a Task");
    }
   
   @Override protected String checkArguments()          { return null; }
   @Override protected String compute()                 { return null; }
   
}       // end of inner class DummyPanel



}	// end of class UserStudy
