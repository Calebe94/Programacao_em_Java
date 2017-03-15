import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ex2{
  public static void main(String[] args) {
    JFrame jframe = new JFrame("Layout 2");
    JButton jbutton = new JButton("Component 1");
    JButton jbutton1 = new JButton("Component 2");
    JButton jbutton2 = new JButton("Component 3");
    JPanel jpanel = new JPanel();

    jpanel.setLayout(new GridBagLayout());

    GridBagConstraints my_grid_bag = new GridBagConstraints();
    my_grid_bag.weightx = 0.5;
    my_grid_bag.fill= GridBagConstraints.HORIZONTAL;
    my_grid_bag.gridx = 0;
    my_grid_bag.gridy = 0;
    jpanel.add(jbutton,my_grid_bag);

    my_grid_bag.fill = GridBagConstraints.HORIZONTAL;
    my_grid_bag.weightx=0.5;
    my_grid_bag.gridx = 1;
    my_grid_bag.gridy = 0;
    jpanel.add(jbutton1,my_grid_bag);

    my_grid_bag.fill = GridBagConstraints.HORIZONTAL;
    my_grid_bag.weightx=0.5;
    my_grid_bag.gridx = 2;
    my_grid_bag.gridy = 0;
    jpanel.add(jbutton2,my_grid_bag);

    jframe.add(jpanel);

    jframe.pack();
    jframe.setSize(650,90);
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setVisible(true);
  }
}
