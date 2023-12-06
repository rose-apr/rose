/********************************************************************************/
/*                                                                              */
/*              GenericPanel.java                                               */
/*                                                                              */
/*      Panel using GridBag layout with helpers                                 */
/*                                                                              */
/********************************************************************************/



package rosestudy;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.util.Collection;
import java.util.Vector;



class GenericPanel extends JPanel
{


/********************************************************************************/
/*                                                                              */
/*      Private Storage                                                         */
/*                                                                              */
/********************************************************************************/

protected int y_count;
private Insets inset_values;




/********************************************************************************/
/*                                                                              */
/*      Constructors                                                            */
/*                                                                              */
/********************************************************************************/

GenericPanel() 
{
   super(new GridBagLayout(),true);
   inset_values = new Insets(2,2,2,2);
   y_count = 0;
}



/********************************************************************************/
/*                                                                              */
/*       Helper methods                                                         */
/*                                                                              */
/********************************************************************************/

protected final GridBagConstraints addGBComponent(Component c,int x,int y,int wd,int ht,int dx,int dy) {
   GridBagConstraints gbc = new GridBagConstraints();
   gbc.gridx = x;
   gbc.gridy = y;
   gbc.gridwidth = wd;
   gbc.gridheight = ht;
   gbc.weightx = dx;
   gbc.weighty = dy;
   gbc.fill = GridBagConstraints.BOTH;
   if (inset_values != null) gbc.insets = inset_values;
   add(c,gbc);
   return gbc;
}



protected final <T> JComboBox<T> addChoice(String lbl,String id,
      Collection<T> data,int idx,ActionListener cb)
{
   JLabel tag = new JLabel(" " + lbl + " : ",SwingConstants.RIGHT);
   addGBComponent(tag,0,y_count,1,1,0,0);
   
   JComboBox<T> cbx = new JComboBox<T>(new Vector<T>());
   if (data != null) {
      for (T t : data) cbx.addItem(t);
    }
   if (data != null && data.size() > 0 && idx >= 0) cbx.setSelectedIndex(idx);
   
   addGBComponent(cbx,1,y_count++,1,1,10,0);
   
   cbx.setActionCommand(id);
   if (cb != null) cbx.addActionListener(cb);
   
   return cbx;
}



protected final JTextField addTextField(String lbl,String id,String val,int wid,
      ActionListener cb1)
{
   JLabel tag = new JLabel(" " + lbl + " : ",SwingConstants.RIGHT);
   addGBComponent(tag,0,y_count,1,1,0,0);
   
   JTextField tfld = new JTextField(val,wid);
   tfld.setActionCommand(id);
   
   if (cb1 != null) {
      tfld.addActionListener(cb1);
    }
   addGBComponent(tfld,1,y_count++,0,1,10,0);
   
   return tfld;
}


protected final JLabel addLabelField(String lbl,String val) 
{
   JLabel tag = new JLabel(" " + lbl + " : ",SwingConstants.RIGHT);
   addGBComponent(tag,0,y_count,1,1,0,0);
   
   JLabel rslt = new JLabel(val);
   addGBComponent(rslt,1,y_count++,0,1,10,0);
   
   return rslt;
}


protected void addSeparator()
{
   addGBComponent(new JSeparator(),0,y_count++,0,1,1,0);
}


protected final JButton addButton(String lbl,String id,ActionListener cb)
{
   JButton btn = new JButton(lbl);
   btn.setActionCommand(id);
   if (cb != null) btn.addActionListener(cb);
   addGBComponent(btn,0,y_count++,0,1,10,0);
   
   return btn;
}




}       // end of class GenericPanel




/* end of GenericPanel.java */

