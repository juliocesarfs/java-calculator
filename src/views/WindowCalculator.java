package views;

import javax.swing.*;

public class WindowCalculator extends JFrame{
    public WindowCalculator(String title) {
        super(title);
        setDefaultCloseOperation(WindowCalculator.EXIT_ON_CLOSE);
        setSize(480, 450);
        setResizable(false);


        getContentPane().add(new MenuCalculator());
        setVisible(true);
    }
}
