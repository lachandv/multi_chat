package IHM;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;

class ImageListCellRenderer implements ListCellRenderer{

   public Component getListCellRendererComponent(JList jlist, Object value, int cellIndex,
                                                boolean isSelected,
                                                boolean cellHasFocus)
  {
    if (value instanceof JPanel)
    {
      Component component = (Component) value;
      component.setForeground (Color.BLUE);
      component.setBackground(Color.WHITE);
      component.setBackground (isSelected ? UIManager.getColor("Table.focusCellForeground") : Color.white);
      return component;
    }
    else
    {
      return new JLabel("???");
    }
  }
}