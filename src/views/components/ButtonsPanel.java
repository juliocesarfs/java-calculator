package views.components;

import javax.swing.*;
import java.awt.*;

public class ButtonsPanel extends JPanel {

    public ButtonsPanel() {
        setBackground(Color.BLACK);
//        GridLayout gridButtonsLayout = new GridLayout();
//        gridButtonsLayout.setRows(1);
//        gridButtonsLayout.setColumns(2);
//        gridButtonsLayout.setHgap(8);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.black);
    }
}
