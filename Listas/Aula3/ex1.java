import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ex1{
  public static void main(String[] args) {
    JFrame jframe = new JFrame("Layout 1");
    JButton jbutton = new JButton("Component 1");
    JPanel jpanel = new JPanel();

    jpanel.setLayout(new GridBagLayout());

    GridBagConstraints my_grid_bag = new GridBagConstraints();
    my_grid_bag.fill = GridBagConstraints.HORIZONTAL;
    my_grid_bag.ipady = 40;
    my_grid_bag.weightx = 0.0;
    my_grid_bag.gridwidth = 3;
    my_grid_bag.gridx = 0;
    my_grid_bag.gridy=1;
    jpanel.add(jbutton,my_grid_bag);
    jframe.add(jpanel);

    jframe.pack();
    jframe.setSize(300,150);
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setVisible(true);
  }
}
