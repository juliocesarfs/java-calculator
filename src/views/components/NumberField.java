package views.components;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.concurrent.Flow;

public class NumberField extends JPanel {

    private JTextField numberText;

    public JTextField getNumberTxt() {
        return numberText;
    }

    public void setNumberTxt(JTextField numberTxt) {
        this.numberText = numberTxt;
    }

    public NumberField() {
        setLayout(new FlowLayout());
        setBackground(Color.BLACK);
        setBorder(null);

        numberText = new JTextField();
        numberText.setBackground(new Color(47, 27, 37));
        numberText.setEnabled(false);
        numberText.setPreferredSize(new Dimension(480, 50));
        numberText.setFont(new Font(null, Font.BOLD, 20));
        numberText.setHorizontalAlignment(JTextField.RIGHT);
        numberText.setForeground(Color.gray);
        numberText.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        add(numberText);
    }


}
